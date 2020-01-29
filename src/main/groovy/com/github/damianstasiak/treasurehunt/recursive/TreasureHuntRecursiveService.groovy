package com.github.damianstasiak.treasurehunt.recursive

import com.github.damianstasiak.treasurehunt.TreasureHuntService

import javax.inject.Singleton

@Singleton
class TreasureHuntRecursiveService implements TreasureHuntService {

    List<String> getPathToTreasure(String input, String startCoordinates = "11") {
        def matrix = [[], [], [], [], []] as String[][]
        def i = 0
        input.splitEachLine(' ') {
            matrix[i++] = it
        }
        return getPathToTreasureRecursive(matrix, startCoordinates, new LinkedHashSet<String>())
    }

    private List<String> getPathToTreasureRecursive(String[][] matrix, String coordinates, Set<String> visited) {
        if (!visited.add(coordinates)) {
            return Collections.emptyList()
        }
        def row = coordinates[0].toInteger() - 1
        def column = coordinates[1].toInteger() - 1
        def nextCoordinates = matrix[row][column]
        if (coordinates == nextCoordinates) {
            return visited.toList()
        }
        return getPathToTreasureRecursive(matrix, nextCoordinates, visited)
    }
}
