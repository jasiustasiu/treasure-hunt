package com.github.damianstasiak

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class HelloControllerSpec extends Specification {

    @Inject
    @Client("/")
    RxHttpClient client

    void "test hello world response"() {
        given:
        def input = """55 14 25 52 21
44 31 11 53 43
24 13 45 12 34
42 22 43 32 41
51 23 33 54 15"""
        when:
        HttpRequest request = HttpRequest.GET('/hello')
        String rsp = client.toBlocking().retrieve(request)

        then:
        rsp == "Hello World"
    }

//    @Test
//    fun findTreasure() {
//        val input = """55 14 25 52 21
//44 31 11 53 43
//24 13 45 12 34
//42 22 43 32 41
//51 23 33 54 15"""
//        Tigadevs.findTreasure(input)
//    }
//
//    @Test
//    fun findTreasure2() {
//        val input = """55 14 25 52 21
//44 31 11 53 43
//24 13 45 12 34
//42 22 43 32 41
//15 23 33 54 15"""
//        Tigadevs.findTreasure(input)
//    }
}