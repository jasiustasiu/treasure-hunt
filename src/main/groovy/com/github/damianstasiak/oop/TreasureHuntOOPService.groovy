package com.github.damianstasiak.oop

class TreasureHuntOOPService {

    static void main(String[] args) {
        def input = """55 14 25 52 21
44 31 11 53 43
24 13 45 12 34
42 22 43 32 41
51 23 33 54 15"""
        def service = new TreasureHuntOOPService()
        def path = service.getPathToTreasure(input)
        print(path)
    }

    Set<Coordinates> getPathToTreasure(String input) {
        def matrix = [[], [], [], [], []] as Coordinates[][]
        def i = 0
        input.splitEachLine(' ') {
            matrix[i++] =  it.stream().map { new Coordinates(it[0].toInteger() - 1, it[1].toInteger() - 1) }.toArray() as Coordinates[]
        }
        def visited = new LinkedHashSet<Coordinates>()
        def coordinates = Coordinates.START
        def nextCoordinates = matrix[coordinates.row][coordinates.column]

        while (true) {
            if (visited.contains(coordinates))
                return Collections.emptySet()
            visited.add(coordinates)
            if (nextCoordinates == coordinates) {
                return visited
            }
            coordinates = Coordinates.fromCoordinates(nextCoordinates)
            nextCoordinates = matrix[nextCoordinates.row][nextCoordinates.column]
        }
    }
}
