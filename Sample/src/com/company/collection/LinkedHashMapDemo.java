package com.company.collection;

import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> lhm =
                new LinkedHashMap<String, String>();
        lhm.put("one", "practice.geeksforgeeks.org");
        lhm.put("two", "code.geeksforgeeks.org");
        lhm.put("four", "quiz.geeksforgeeks.org");

        Map<String,Integer> map = new IdentityHashMap<>();
        map.put("abc",1);
        map.put(new String("abc"),2);
        System.out.println(map);
    }
}
