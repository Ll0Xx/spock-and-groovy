package com.antont.spocktests

import spock.lang.Rollup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class SpockDataDrivenSpec extends Specification {

    @Shared
    SimpleService simpleService = new SimpleService()

    def "simple test to set shared value"() {
        when:
        simpleService.setSharedField("shared value")
        then:
        simpleService.getSharedField() == "shared value"
    }

    def "simple data driven test"(String a, String b) {
        given:
        SimpleService simpleService = new SimpleService()
        expect:
        simpleService.mergeStrings(a, b)

    }

    @Rollup // will run as one test
    def "simple test with data table"(String a, String b) {
        given:
        SimpleService simpleService = new SimpleService()
        expect:
        simpleService.mergeStrings(a, b)


        where:
                        a              |     b     |          c
        "test"                         | " string" |  "test string"        // simple test with shared
        simpleService.getSharedField() | " 1"      | "shared value 1"  // simple data table test with @Shared field
        "test"                         | a + " 2"  |  "test test 2"        // test with accessing other data variable
    }
}
