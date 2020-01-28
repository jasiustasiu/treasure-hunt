package com.github.damianstasiak

import com.github.damianstasiak.oop.Coordinates
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

}