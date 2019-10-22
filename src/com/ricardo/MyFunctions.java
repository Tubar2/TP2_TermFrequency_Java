package com.ricardo;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class MyFunctions {

    //Opens entry file and returns data Str
    Object readFile(Object path) {

        StringBuilder data = new StringBuilder();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader((String)path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //System.out.println("Read " + line);
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
    Object filterChars(Object data) {
        String str = ((String)data).replaceAll("[^a-zA-Z0-9'\\s]", " "); //switch all symbols to spaces
        return str.trim().replaceAll(" +", " "); //switch consecutive spaces to single space
    }

    //converts all characters to lower case
    Object normalize(Object data) {
        return ((String)data).toLowerCase();
    }

    //Creates String array of words
    Object scan(Object data) {
        //return array of words in data string
        return ((String)data).split(" "); //("\\W+") to remove ',',';'...
    }

    //Removes stop words from previously created words array
    Object removeStopWords(Object words) {

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
        List<String> list = new ArrayList<String>(Arrays.asList(((String[])words)));

        for (String stop_word : stop_words) {
            list.removeAll(Collections.singleton((stop_word)));
        }

        words = list.toArray(new String[0]);
        return words;
    }

    //Creates HashMap for frequency of each word
    Object frequencies(Object word_list) {
        Map<String, MutableInteger> wordFreqs = new HashMap<>();

        for (String word : ((String[])word_list)) {
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
    //TODO: should write some code to check if the cast from Object to Map<> is safe
    @SuppressWarnings("unchecked")
    Object sort(Object wordFreqs) {
        List<WordFrequencyPair> pairs = new ArrayList<>();

        for (Map.Entry<String, MutableInteger> entry : ((Map<String, MutableInteger>)wordFreqs).entrySet()) {
            pairs.add(new WordFrequencyPair(entry.getKey(), entry.getValue().getValue()));
        }

        Collections.sort(pairs);
        Collections.reverse(pairs);
        return pairs;
    }


    //Returns top 25 words frequency
    //TODO: should write some code to check if the cast from Object to List<> is safe
    @SuppressWarnings("unchecked")
    Object top_25_freqs(Object wordFreqs) {

        int numWordsPrinted = 0;
        List<String> top25 = new ArrayList<>();

        for (WordFrequencyPair pair : ((List<WordFrequencyPair>)wordFreqs)) {
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

    public MutableInteger(int value) {
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

    public WordFrequencyPair(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public int compareTo(WordFrequencyPair other) {
        return this.frequency - other.frequency;
    }
}
