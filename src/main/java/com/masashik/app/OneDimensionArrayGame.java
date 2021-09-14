package com.masashik.app;

import java.util.Scanner;

public class OneDimensionArrayGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println();
			System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
		}
		scan.close();
	}

	public static boolean canWin(int leap, int[] game) {
		// Return true if you can win the game; otherwise, return false.
		boolean canWin = false;
		for (int i = 1; i < game.length; i++) {
			if (game[i] == 0) {
				//User stand on the last index.
				if (i == (game.length - 1)) {
					canWin = true;
					break;
				}

				//Move to next index.
				continue;
			} else {
				//Try leap
				int destinationIndex = (i-1) + leap;
				if (destinationIndex > game.length - 1) {
					//leap over the last index of the game array.
					canWin = true;
					break;
				} else {
					//Cannot leap over the last index of the game array.
					if (game[destinationIndex] != 0) {

						//Continuously move back and check if each step back can enable to land on zero.
						while (i > 0 && game[i-1] == 0) {
							int newDestinationIndex = (i-1) + leap;
							if (game[newDestinationIndex] == 0) {
								i = newDestinationIndex;
								break;
							}
							i--;
						}

						if (i == 0) {
							//Dead end and game over.
							canWin = false;
							break;
						}

					} else {
						//Leap and landed on the before last index, and it is zero.
						i = (i - 1) + leap;
						continue;
					}
				}
			}
		}
		return canWin;
	}

	/**
	 * Recursion approach
	 */

	//public static boolean canWin(int leap, int[] game) {
	//	return isSolvable(leap, game, 0);
	//}     
	//private static boolean isSolvable(int m, int[] arr, int i) {
	//	if (i < 0 || arr[i] == 1) return false;
	//	if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

	//	arr[i] = 1;
	//	return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
	//}
}
