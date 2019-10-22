package com.ricardo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.function.Function;

class TheOne<T>  {
    private T value;

    TheOne(T value) {
        this.value = value;
    }

    <U>TheOne<U> bind(Function<T, U > myFunction) {
        U value = myFunction.apply(this.value);
        return new TheOne<U>(value);
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

}

