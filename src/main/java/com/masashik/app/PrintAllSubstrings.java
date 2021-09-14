package com.masashik.app;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintAllSubstrings {

  public static String getSmallestAndLargest(String s, int k) {

    String smallest = "";
    String largest = "";
    List<String> substrings = new ArrayList<String>();

    // Complete the function
    // 'smallest' must be the lexicographically smallest substring of length 'k'
    // 'largest' must be the lexicographically largest substring of length 'k'
    for (int i = 0; i <= s.length() - k; i++) {
      substrings.add(s.substring(i,k+i));
    }

    /**
     * Sort substrings by lexicographical order.
     */

    // Approach 1: Traditional Comparator
    //Collections.sort(substrings, new LexicographicalSort());

    // Approach 2: Lambda
    substrings.sort((String a, String b) -> a.compareTo(b));

    //Get smallest and largest substring.
    smallest = substrings.get(0);
    largest = substrings.get(substrings.size() - 1);

    //Concatenate the result and return it.
    return smallest + "\n" + largest;
  }


  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int k = scan.nextInt();
    scan.close();

    System.out.println(getSmallestAndLargest(s, k));
  }
}

class LexicographicalSort implements Comparator<String> {
  public int compare(String a, String b) {
    return a.compareTo(b);
  }
}