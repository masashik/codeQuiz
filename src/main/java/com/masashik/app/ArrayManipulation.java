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

public class ArrayManipulation {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, m).forEach(i -> {
      try {
        queries.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    long result = Result.arrayManipulation(n, queries);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}



class Result {

  /*
   * Complete the 'arrayManipulation' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY queries
   */

  public static long arrayManipulation(int n, List<List<Integer>> queries) {

    /**
     1. Prepare int[] result = new int[n]; and initialize with 0;
     2. Get each query list from List<List<Integer>>
     3. Get each query from List<Integer>
     4. Read a query, find a, b, k.
     5. Add k between [a-1] and [b-1]
     6. Repeat 4. by the number of queries.size()
     7. Find the largest number from int[n]
     8. Return the largest number.
     */

    // Write your code here

    //1.
    long[] result = new long[n];

    // initialization to 0 is a default operation.
    // for (int i = 0; i < n; i++) {
    //   result[i] = 0;
    // }

    //2.
    for (int i = 0; i < queries.size(); i++) {
      //3.
      List<Integer> query = queries.get(i);
      //4.
      int a = query.get(0).intValue();
      int b = query.get(1).intValue();
      int k = query.get(2).intValue();
      //5. //6.
      for (int j = a-1; j < b; j++) {
        result[j] += k;
      }
    }

    //7.
    // long largestNum = result[0];
    // for (int i = 1; i < result.length; i++) {
    //   if (largestNum < result[i])
    //     largestNum = result[i];
    // }

    Arrays.sort(result);

    //8.
    return result[result.length - 1];

  }

}

