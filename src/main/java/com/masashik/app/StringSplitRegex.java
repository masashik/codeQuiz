package com.masashik.app;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class StringSplitRegex {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();

    // Write your code here.
    String[] tokens = s.split("[\\s.,'?]");

    List<String> tokenList = new java.util.ArrayList(java.util.Arrays.asList(tokens));

    Iterator<String> iterator = tokenList.iterator();

    while (iterator.hasNext()) {
      if (iterator.next().isEmpty()) {
        iterator.remove();
      }
    }

    System.out.println(tokenList.size());

    for (String token : tokenList) {
      System.out.println(token);
    }

    scan.close();
  }
}
