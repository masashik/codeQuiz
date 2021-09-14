package com.masashik.app;

import java.util.Scanner;

public class JavaLoop {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    for(int i=0; i<t; i++) {

      int a = in.nextInt();
      int b = in.nextInt();
      int n = in.nextInt();

      int sum = 0;
      sum = sum + a;

      for (int m = 0; m < n; m++) {

        //(2), (0+2+4=6), (6+2^2*2=14), (14+2^3*2=30)
        //5 + 2 = 7

        sum += (Math.pow(2,m) * b);
        System.out.print(sum);
        System.out.print(" ");
      }
      System.out.println();
      //in.nextInt();
    }
    in.close();
  }
}
