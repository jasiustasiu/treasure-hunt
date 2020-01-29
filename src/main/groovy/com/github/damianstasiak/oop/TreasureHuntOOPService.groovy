package com.github.damianstasiak.oop

import com.github.damianstasiak.TreasureHuntService

import javax.inject.Singleton
import java.util.stream.Collectors

@Singleton
class TreasureHuntOOPService implements TreasureHuntService {

    List<String> getPathToTreasure(String input, int startRow = 1, int startColumn = 1) {
        return getPathToTreasureOOP(input, new Coordinates(startRow - 1, startColumn - 1)).stream().map { it.toString() }.collect(Collectors.toList())
    }

    private List<Coordinates> getPathToTreasureOOP(String input, Coordinates coordinates) {
        def matrix = [[], [], [], [], []] as Coordinates[][]
        def i = 0
        input.splitEachLine(' ') {
            matrix[i++] = it.stream().map { new Coordinates(it[0].toInteger() - 1, it[1].toInteger() - 1) }.toArray() as Coordinates[]
        }
        def visited = new LinkedHashSet<Coordinates>()
        def nextCoordinates = matrix[coordinates.row][coordinates.column]

        while (true) {
            if (!visited.add(coordinates)) {
                return Collections.emptyList()
            }
            if (coordinates == nextCoordinates) {
                return visited.toList()
            }
            coordinates = Coordinates.from(nextCoordinates)
            nextCoordinates = matrix[nextCoordinates.row][nextCoordinates.column]
        }
    }
}
