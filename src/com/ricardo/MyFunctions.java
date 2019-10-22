package com.ricardo;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class MyFunctions {

    //Opens entry file and returns data Str
    static String readFile(String path) {

        StringBuilder data = new StringBuilder();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
//                System.out.println("Read " + line);
                data.append(line);
                data.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return data.toString();
    }

    //Removes special characters from previously created data Str
    static String filterChars(String data) {
        String str = data.replaceAll("[^a-zA-Z0-9'\\s]", " "); //switch all symbols to spaces

        return str.trim().replaceAll(" +", " "); //switch consecutive spaces to single space
    }

    //converts all characters to lower case
    static String normalize(String data) {
        return data.toLowerCase();
    }

    //Creates String array of words
    static String[] scan(String data) {
        //return array of words in data string
        return data.split(" "); //("\\W+") to remove ',',';'...
    }

    //Removes stop words from previously created words array
    static String[] removeStopWords(String[] words) {

        StringBuilder t_stop_words = new StringBuilder();

        Scanner scanner = null;

        //Create String of stop words -> stop_words
        try {
            scanner = new Scanner(new FileReader("stop_words.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //System.out.println("Read " + line);
                t_stop_words.append(line);
                t_stop_words.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        //Create String vector of original words
        String e_stop_words = t_stop_words.toString();
        String[] stop_words = e_stop_words.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList((words)));

        for (String stop_word : stop_words) {
            list.removeAll(Collections.singleton((stop_word)));
        }

        words = list.toArray(new String[0]);
        return words;
    }

    //Creates HashMap for frequency of each word
    static Map<String, MutableInteger> frequencies(String[] word_list) {
        Map<String, MutableInteger> wordFreqs = new HashMap<>();

        for (String word : word_list) {
            MutableInteger count = wordFreqs.get(word);
            if (count == null) {
                wordFreqs.put(word, new MutableInteger(1));
            } else {
                count.setValue(count.getValue() + 1);
            }
        }
        return wordFreqs;
    }

    //Create a list with words and freqs from HashMap and sort it in descending order
    static List<WordFrequencyPair> sort(Map<String, MutableInteger> wordFreqs) {
        List<WordFrequencyPair> pairs = new ArrayList<>();

        for (Map.Entry<String, MutableInteger> entry : wordFreqs.entrySet()) {
            pairs.add(new WordFrequencyPair(entry.getKey(), entry.getValue().getValue()));
        }

        Collections.sort(pairs);
        Collections.reverse(pairs);
        return pairs;
    }


    //Returns top 25 words frequency
    static List<String> top_25_freqs(List<WordFrequencyPair> wordFreqs) {

        int numWordsPrinted = 0;
        List<String> top25 = new ArrayList<>();

        for (WordFrequencyPair pair : wordFreqs) {
            top25.add(pair.getWord() + " - " + pair.getFrequency());

            numWordsPrinted++;
            if (numWordsPrinted >= 25) {
                break;
            }
        }

        return top25;
    }

}

//Normal Integers can't change value
class MutableInteger {
    private int value;

    MutableInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

//Structure to help in sorting (defines way to compare two wordFrequency objs)
class WordFrequencyPair implements Comparable<WordFrequencyPair> {
    private String word;
    private int frequency;

    WordFrequencyPair(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    int getFrequency() {
        return frequency;
    }

    public int compareTo(WordFrequencyPair other) {
        return this.frequency - other.frequency;
    }
}