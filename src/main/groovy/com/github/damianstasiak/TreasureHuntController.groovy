package com.github.damianstasiak


import com.github.damianstasiak.oop.TreasureHuntOOPService
import com.github.damianstasiak.recursive.TreasureHuntRecursiveService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject

@Controller("/treasure-hunt")
class TreasureHuntController {
    @Inject
    TreasureHuntOOPService treasureHuntOOPService
    @Inject
    TreasureHuntRecursiveService treasureHuntRecursiveService

    String INPUT = """55 14 25 52 21
44 31 11 53 43
24 13 45 12 34
42 22 43 32 41
51 23 33 54 15"""

    @Get("/oop/{row}/{column}")
    String oop(Integer row, Integer column) {
        return treasureHuntOOPService.getPathToTreasure(INPUT, row, column)
    }

    @Get("/recursive/{row}/{column}")
    String recursive(Integer row, Integer column) {
        return treasureHuntRecursiveService.getPathToTreasure(INPUT, row, column)
    }

}