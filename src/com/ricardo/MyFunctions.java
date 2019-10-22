package com.ricardo;

import javax.print.DocFlavor;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class MyFunctions {
    //Opens entry file and returns data Str
    String readFile(){

        StringBuilder data = new StringBuilder();

        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("ent.txt"));

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println("Read " + line);
                data.append(line);
                data.append(" ");
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }

        return data.toString();
    }
    //Removes special characters from previously created data Str
    String filterChars(String data){
        return data.replaceAll("[^a-zA-Z0-9\\s]", "");
    }
    //converts all characters to lower case
    String normalize(String data){
        return data.toLowerCase();
    }
    //Creates String array of words
    String[] scan(String data){
        //return array of words in data string
        return data.split(" "); //("\\W+") to remove ',',';'...
    }
    //Removes stop words from previously created words array
    String[] removeStopWords(String[] words){

        StringBuilder t_stop_words = new StringBuilder();

        Scanner scanner = null;

        //Create String of stop words -> stop_words
        try{
            scanner = new Scanner(new FileReader("stops.txt"));

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println("Read " + line);
                t_stop_words.append(line);
                t_stop_words.append(" ");
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }

        //Create String vector of original words
        String e_stop_words = t_stop_words.toString();
        String[] stop_words = e_stop_words.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(words));

        for (String stop_word:stop_words) {
            list.remove(stop_word);
        }

        words = list.toArray(new String[0]);
        return words;
    }
    //TODO: (function that) Creates (Map?Array???) for the frequency of each word

    //TODO: (function that) Sorts (??) based on frequency

    //TODO: (function that) Returns top 25 words frequency
}
