package com.masashik.app;

import java.util.Scanner;

public class JavaRegexMatcher {
  public static void main(String[] args){

    /**
     * INPUT-----------
     * 12.12.12.12
     * 13.13.13.112
     * VUUT.12.12
     * 111.111.11.111
     * 1.1.1.1.1.1.1
     * .....
     * 1...1..1..1
     * 0.0.0.0
     * 255.0.255.0
     * 266.266.266.266
     * 00000.000000.0000000.00001
     * 0023.0012.0012.0034
     *
     * OUTPUT Expected----------
     * true
     * true
     * false
     * true
     * false
     * false
     * false
     * true
     * true
     * false
     * false
     * false
     * -------
     * true
     * true
     * false
     * true
     * false
     * false
     * false
     * true
     * true
     * true
     * false
     * false
     */


    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      String IP = in.next();
      System.out.println(IP.matches(new MyRegex().pattern));
    }

    in.close();

  }
}

class MyRegex {
  String pattern = "([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
}