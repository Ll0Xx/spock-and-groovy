package com.antont.spocktests

import spock.lang.Specification

class SpockInteractionBasedSpec extends Specification {

    def "simple iteration test"() {
        given:
        SimpleService simpleService = Spy(SimpleService)
        when:
        simpleService.getMagicString("aaa")
        then:
        1 * simpleService.mergeStrings(_, _)
    }

    def "at list two iteration test"() {
        given:
        SimpleService simpleService = Spy(SimpleService)
        when:
        simpleService.getMagicString("aaa ")
        then:
        (2.._) * simpleService.mergeStrings(_, _)
    }

    def "simple any mock object iteration test"() {
        given:
        SimpleService simpleService1 = Spy(SimpleService)
        SimpleService simpleService2 = Spy(SimpleService)
        when:
        simpleService1.getMagicString("aaa")
        simpleService2.getMagicString("aaa ")
        then:
        3 * _.mergeStrings(_, _)
    }

    def "simple argument constraints iteration test"() {
        given:
        SimpleService simpleService = Spy(SimpleService)
        when:
        simpleService.getMagicString("aaa ")
        then:
        1 * simpleService.mergeStrings("aaa ", " b")
    }

    def "simple interactions at Mock creation time test"() {
        given:
        SimpleService simpleService = Spy(SimpleService){
            2 * mergeStrings(_, _)
        }
        expect:
        simpleService.getMagicString("aaa ")
    }
}
