package com.masashik.app;

import java.util.Collections;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.List;

public class PartitionArrayDisjointIntervals {

	public static void main(String[] args) {
		/**
		 * Example 1:
		 * Input: nums = [5,0,3,8,6]
		 * Output: 3
		 * Explanation: left = [5,0,3], right = [8,6]
		 *
		 * Example 2:
		 * Input: nums = [1,1,1,0, 6, 12]
		 * Output: 4
		 * Explanation: left = [1,1,1,0], right = [6,12]
		 *
		 * 2 <= nums.length <= 30000
		 * 0 <= nums[i] <= 10^6
		 *
		 *
		 */
//		int[] input1 = {1,1,1,0,6,12};
		//int[] input2 = {5,0,3,8,6};
		//int[] input3 = {1,1};
		//int[] input4 = {90,47,69,10,43,92,31,73,91,97};
		int[] input5 = {90,47,69,10,95,96,31,43,92,31,97};
		//int[] input6 = {90,47,69,10,96,92,31,95,43,97};
		//int[] input7=  {90,47,69,10,96,92,31,43,20,97};
		//int[] input8 = {90,47,69,10,96,20,91,93,30,97};
		//int[] input9 = {90,47,69,10,96,20, 91,93,96,97};
  	//int size = getLengthOfPartitionArrayDisjointIntervals(input);

//		int size1 = partitionDisjoint(input1);
		//int size2 = partitionDisjoint(input2);
		//int size3 = partitionDisjoint(input3);
		//int size4 = partitionDisjoint(input4);
		int size5 = partitionDisjoint(input5);
		//int size6 = partitionDisjoint(input6);
		//int size7 = partitionDisjoint(input7);
		//int size8 = partitionDisjoint(input8);
		//int size9 = partitionDisjoint(input9);

//		System.out.println("The length of left subarray is: " + size1);
		//System.out.println("The length of left subarray is: " + size2);
		//System.out.println("The length of left subarray is: " + size3);
		//System.out.println("The length of left subarray is: " + size4);
		System.out.println("The length of left subarray is: " + size5);
		//System.out.println("The length of left subarray is: " + size6);
		//System.out.println("The length of left subarray is: " + size7);
		//System.out.println("The length of left subarray is: " + size8);
		//System.out.println("The length of left subarray is: " + size9);
	}

	/**
	 * The following type of array will not be provided for this algorithm.
	 *
	 * [3,3,3,2,2,4,4,5,9(max),6,5,5,1(min),4,4,3,7,8,8]
	 * index of max < index of min
	 *
	 */
	public static int getLengthOfPartitionArrayDisjointIntervals(int[] nums) {

		if (nums.length >= 2 && nums.length <= 30000) {

			List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

			//Step 1.
			int maxNum = Collections.max(numsList);
			int minNum = Collections.min(numsList);

			if (maxNum == minNum) return 1;//All elements of array are equal numbers.

			//if (maxNum == nums[0]) return 0;//Max num locates at first element in the array.

			int maxNumFirstOccuranceIndex = IntStream.range(0, nums.length).filter(i -> nums[i] == maxNum).findFirst().orElse(-1);
			int minNumFirstOccuranceIndex = IntStream.range(0, maxNumFirstOccuranceIndex).filter(i -> nums[i] == minNum).findFirst().orElse(-1);

			//Split the array into left and right sub arrays at the first occurance index of max num.
			int[] left = Arrays.copyOfRange(nums, 0, minNumFirstOccuranceIndex + 1);
			int[] right = Arrays.copyOfRange(nums, maxNumFirstOccuranceIndex, nums.length);
			int[] middle = Arrays.copyOfRange(nums, minNumFirstOccuranceIndex + 1, maxNumFirstOccuranceIndex);
			

			List<Integer> leftList = Arrays.stream(left).boxed().collect(Collectors.toList());

			int maxNumLeft = Collections.max(leftList);


			int partitioningIndex = minNumFirstOccuranceIndex;


			int smallNumIndex = 0;
			for (int i = 0; i < middle.length; i++) {
				if (middle[i] < maxNumLeft) {
					smallNumIndex = i;
				}
			}

			if (smallNumIndex != 0) {
				partitioningIndex = partitioningIndex + (smallNumIndex + 1);
			} 

			return partitioningIndex + 1;//+1 to convert from index num to length of array

		} else {

			//Invalid input
			System.out.println("Invalid input...");
			return -1;
		}
	}

	/**
	 * Solution!
	 */

	public static int partitionDisjoint(int[] A) {

		System.out.println("original is: " + Arrays.toString(A));

		int N = A.length;
		int[] maxleft = new int[N];
		int[] minright = new int[N];

		int m = A[0];
		for (int i = 0; i < N; ++i) {
			m = Math.max(m, A[i]);
			maxleft[i] = m;
		}

		System.out.println("maxleft is: " + Arrays.toString(maxleft));

		m = A[N-1];
		for (int i = N-1; i >= 0; --i) {
			m = Math.min(m, A[i]);
			minright[i] = m;
		}

		System.out.println("minright is: " + Arrays.toString(minright));

		for (int i = 1; i < N; ++i)
			if (maxleft[i-1] <= minright[i])
				return i;

		throw null;
	}

}
