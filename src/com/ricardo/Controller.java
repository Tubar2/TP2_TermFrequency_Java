package com.ricardo;

class Controller {

    private TheOne theOne = new TheOne("Default");
    private MyFunctions myFunctions = new MyFunctions();

    //Run function
    void run(){
        System.out.println("run() called.");
        theOne.bind(data -> myFunctions.readFile())
                .bind(myFunctions::filterChars)
                .bind(myFunctions::normalize)
                .bind2(myFunctions::scan)
                .bind3(myFunctions::removeStopWords)
                .bind4(myFunctions::frequencies)
                .bind5(myFunctions::sort)
                .bind6(myFunctions::top_25_freqs)
                .printMe();
        System.out.println("run() ended.");
    }
}
