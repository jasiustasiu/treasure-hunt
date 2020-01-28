package com.github.damianstasiak


import com.github.damianstasiak.oop.TreasureHuntOOPService
import com.github.damianstasiak.recursive.TreasureHuntRecursiveService
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject

@CompileStatic
@Controller("/treasure-hunt")
class TreasureHuntController {

    @Inject
    TreasureHuntOOPService oopService
    @Inject
    TreasureHuntRecursiveService recursiveService

    String INPUT = """12 13 14 15 21
22 23 24 25 31
32 33 34 35 41
42 43 44 45 51
52 53 54 55 11"""

    @Get("/oop/{row}/{column}")
    String oop(Integer row, Integer column) {
        return oopService.getPathToTreasure(INPUT, row, column)
    }

    @Get("/recursive/{row}/{column}")
    String recursive(Integer row, Integer column) {
        return recursiveService.getPathToTreasure(INPUT, row, column)
    }

}