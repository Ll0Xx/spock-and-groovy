package com.antont.spocktests

import spock.lang.Specification

class SpockUtilitiesSpec extends Specification {

    def "simple test with Lenient Match"() {
        given:
        def a = [3, 3, 1, 2]
        expect:
        a =~ [1, 2, 3, 3]
    }

    def "simple test with Strict Match"() {
        given:
        def a = [3, 3, 1, 2]
        expect:
        a ==~ [1, 2, 3, 3]
    }
}
