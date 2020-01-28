package com.github.damianstasiak

import com.github.damianstasiak.oop.Coordinates
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller("/treasure-hunt")
class TreasureHuntController {

    def oopService
    def recursiveService

    @Get("/oop")
    String oop() {
        "helo"
    }

    @Get("/recursive")
    String recursive() {
        "helo"
    }

}