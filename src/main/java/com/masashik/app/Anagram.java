package com.masashik.app;

import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Anagram {
  public static void main(String[] args) {

    List<Character> compareA = "Masashi".toLowerCase().chars().mapToObj(c -> (char)c).collect(Collectors.toList());
    List<Character> compareB = "Misasha".toLowerCase().chars().mapToObj(c -> (char)c).collect(Collectors.toList());

    java.util.Collections.sort(compareA);
    java.util.Collections.sort(compareB);

    final int size = compareA.size();
    Iterator iterator = compareB.iterator();
    // Find same element of the list from other list and delete both.
    for (int i = 0; i < size; i++) {
        while(iterator.hasNext()) {
          if (iterator.next().equals(compareA.get(i))) {
            iterator.remove();
            compareA.remove(i);
          }
        }
    }

    if (compareB.size() > 0)
      System.out.println("Not Anagrams");
    else
      System.out.println("Anagrams");
  }
}
