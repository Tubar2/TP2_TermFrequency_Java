package com.ricardo;

class Controller {

    private TheOne theOne = new TheOne("Default");
    private MyFunctions myFunctions = new MyFunctions();

    //Run function
    void run(){
        System.out.println("run() called.");
        theOne.bind(data -> myFunctions.readFile()).bind(myFunctions::filterChars).bind(myFunctions::normalize).bind2(myFunctions::scan).printMe();
        System.out.println("run() ended.");
    }
}
