package com.ricardo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

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

    }

}
