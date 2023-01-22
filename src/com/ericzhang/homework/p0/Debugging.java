package com.ericzhang.homework.p0;

/**
 * @author Eric Zhang
 * @version 1.0
 */

import java.util.*;

public class Debugging {
    public static void main(String[] args) {
        Map<String, List<Integer>> testMap = new TreeMap<>();
        testMap.put("cse121", Arrays.asList(42, 17, 42, 42));
        testMap.put("cse122", Arrays.asList(10, 12, 14));
        testMap.put("cse123", Arrays.asList(100, 99, 98, -97));

        Map<String, List<Integer>> deepCopyMap = deepCopy(testMap);

        System.out.print("{");
        for (String key : deepCopyMap.keySet()) {
            System.out.print(key + "=" + deepCopyMap.get(key) + " ");
        }
        System.out.println("}");
    }

    // Produces and returns a "deep copy" of the parameter map, which has the same
    //   structure and values as the parameter, but with all internal data structures
    //   and values copied. After calling this method, modifying the parameter or
    //   return value should NOT affect the other.
    //
    // Parameters:
    //   inputMap - the map to duplicate
    //
    // Returns:
    //   A deep copy of the parameter map.
    public static Map<String, List<Integer>> deepCopy(Map<String, List<Integer>> inputMap) {
        Map<String, List<Integer>> deepCopy = new TreeMap<>();
        List<String> keys = new ArrayList<>(inputMap.keySet());

        for (String key : keys) {
            List<Integer> inputList = inputMap.get(key);
            deepCopy.put(key, inputList);
        }
        return deepCopy;
    }
}
