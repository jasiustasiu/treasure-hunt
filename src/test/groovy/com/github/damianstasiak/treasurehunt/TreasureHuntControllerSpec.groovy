package com.github.damianstasiak.treasurehunt

import com.github.damianstasiak.treasurehunt.oop.TreasureHuntOOPService
import com.github.damianstasiak.treasurehunt.recursive.TreasureHuntRecursiveService
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject
import javax.inject.Named

@MicronautTest
class TreasureHuntControllerSpec extends Specification {

    @Inject
    @Client("/treasure-hunt")
    RxHttpClient client

    void "test find path oop"() {
        when:
        def request = HttpRequest.GET("/oop/55");
        def body = client.toBlocking().retrieve(request);
        then:
        body == """55
                  |15
                  |21
                  |44
                  |32
                  |13
                  |25
                  |43""".stripMargin()
    }

    void "test do not find path oop"() {
        when:
        def request = HttpRequest.GET("/oop/24");
        def body = client.toBlocking().retrieve(request);
        then:
        body == "NO TREASURE"
    }

    void "test find path recursive"() {
        when:
        def request = HttpRequest.GET("/recursive/55");
        def body = client.toBlocking().retrieve(request);
        then:
        body == """55
                  |15
                  |21
                  |44
                  |32
                  |13
                  |25
                  |43""".stripMargin()
    }

    void "test do not find path recursive"() {
        when:
        def request = HttpRequest.GET("/recursive/24");
        def body = client.toBlocking().retrieve(request);
        then:
        body == "NO TREASURE"
    }
}
