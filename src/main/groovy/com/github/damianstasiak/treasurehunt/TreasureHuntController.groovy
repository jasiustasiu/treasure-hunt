package com.github.damianstasiak.treasurehunt

import com.github.damianstasiak.treasurehunt.oop.TreasureHuntOOPService
import com.github.damianstasiak.treasurehunt.recursive.TreasureHuntRecursiveService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import javax.inject.Inject
import javax.inject.Named

@Controller("/treasure-hunt")
class TreasureHuntController {
    @Inject
    TreasureHuntOOPService treasureHuntOOPService
    @Inject
    TreasureHuntRecursiveService treasureHuntRecursiveService

    def INPUT = """55 14 25 52 21
                  |44 31 11 53 43
                  |24 13 45 12 34
                  |42 22 43 32 41
                  |51 23 33 54 15""".stripMargin()

    @Get("/oop/{coordinates}")
    @Produces(MediaType.TEXT_PLAIN)
    String getPathOOP(String coordinates) {
        def path = treasureHuntOOPService.getPathToTreasure(INPUT, coordinates)
        return path.isEmpty() ? "NO TREASURE" : path.join("\n")

    }

    @Get("/recursive/{coordinates}")
    @Produces(MediaType.TEXT_PLAIN)
    String getPathRecursive(String coordinates) {
        def path = treasureHuntRecursiveService.getPathToTreasure(INPUT, coordinates)
        return path.isEmpty() ? "NO TREASURE" : path.join("\n")
    }

}