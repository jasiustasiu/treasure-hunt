package com.github.damianstasiak.treasurehunt.oop

import com.github.damianstasiak.treasurehunt.TreasureHuntService

import javax.inject.Singleton
import java.util.stream.Collectors

@Singleton
class TreasureHuntOOPService implements TreasureHuntService {

    List<String> getPathToTreasure(String input, String startCoordinates = "11") {
        return getPathToTreasureOOP(input, Coordinates.from(startCoordinates)).stream().map { it.toString() }.collect(Collectors.toList())
    }

    private List<Coordinates> getPathToTreasureOOP(String input, Coordinates coordinates) {
        def matrix = Matrix.from(input)
        def visited = new LinkedHashSet<Coordinates>()
        def nextCoordinates = matrix.next(coordinates)

        while (true) {
            if (!visited.add(coordinates)) {
                return Collections.emptyList()
            }
            if (coordinates == nextCoordinates) {
                return visited.toList()
            }
            coordinates = Coordinates.from(nextCoordinates)
            nextCoordinates = matrix.next(nextCoordinates)
        }
    }
}
