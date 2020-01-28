package com.github.damianstasiak.oop

import com.github.damianstasiak.TreasureHuntService

import java.util.stream.Collectors

class TreasureHuntOOPService implements TreasureHuntService {

    List<String> getPathToTreasure(String input) {
        return getPathToTreasureOOP(input).stream().map{ it.toString() }.collect(Collectors.toList())
    }

    private List<Coordinates> getPathToTreasureOOP(String input) {
        def matrix = [[], [], [], [], []] as Coordinates[][]
        def i = 0
        input.splitEachLine(' ') {
            matrix[i++] =  it.stream().map { new Coordinates(it[0].toInteger() - 1, it[1].toInteger() - 1) }.toArray() as Coordinates[]
        }
        def visited = new LinkedHashSet<Coordinates>()
        def coordinates = Coordinates.START
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
