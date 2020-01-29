package com.github.damianstasiak.treasurehunt.oop

class Matrix {

    def coordinatesMatrix =  [[], [], [], [], []] as Coordinates[][]

    static Matrix from(String input) {
        def coordinatesMatrix =  [[], [], [], [], []] as Coordinates[][]
        def i = 0
        input.splitEachLine(' ') {
            coordinatesMatrix[i++] = it.stream().map { new Coordinates(it[0].toInteger() - 1, it[1].toInteger() - 1) }.toArray() as Coordinates[]
        }
        return new Matrix(coordinatesMatrix)
    }

    Matrix(coordinatesMatrix) {
        this.coordinatesMatrix = coordinatesMatrix
    }

    Coordinates next(Coordinates coordinates) {
        return coordinatesMatrix[coordinates.row][coordinates.column]
    }
}
