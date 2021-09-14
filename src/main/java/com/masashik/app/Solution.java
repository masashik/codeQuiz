package com.masashik.app;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Hourglass {
  public static int getLargestSum(List<List<Integer>> input) {

    // List<Integer> sums = new ArrayList<Integer>();

    int[] sums = new int[16];

    int counter = 0;

    for (int i = 0; i < 4; i++) {

      for (int j = 0; j < 4; j++) {

        Integer row1A = input.get(i).get(j);
        Integer row1B = input.get(i).get(j+1);
        Integer row1C = input.get(i).get(j+2);

        Integer row2 = input.get(i+1).get(j+1);

        Integer row3A = input.get(i+2).get(j);
        Integer row3B = input.get(i+2).get(j+1);
        Integer row3C = input.get(i+2).get(j+2);

        sums[counter++] = row1A + row1B + row1C + row2 + row3A + row3B + row3C;
      }

    }

    Arrays.sort(sums);

    return sums[sums.length-1];
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    List<List<Integer>> arr = new ArrayList<>();

    IntStream.range(0, 6).forEach(i -> {
      try {
        arr.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );

      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    System.out.println(Hourglass.getLargestSum(arr));

    bufferedReader.close();
  }
}