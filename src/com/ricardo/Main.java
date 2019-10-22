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

        //Instantiation necessary to use functions in bind
        MyFunctions myFunctions = new MyFunctions();

        new TheOne<>(path).bind(myFunctions::readFile)
                .bind(myFunctions::filterChars)
                .bind(myFunctions::normalize)
                .bind(myFunctions::scan)
                .bind(myFunctions::removeStopWords)
                .bind(myFunctions::frequencies)
                .bind(myFunctions::sort)
                .bind(myFunctions::top_25_freqs).bind(TheOne::printMe);

    }

}
