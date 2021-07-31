package com.masashik.app;

import java.util.List;
import java.util.ArrayList;

public class IntegerListExaminer {

	/**
	 * Given a list of Integers, return a list that contains the elements that form the longest sublist 
	 * of even integers in the list. If two sublists are of equal length, the first subset is returned.
	 *
	 * Ex.
	 * [1 3 3] returns []
	 * [2 3 3] returns [2]
	 * [2 3 4 6 3] returns [4 6]
	 * [2 3 4 6 3 6 8] returns [4 6]
	 */

	//Main Function
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		List<Integer> foundSublist = findLongestEvenSublist(list);

		int longestSublistSize = foundSublist.size();

		System.out.println("The longest even sublist size is " + longestSublistSize);

		String foundSublistToString = "";
		if (longestSublistSize > 0) {
			StringBuilder foundSublistArray = new StringBuilder();
			for (Integer i : foundSublist) {
				foundSublistArray.append(String.valueOf(i));
				foundSublistArray.append(",");
			}
			foundSublistToString = foundSublistArray.toString().substring(0, foundSublistArray.length() - 1);
		}
		System.out.println("The longest even sublist is " + "[" + foundSublistToString + "]");
	}

	//Function to find the longest subarray of contiguous even integers
	public static List<Integer> findLongestEvenSublist(List<Integer> list) {

		List<List<Integer>> listOfSublist = new ArrayList<>();

		if (list == null || list.size() == 0) {

			//Input list does not have any item.
			return new ArrayList<Integer>();

		} else {

			//Input list has items.
			List<Integer> sublists = new ArrayList<>();

			// O(N)
			for (int i = 0; i < list.size(); i++) {

				if (list.get(i) % 2 == 0) {
					//i is an even num.
					sublists.add(list.get(i));
				} 
				else {
					//i is an odd num.
					if (sublists.size() > 0) {
						listOfSublist.add(sublists);
						sublists = new ArrayList<>();
					}
				}
			}

			if (sublists.size() > 0) {
				listOfSublist.add(sublists);
			}

			//System.out.println(listOfSublist.size());

			if (sublists.size() == list.size()) {
				//All items in the list are even num.
				return list;
			}

			List<Integer> longestSizedList = new ArrayList<Integer>();

			// O(N)
			//Find the longest sized list from sublists.
			for (List<Integer> comparingSublist : listOfSublist) {
				if (comparingSublist.size() > longestSizedList.size()) {
					longestSizedList = comparingSublist;
				}
			}

			return longestSizedList;
		}
	}

	/**
	 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
	 * https://www.baeldung.com/java-maximum-subarray
	 * @param input Integer list.
	 * @return Contiguous even number subarray.
	 */
	public static List<Integer> findLongestContiguousEvenNumSubarray(List<Integer> input) {

		int n = input.size();
		int longest_start = 0;
		int longest_start_until_now = 0;
		int longest_end = 0;
		int counter = 0;
		int currentLongestEvenNumSubarraySize = 0;
		List<Integer> subArrayList = new ArrayList<Integer>();

		// O(N)
		for (int i = 0; i < n; i++) {
			if (input.get(i) % 2 == 0) {
				counter++;
				if (counter > currentLongestEvenNumSubarraySize) {
					currentLongestEvenNumSubarraySize = counter;
					longest_start = longest_start_until_now;
					longest_end = i;
				}
			} else {
				//Reset counter
				counter = 0;
				//Move the longest start index cursor to next.
				longest_start_until_now = i + 1;
			}
		}

		// O(M)
		for (int i = longest_start; i <= longest_end; i++) {
			subArrayList.add(input.get(i));
		}
		// O(M+N) = O(2N) = O(N)
		return subArrayList;
	}
}
