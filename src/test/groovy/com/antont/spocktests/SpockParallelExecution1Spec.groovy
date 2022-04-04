package com.antont.spocktests

import spock.lang.Specification

class SpockParallelExecution1Spec extends Specification {

    def "simple parallel test 1"(){
        when:
        sleep(2000)
        then:
        1 + 2 == 3
    }

    def "simple parallel test 2"(){
        when:
        sleep(2000)
        then:
        1 + 2 == 3
    }

    def "simple parallel test 3"(){
        when:
        sleep(2000)
        then:
        1 + 2 == 3
    }
}
