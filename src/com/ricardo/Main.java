package com.ricardo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        String path;
        if (args.length > 0) {
            path = args[0];
        }
        else{
            path = "dracula.txt";
        }

        //Instantiation necessary to use functions in bind
        MyMonads myMonads = new MyMonads();

        CompletableFuture<Object> theOneCompletableFuture = CompletableFuture.supplyAsync(() -> path)
                .thenApply(myMonads::readFile)
                .thenApply(myMonads::filterChars)
                .thenApply(myMonads::normalize)
                .thenApply(myMonads::scan)
                .thenApply(myMonads::removeStopWords)
                .thenApply(myMonads::frequencies)
                .thenApply(myMonads::sort)
                .thenApply(myMonads::top_25_freqs)
                .thenApply(value -> {
                    for (String str : (value)) {
                        System.out.println(str);
                    }
                    return "Process Ended";
                });

        long endTime = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toMillis((endTime - startTime));

        System.out.println("Total time = " + totalTime + " miliseconds");


    }
}