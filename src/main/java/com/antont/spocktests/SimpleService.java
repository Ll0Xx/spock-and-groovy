package com.antont.spocktests;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    private String sharedField = "original string";

    public String getString(String string){
        return "test " + string;
    }

    public void throwTestException(){
        throw new RuntimeException("test exception");
    }

    public String mergeStrings(String a, String b){
        return a + b;
    }

    public String getMagicString(String baseString) {
        String modifiedString = baseString;
        if (baseString.length() % 2 > 0) {
            modifiedString = mergeStrings(modifiedString, " a");
        }
        if (baseString.length() > 3) {
            modifiedString = mergeStrings(modifiedString, " b");
        }

        if (baseString.contains(" ")) {
            modifiedString = mergeStrings(modifiedString, " c");
        }
        return modifiedString;
    }

    public String getSharedField() {
        return sharedField;
    }

    public void setSharedField(String sharedField) {
        this.sharedField = sharedField;
    }
}
