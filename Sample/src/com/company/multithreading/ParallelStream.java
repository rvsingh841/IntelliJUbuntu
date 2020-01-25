package com.company.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {
    public int processRecord(int input){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        return input+1;
    }
    public void processAllData(List<Integer> data){
        data.parallelStream().map(a->processRecord(a)).count();

    }
    public static void main(String[] args) {
        ParallelStream pl =new ParallelStream();
        List<Integer> list = new ArrayList<>();
        IntStream.range(-10000000,10000000).forEach(el->list.add(el));
        //System.out.println(list);
        long start = System.currentTimeMillis();
        pl.processAllData(list);
        double time = (System.currentTimeMillis()-start)/1000.0;

        System.out.println("Process completed in " + time + " seconds");
        Arrays.asList("jackal","kangaroo","lemur")
                .parallelStream()
                .map(el->{
                    System.out.println( el);return el.toUpperCase();}).forEach(System.out::println);

        List<Integer> integerList = Collections.synchronizedList(new ArrayList<>());
        Arrays.asList(1,2,3,4,5,6).parallelStream().map(el->{integerList.add(el); return el;})
                .forEachOrdered(el-> System.out.println(el));
        integerList.forEach(el-> System.out.println(el));
    }
}
