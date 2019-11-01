package com.TermFreq;

public class Main {
    public static void main(String[] args) {

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

    }

}
