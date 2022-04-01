package com.antont.spocktests

import spock.lang.Ignore
import spock.lang.IgnoreIf
import spock.lang.PendingFeature
import spock.lang.Specification
import spock.lang.Timeout

class SpockExtensionsSpec extends Specification {

    static Boolean skipTest = true

    def "simple test"() {
        expect:
        1 + 2 == 3
    }

    @Ignore
    def "simple extension test"() {
        expect:
        1 + 2 == 3
    }

    @IgnoreIf({ skipTest })
    def "simple test ignored if skipTest is true"(){
        expect:
        1 + 2 == 3
    }

    @PendingFeature // test will fail if it succeeds
    def "simple not implemented yet test"(){
        expect:
        1 + 2 == 5
    }

    @Timeout(1)
    def "simple timeout test"() {
        when:
        sleep(2000)
        then:
        1 + 3 == 4
    }
}
