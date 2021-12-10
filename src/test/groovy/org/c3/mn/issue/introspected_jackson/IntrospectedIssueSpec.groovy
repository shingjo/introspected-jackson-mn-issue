package org.c3.mn.issue.introspected_jackson

import groovy.json.JsonSlurper
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import jakarta.inject.Inject

@MicronautTest
class IntrospectedIssueSpec extends Specification {

    @Inject
    @Client('/issue')
    HttpClient client

    def "DTO verify json getter"() {
        when:
        def json = client.toBlocking().retrieve('/dto')
        def results = new JsonSlurper().parseText(json)

        then:
        results[0].name      == 'Cummerata'
        results[0].phone     == '(955) 033-2616'
        results[0].extension == 'x2514'
    }

    def "DTO verify json setter"() {
        when:
        def results = client.toBlocking().retrieve(HttpRequest.GET('/dto'), Argument.listOf(ContactDto.class))

        then:
        results[0].name      == 'Cummerata'
        results[0].phone     == '9550332616'
        results[0].extension == 2514
    }

    def "Entity verify json getter"() {
        when:
        def json = client.toBlocking().retrieve('/entity')
        def results = new JsonSlurper().parseText(json)
        println results

        then:
        results[0].name      == 'Cummerata'
        results[0].phone     == '(955) 033-2616'
        results[0].extension == 'x2514'
    }

    def "Entity verify json setter"() {
        when:
        def results = client.toBlocking().retrieve(HttpRequest.GET('/entity'), Argument.listOf(ContactEntity.class))

        then:
        results[0].name      == 'Cummerata'
        results[0].phone     == '9550332616'
        results[0].extension == 2514
    }

    def "Introspected verify json getter"() {
        when:
        def json = client.toBlocking().retrieve('/introspected')
        def results = new JsonSlurper().parseText(json)
        println results

        then:
        results[0].name      == 'Cummerata'
        results[0].phone     == '(955) 033-2616'
        results[0].extension == 'x2514'
    }

    def "Introspected verify json setter"() {
        when:
        def results = client.toBlocking().retrieve(HttpRequest.GET('/introspected'), Argument.listOf(ContactIntrospected.class))

        then:
        results[0].name      == 'Cummerata'
        results[0].phone     == '9550332616'
        results[0].extension == 2514
    }

}
