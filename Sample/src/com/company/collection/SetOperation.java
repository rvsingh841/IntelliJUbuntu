package com.company.collection;

import java.util.*;
import java.util.stream.IntStream;

public class SetOperation {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,4,6,5,8,10));
        set1 = Collections.unmodifiableSet(set1);
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1,3,5,7,9,6));
        set2 = Collections.unmodifiableSet(set2);

       Set <Integer> unionSet = new HashSet<>();
       unionSet.addAll(set1);
       unionSet.addAll(set2);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(unionSet);

        Set<Integer> intersectionSet = new HashSet<>();
        intersectionSet.addAll(set1);
        intersectionSet.retainAll(set2);
        System.out.println(intersectionSet);

        System.out.println("subset");
        Set<Integer>  subSet= new HashSet<>();
        subSet.addAll(unionSet);

        System.out.println(subSet.containsAll(intersectionSet));

        System.out.println("Difference");
        Set<Integer> diffSet = new HashSet<>();
        diffSet.addAll(unionSet);
         diffSet.removeAll(intersectionSet);
        System.out.println(diffSet);
        diffSet.clear();
        System.out.println(diffSet);

    }
}
