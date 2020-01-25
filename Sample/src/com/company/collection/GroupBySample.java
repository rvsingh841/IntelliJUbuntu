package com.company.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBySample {
    public static void main(String[] args) {
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya", "orange", "orange", "orange");
        Map<String,Long> integerMap = items.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(integerMap);
        Map<String ,Long> sortedMap = new TreeMap<>();
        sortedMap.putAll(integerMap);
        System.out.println(sortedMap);

        //sorting by value
        List<Map.Entry<String,Long>> hm = new ArrayList<>();
        integerMap.entrySet().stream().forEachOrdered(li->hm.add(li));
        System.out.println(hm);
        Collections.sort(hm,(a,b)->{
           return b.getValue().compareTo(a.getValue());
        });



    }
}
