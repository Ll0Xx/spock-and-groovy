package com.antont.spocktests

import spock.lang.Shared
import spock.lang.Specification

class SpockPrimerSpec extends Specification {

    @Shared SimpleService sharedService = new SimpleService()
    SimpleService notSharedService = new SimpleService()

    def "first simple shared test"() {
        given:
        sharedService.setSharedField("form first test")
        notSharedService.setSharedField("form first test")
        when:
        String s1 = sharedService.getString("test")
        String s2 = notSharedService.getString("test")
        then:
        s1 == "test test"
        s2 == "test test"
    }

    def "second simple shared test"() {
        when:
        sharedService.throwTestException()
        notSharedService.throwTestException()
        then:
        RuntimeException e = thrown(RuntimeException)
        e.message == "test exception"
        sharedService.getSharedField() == "form first test"
        notSharedService.getSharedField() == "original string"
    }

    def "simple expect test" (){
        expect:
        sharedService.getString("test") == "test test"
    }

    def "simple test with helper method"(){
        given:
        SimpleService simpleService = new SimpleService()
        when:
        String s = simpleService.getString("with helper")
        then:
        checkString(s)
    }

    void checkString(s){
        assert s == "test with helper"
    }

}
