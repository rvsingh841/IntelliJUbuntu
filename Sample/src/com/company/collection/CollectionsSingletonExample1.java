package com.company.collection;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class CollectionsSingletonExample1 {
  public static void main(String[] args) {
      List<Integer> integerList = new ArrayList<>();
      Collections.addAll(integerList,1, 2, 4, 2, 7, 2, 4, 4);
      System.out.println(integerList);
        integerList.remove(7);
    System.out.println(integerList);
    //integerList.removeAll(Collections.singleton(4));
    integerList.removeAll(Arrays.asList(4));
    System.out.println(integerList);
      // Create a list of Integers
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(30);
      al.add(20);
      al.add(10);
      al.add(40);
      al.add(50);
    al.stream()
        .sorted(
            (a, b) -> {

              return b.compareTo(a);
            })
        .forEach(System.out::println);
    Collections.sort(al,Collections.reverseOrder());
    System.out.println(al);
    integerList.stream().sorted(
            (a, b) -> {

                return b.compareTo(a);
            })
            .forEach(System.out::println);

      ArrayList<Student> ar = new ArrayList<Student>();
      ar.add(new Student(111, "bbbb", "london"));
      ar.add(new Student(131, "aaaa", "nyc"));
      ar.add(new Student(121, "cccc", "jaipur"));

      Collections.sort(ar,(a,b)->a.id-b.id);
    System.out.println(ar);
      Collections.sort(ar,(a,b)->a.name.compareTo(b.name));
      System.out.println(ar);
      ar.stream().sorted((a,b)->a.address.compareTo(b.address));

      TreeSet<String> treeSet = new TreeSet<>();

      treeSet.add("Geeks");

      treeSet.add("Geeks");
      treeSet.add("GeeksforGeeks");
      treeSet.add("for");

      System.out.println(treeSet);

      System.out.println("\n");
      Arrays.asList("Geeks", "GeeksforGeeks", "for").stream().sorted((a,b)->a.compareTo(b)).forEach(System.out::println);
  }


}
