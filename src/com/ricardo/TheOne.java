package com.ricardo;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

class TheOne {
    private String value;
    private String[] words;
    private Map<String, MutableInteger> wordFreqHash;
    private List<WordFrequencyPair> wordFreqPairs;
    private List<String> wordFreq;

    TheOne(String value) {
        this.value = value;
    }

    TheOne bind(Function<String, String> myFunction) {
        this.value = myFunction.apply(this.value);
        return this;
    }

    TheOne bind2(Function<String, String[]> myFunc) {
        this.words = myFunc.apply(this.value);
        return this;
    }

    TheOne bind3(Function<String[], String[]> myFun) {
        this.words = myFun.apply(this.words);
        return this;
    }

    TheOne bind4(Function<String[], Map<String, MutableInteger>> myFunc) {
        this.wordFreqHash = myFunc.apply(this.words);
        return this;
    }

    TheOne bind5(Function<Map<String, MutableInteger>, List<WordFrequencyPair>> myFunc) {
        this.wordFreqPairs = myFunc.apply(this.wordFreqHash);
        return this;
    }

    TheOne bind6(Function<List<WordFrequencyPair>, List<String>> myFunc){
        this.wordFreq = myFunc.apply(this.wordFreqPairs);
        return this;
    }

    //Prints list of 25 most used words with sorted freqs
    void printMe() {
        for (String str : wordFreq){
            System.out.println(str);
        }
    }

    //TODO delete these other functions (could be useful)
    void printMe1() {
        for (String w : words) {
            System.out.println(w);
        }
    }

    //Prints hashmap
    void printMe2() {
        for (Map.Entry<String, MutableInteger> entry : wordFreqHash.entrySet()) {
            System.out.println(entry.getKey() + " ==> " + entry.getValue().getValue());
        }
    }
}

