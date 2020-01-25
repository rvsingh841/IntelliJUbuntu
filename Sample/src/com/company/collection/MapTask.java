package com.company.collection;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*Input: item[] = {“toy”, “pen”, “notebook”, “pen”}, price[] = {2, 1, 3, 2}
        Output:
        Item Min Max Average
        pen 1 2 1.5
        toy 2 2 2.0
        notebook 3 3 3.0*/
public class MapTask {
    public static void main(String[] args) {
        List<Item> itemList = Arrays.asList(new Item("toy",2),
                new Item("pen",1),
                new Item("notebook",3),
                new Item("pen",2));
        System.out.println(itemList.stream().collect(Collectors.groupingBy(Item::getName,Collectors.summingDouble(Item::getPrice))));
        System.out.println(itemList.stream().collect(Collectors.groupingBy(Item::getName,Collectors.minBy(Comparator.comparing(Item::getName)))));
        Map<String,Optional<Item>> minMap = itemList.stream().collect(Collectors.groupingBy(Item::getName,Collectors.minBy(Comparator.comparing(Item::getName))));
        System.out.println("Min Values");
        minMap.values().forEach(el-> System.out.println((el.get())));
        System.out.println("Max Values");
        Map<String,Optional<Item>> maxMap = itemList.stream().collect(Collectors.groupingBy(Item::getName,Collectors.maxBy(Comparator.comparing(Item::getName))));
        System.out.println("Average Values");
        maxMap.values().forEach(el-> System.out.println(el.get()));
        Map<String,Double> avgMap = itemList.stream().collect(Collectors.groupingBy(Item::getName,Collectors.averagingDouble(Item::getPrice)));
        avgMap.values().forEach(el-> System.out.println(el));


        Map<Integer,Item> map = new HashMap<>();
        AtomicInteger counter = new AtomicInteger(0);
        itemList.forEach(el->{


            map.put(counter.incrementAndGet(),el);


        });
        map.forEach((k,v)-> System.out.println("key==" + k + " value == "+v));



    }

}

class Item{
    private String name;
    private float price;

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

