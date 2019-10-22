package com.ricardo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.function.Function;

class TheOne<T> {
    private T value;

    TheOne(T value) {
        this.value = value;
    }

    <U>TheOne<U> bind(Function<? super T,? extends U > myFunction) {
        U value = myFunction.apply(this.value);
        return new TheOne<U>(value);
    }

    //Prints list of 25 most used words with sorted freqs
    void printMe() {
        for (String str : (List<String>)(this.value)) {
            System.out.println(str);
        }
    }

    T get(){
        return this.value;
    }
}

