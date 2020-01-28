package com.github.damianstasiak.recursive

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class TreasureHuntServiceSpec extends Specification {

    def service = new TreasureHuntService()

    void "test find treasure"() {
        given:
        def input = """55 14 25 52 21
44 31 11 53 43
24 13 45 12 34
42 22 43 32 41
51 23 33 54 15"""
        when:
        def path = service.getPathToTreasure(input)

        then:
        path == ["11", "55", "15", "21", "44", "32", "13", "25", "43"]
    }

    void "test infinite loop"() {
        given:
        def input = """55 14 25 52 21
44 31 11 53 43
24 13 45 12 34
42 22 43 32 41
51 23 33 54 11"""
        when:
        def path = service.getPathToTreasure(input)

        then:
        path == []
    }

    void "test traverse all with no treasure"() {
        given:
        def input = """12 13 14 15 21
22 23 24 25 31
32 33 34 35 41
42 43 44 45 51
52 53 54 55 11"""
        when:
        def path = service.getPathToTreasure(input)

        then:
        path == []
    }
}