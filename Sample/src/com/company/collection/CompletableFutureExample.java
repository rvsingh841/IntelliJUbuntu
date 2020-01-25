package com.company.collection;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(5, 9, 14);
    integerList.stream()
        .map(num -> CompletableFuture.supplyAsync(() -> getNumber(num)))
        .map(CompletableFuture -> CompletableFuture.thenApply(n -> n * n))
        .map(t -> t.join())
        .forEach(s -> System.out.println(s));
  }

  private static int getNumber(int num) {
    return num * num;
  }
}
