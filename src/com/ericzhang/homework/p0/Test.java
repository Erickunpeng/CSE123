package com.ericzhang.homework.p0;

import java.util.*;

/**
 * @author Eric Zhang
 * @version 1.0
 */

public class Test {
    public static void main(String[] args) {

        Book book1 = new Book("h", "a");
        Book book2 = new Book("hh", Arrays.asList("b", "c"));

        System.out.println(book1.getTitle());
        System.out.println(book1.getArtists());
        System.out.println(book2.getArtists());
        System.out.println(book1.toString());
        System.out.println(book2.toString());

        book1.addRating(5);
        book2.addRating(4);
        book1.addRating(9);
        book2.addRating(4);

        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }

    public static Map<String, List<Integer>> deepCopy(Map<String, List<Integer>> inputMap) {
        Map<String, List<Integer>> deepCopy = new TreeMap<>();
        List<String> keys = new ArrayList<>(inputMap.keySet());

        for (String key : keys) {
            List<Integer> inputList = inputMap.get(key);
            deepCopy.put(key, inputList);
        }
        return deepCopy;
    }

    public static Map<String, Set<String>> createIndex(List<String> documents) {
        Map<String, Set<String>> result = new TreeMap<>();

        for (String s : documents) {
            String[] words = s.split(" ");
            for (String word : words) {
                if (!result.containsKey(word)) {
                    result.put(word, new HashSet<>());
                    result.get(word).add(s);
                }
            }
        }
        return result;
    }
}
