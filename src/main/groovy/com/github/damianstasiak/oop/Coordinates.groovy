package com.github.damianstasiak.oop

class Coordinates {
     Integer row
     Integer column

    Coordinates(Integer row, Integer column) {
        this.row = row
        this.column = column
    }

    static START = new Coordinates(0,0)

    static Coordinates fromCoordinates(Coordinates coordinates) {
        return new Coordinates(coordinates.row, coordinates.column)
    }

    @Override
    String toString() {
        return "" + (row + 1) + (column + 1)
    }

//    boolean equals(o) {
//        if (this.is(o)) return true
//        if (getClass() != o.class) return false
//
//        Coordinates cell = (Coordinates) o
//
//        if (column != cell.column) return false
//        if (row != cell.row) return false
//
//        return true
//    }
//
//    int hashCode() {
//        int result
//        result = row.hashCode()
//        result = 31 * result + column.hashCode()
//        return result
//    }
}
