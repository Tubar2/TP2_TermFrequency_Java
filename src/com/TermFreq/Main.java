package com.TermFreq;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        String path = "resources/";
        if (args.length > 0) {
            path = path.concat(args[0]);
        }
        else{
            path = path.concat("dracula.txt");
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
