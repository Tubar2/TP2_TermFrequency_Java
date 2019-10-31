package com.ricardo;

import java.util.List;
import java.util.function.Function;

public class TheOne {
    private Object value;

    public TheOne(String value) {
        this.value = value;
    }

    public TheOne bind(Function<Object, Object> myFunction) {
        this.value = myFunction.apply(this.value);
        return this;
    }

    //Prints list of 25 most used words with sorted freqs
    //TODO: should write some code to check if the cast from Object to List<> is safe
    @SuppressWarnings("unchecked")
    void printMe() {
        for (String str : ((List<String>)this.value)) {
            System.out.println(str);
        }
    }

    public Object getValue() {
        return value;
    }
}

