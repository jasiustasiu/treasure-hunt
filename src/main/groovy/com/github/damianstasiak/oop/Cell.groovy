package com.github.damianstasiak.oop

class Cell {
    private Integer row
    private Integer column

    Integer getRow() {
        return row
    }

    Integer getColumn() {
        return column
    }

    void setRow(Integer row) {
        this.row = row
    }

    void setColumn(Integer column) {
        this.column = column
    }

    Cell() {
    }

    Cell(Integer row, Integer column) {
        this.row = row
        this.column = column
    }

    boolean isTreasure(Integer row, Integer column) {
        return this.row == row && this.column == column
    }


    @Override
    String toString() {
        return "" + (row + 1) + (column + 1)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Cell cell = (Cell) o

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
