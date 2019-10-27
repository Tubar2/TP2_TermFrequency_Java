package com.ricardo;

import java.util.List;
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

        new TheOne<>(path).bind(MyFunctions::readFile)
                .bind(MyFunctions::filterChars)
                .bind(MyFunctions::normalize)
                .bind(MyFunctions::scan)
                .bind(MyFunctions::removeStopWords)
                .bind(MyFunctions::frequencies)
                .bind(MyFunctions::sort)
                .bind(MyFunctions::top_25_freqs)
                .bind(TheOne::printMe);

        long endTime = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toMillis((endTime - startTime));

        System.out.println("Total time = " + totalTime + " milliseconds");

    }

}
