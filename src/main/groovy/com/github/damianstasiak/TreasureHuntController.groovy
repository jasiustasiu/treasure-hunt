package com.github.damianstasiak

import com.github.damianstasiak.oop.Cell
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller("/hello")
class TreasureHuntController {

    @Get("/")
    String hello() {
//        findTreasure("12")
        "helo"
    }

    void findTreasure(String input) {
        Cell[][] matrix = []
        def rows = input.split("\n")
        def i = 0
        for (row in rows) {
            matrix[i++] = row.split(" ").toList().stream().map { new Cell(Integer.parseInt(it[0]) - 1, Integer.parseInt(it[1]) - 1) }.toArray(Cell[].&new) as Cell[]
        }
        def visited = new ArrayList<Cell>()
        def row = 0
        def column = 0
        def current = matrix[row][column]
        while (visited.size() <= 26) {
            visited.add(current)
            if (current.isTreasure(row, column)) {
                break;
            } else {
                row = current.row
                column = current.column
                current = matrix[row][column]
            }
        }
        if (visited.size() <= 26) {
            print(visited)
//            print(visited/.joinToString(separator = "\n") { "" + (it.row + 1) + (it.column + 1) })
        } else {
            print("NO TREASURE")
        }
    }
}