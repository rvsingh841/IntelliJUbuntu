package com.company.collection;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class EnumMapDemo {
    public enum GFG{
        CODE,CONTRIBUTE,QUIZ,MCQ
    }

    public static void main(String[] args) {
        EnumMap<GFG,String> map = new EnumMap<GFG, String>(GFG.class);
        map.put(GFG.CODE,"CODE");
        map.put(GFG.CONTRIBUTE,"CONTRIBUTE");
        map.put(GFG.QUIZ,"QUIZ");
        map.put(GFG.MCQ,"MCQ");
        System.out.println(map);
        System.out.println(map.containsKey(GFG.CODE));
        System.out.println(map.containsValue(null));

        SortedMap<Integer, String> sm =
                new TreeMap<Integer, String>();
        sm.put(2, "practice");
        sm.put(3, "quiz");
        sm.put(5, "code");
        sm.put(4, "contribute");
        sm.put(1, "geeksforgeeks");

        System.out.println(sm.firstKey());
        System.out.println(sm.headMap(2));
        System.out.println("subMap " + sm.subMap(1,3));
        System.out.println(sm.tailMap(3));
        System.out.println(sm.firstKey());
        System.out.println(sm.lastKey());
        System.out.println(sm.comparator());


    }
}
