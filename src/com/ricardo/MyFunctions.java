package com.ricardo;

import javax.print.DocFlavor;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class MyFunctions {
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

    String filterChars(String data){
        return data.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    String normalize(String data){
        return data.toLowerCase();
    }

    String[] scan(String data){
        //return array of words in data string
        return data.split(" "); //("\\W+") to remove ',',';'...
    }

    String[] removeStopWords(String[] words){


        return words;
    }
}
