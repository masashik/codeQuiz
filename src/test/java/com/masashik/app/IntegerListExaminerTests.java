package com.masashik.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Arrays;
import java.util.stream.*;
import java.util.Random;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class IntegerListExaminerTests
{
    @Test
    public void oneMillionRequestForLongestEvenAndOddNumSubarrayExists() {

        int TENMILLION = 10000000;
        Random r = new Random();
        int[] inputs = new int[TENMILLION];
        for (int i = 0; i < TENMILLION; i++) {
            inputs[i] = Math.abs(r.nextInt() % 10);
        }

        List<Integer> inputArrayList = Arrays.stream(inputs).boxed().collect(Collectors.toList());

        long startTime = System.nanoTime();
        List<Integer> result = IntegerListExaminer.findLongestContiguousEvenNumSubarray(inputArrayList);
        long endTime = System.nanoTime();
        System.out.println("The execution time of findLongestContiguousEvenNumSubarray is: " + (endTime - startTime) + " nano seconds");

        startTime = System.nanoTime();
        result = IntegerListExaminer.findLongestEvenSublist(inputArrayList);
        endTime = System.nanoTime();
        System.out.println("The execution time of findLongestEvenSublist is: " + (endTime - startTime) + " nano seconds");
    }

    @Test
    public void onlyOneLongestEvenAndOddNumSubarrayExists() {
        int[] input = {2, 3, 4, 6, 3, 6, 8, 4, 6, 8};
        List<Integer> inputArrayList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> result = IntegerListExaminer.findLongestContiguousEvenNumSubarray(inputArrayList);
    }

    @Test
    public void moreThanOneLongestEvenAndOddNumSubarrayExists() {
        int[] input = {2, 3, 4, 6, 3, 6, 8, 1, 2, 4};
        List<Integer> inputArrayList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> result = IntegerListExaminer.findLongestContiguousEvenNumSubarray(inputArrayList);
    }

    @Test
    public void justOneEvenNumAndJustOneOddNum() {
        int[] input = {2, 1};
        List<Integer> inputArrayList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> result = IntegerListExaminer.findLongestContiguousEvenNumSubarray(inputArrayList);
        assertTrue(result.size() == 1);
    }

    @Test
    public void noEvenNum() {
        int[] input = {1, 3, 3};
        List<Integer> inputArrayList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> result = IntegerListExaminer.findLongestEvenSublist(inputArrayList);
        assertTrue(result.size() == 0);
    }

    @Test
    public void nullPointerExceptionHandling() {
        List<Integer> result = IntegerListExaminer.findLongestEvenSublist(null);
        assertNotNull(result);
    }

    @Test
    public void noNum() {
        int[] input = {};
        List<Integer> inputArrayList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> result = IntegerListExaminer.findLongestEvenSublist(inputArrayList);
    }
}
