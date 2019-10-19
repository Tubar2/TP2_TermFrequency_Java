package com.ricardo;

import java.util.function.Function;

class TheOne {
    private String value;

    TheOne(String value) {
        this.value = value;
    }

    TheOne bind(Function<String, String> myFunction){
        this.value = myFunction.apply(this.value);
        return this;
    }
    void printMe(){
        System.out.println(this.value);
    }
}
