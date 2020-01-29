package com.github.damianstasiak.treasurehunt.oop

class Coordinates {
    Integer row
    Integer column

    Coordinates(Integer row, Integer column) {
        this.row = row
        this.column = column
    }

    static Coordinates from(Coordinates coordinates) {
        return new Coordinates(coordinates.row, coordinates.column)
    }

    static Coordinates from(String coordinates) {
        return new Coordinates(coordinates[0].toInteger()-1, coordinates[1].toInteger()-1)
    }

    @Override
    String toString() {
        return "" + (row + 1) + (column + 1)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Coordinates cell = (Coordinates) o

        if (column != cell.column) return false
        if (row != cell.row) return false

        return true
    }

    int hashCode() {
        int result
        result = row.hashCode()
        result = 31 * result + column.hashCode()
        return result
    }
}
