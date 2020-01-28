package com.github.damianstasiak.recursive


class TreasureHuntService {

   final START_COORDINATES = "11"

    List<String> getPathToTreasure(String input) {
        def matrix = [[], [], [], [], []] as String[][]
        def rows = input.split("\n")
        for (int i = 0; i < 5; i++) {
            matrix[i] = rows[i].split(" ")
        }
        return getPathToTreasureRecursive(matrix, START_COORDINATES, new LinkedHashSet<String>())
    }

    private List<String> getPathToTreasureRecursive(String[][] matrix, String coordinates, Set<String> visited) {
        if (visited.contains(coordinates))
            return Collections.emptyList()
        visited.add(coordinates)
        def row = coordinates[0].toInteger() - 1
        def column = coordinates[1].toInteger() -1
        def current = matrix[row][column]
        if (current == coordinates) {
            return visited.toList()
        }
        return getPathToTreasureRecursive(matrix, current, visited)
    }
}
