package com.antont.spocktests

import spock.lang.Specification

class SimpleSpec extends Specification {

    def "simple test"() {
        given:
        SimpleService service = new SimpleService()

        when:
        String result = service.getString("hello")

        then:
        result == "test hello"
    }

    def "simple throw test"() {
        given:
        SimpleService service = new SimpleService()

        when:
        service.throwTestException()

        then:
        def e = thrown(RuntimeException)
        e.message == "test exception"
    }

}
