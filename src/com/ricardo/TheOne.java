package com.ricardo;

import java.util.Arrays;
import java.util.Vector;
import java.util.function.Function;

class TheOne {
    private String value;
    private String[] words;

    TheOne(String value) {
        this.value = value;
    }

    TheOne bind(Function<String, String> myFunction){
        this.value = myFunction.apply(this.value);
        return this;
    }

    TheOne bind2(Function<String, String[]> myFunc){
        this.words = myFunc.apply(this.value);
        return this;
    }

    TheOne bind3(Function<String[], String[]> myFun){
        this.words = myFun.apply(this.words);
        return this;
    }

    void printMe(){
        for (String w:words) {
            System.out.println(w);
        }
    }
}
