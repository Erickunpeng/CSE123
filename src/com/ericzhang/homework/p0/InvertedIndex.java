package com.ericzhang.homework.p0;

import java.util.*;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public class InvertedIndex {
    public static void main(String[] args) {
        List<String> docs = new ArrayList<>();
        docs.add("Raiders of the Lost Ark");
        docs.add("The Temple of Doom");
        docs.add("The Last Crusade");

        Map<String, Set<String>> result = createIndex(docs);
        System.out.println(docs);
        System.out.println();
        System.out.println(result);
    }

    // TODO: Write your createIndex method here

    /**
     * Creates an inverted index of sentences given that all words are case-insensitive
     *
     * @param sentences A list of sentences given
     * @return A map that contains all words (case-insensitive) in sentences and their
     * corresponding sentence belonged.
     */

    public static Map<String, Set<String>> createIndex(List<String> sentences) {
        // Creates a TreeMap that will automatically sort the keys in either
        // upper or lower case.
        Map<String, Set<String>> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (String sentence : sentences) {
            // Split the sentence to words
            String[] words = sentence.split(" ");
            // Gets every single word
            for (String word : words) {
                // If the word doesn't exist, put the word in the map and creates
                // the corresponding set for the sentence
                if (!result.containsKey(word)) {
                    result.put(word, new HashSet<>());
                }
                // If the key already exists, adds another sentence behind.
                result.get(word).add(sentence);
            }
        }
        return result;
    }
}
