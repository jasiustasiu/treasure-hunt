package com.github.damianstasiak

import groovy.transform.CompileStatic

import java.util.stream.Stream

@CompileStatic
class Application {
    static void main(String[] args) {
        //Micronaut.run(Application)
        def input = """55 14 25 52 21
44 31 11 53 43
24 13 45 12 34
42 22 43 32 41
51 23 33 54 15"""
//        def treasurePath = findTreasure(input)
        def treasurePath = findTreasureRecursive(input)
        if (treasurePath.size() > 0)
            print(treasurePath)
        else print("NO TREASURE")
    }

    static Set<Cell> findTreasure(String input) {
        def matrix = [[], [], [], [], []] as Cell[][]
        def rows = input.split("\n")
        def i = 0
        for (row in rows) {
            matrix[i++] = Stream.of(row.split(" ")).map { new Cell(Integer.parseInt(it[0]) - 1, Integer.parseInt(it[1]) - 1) }.toArray() as Cell[]
        }
        def visited = new LinkedHashSet<Cell>()
        def row = 0
        def column = 0
        def current = matrix[0][0]

        while (visited.size() <= 26) {
            def coordinates = new Cell(row, column)
            if (visited.contains(coordinates))
                return Collections.emptySet()
            visited.add(coordinates)
            if (current == coordinates) {
                return visited
            }
            row = current.row
            column = current.column
            current = matrix[current.row][current.column]
        }
        return Collections.emptySet()
    }

    static Set<String> findTreasureRecursive(String input) {
        def matrix = [[], [], [], [], []] as String[][]
        def rows = input.split("\n")
        for (int i = 0; i < 5; i++) {
            matrix[i] = rows[i].split(" ")
        }
        return findTreasureRecursive(matrix, "11", new LinkedHashSet<String>())
    }

    static Set<String> findTreasureRecursive(String[][] matrix, String coordinates, Set<String> visited) {
        if (visited.size() > 25) {
            Collections.emptySet()
        }
        if (visited.contains(coordinates))
            return Collections.emptySet()
        visited.add(coordinates)
        def row = coordinates[0].toInteger() - 1
        def column = coordinates[1].toInteger() -1
        def current = matrix[row][column]
        if (current == coordinates) {
            return visited
        }

        return findTreasureRecursive(matrix, current, visited)
    }
}