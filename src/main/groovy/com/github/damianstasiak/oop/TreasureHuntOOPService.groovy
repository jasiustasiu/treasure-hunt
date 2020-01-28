package com.github.damianstasiak.oop

import java.util.stream.Stream


class TreasureHuntOOPService {

    Set<Cell> findTreasure(String input) {
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

        while (true) {
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
    }
}
