package com.ricardo;

import java.util.List;
import java.util.function.Function;

public class TheOne<T>  {
    private T value;

    public TheOne(T value) {
        this.value = value;
    }

    public <U>TheOne<U> bind(Function<T, U> myFunction) {
        U value = myFunction.apply(this.value);
        return new TheOne<>(value);
    }

    //Prints list of 25 most used words with sorted freq
    static boolean printMe(List<String> value) {
        for (String str : value) {
            System.out.println(str);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    void printMe2() {
        for (String str : (List<String>)(this.value)) {
            System.out.println(str);
        }
    }
    /* Getter */
    public T getValue() {
        return value;
    }

}

