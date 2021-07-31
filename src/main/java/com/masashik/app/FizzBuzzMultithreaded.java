package com.masashik.app;

import java.lang.Runnable;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {

	private int n;
	private int currentNum = 1;

	public FizzBuzzMultithreaded(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public synchronized void fizz(Runnable printFizz) throws InterruptedException {
		while (currentNum <= n) {
			if (currentNum % 3 == 0 && currentNum % 5 != 0) {
				//Only dividable by 3
				printFizz.run();
				currentNum++;
				notifyAll();
			} else {
				wait();
				continue;
			}
		}
	}

	// printBuzz.run() outputs "buzz".
	public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
		while (currentNum <= n) {
			if (currentNum % 5 == 0 && currentNum % 3 != 0) {
				//Dividable only by 5.
				printBuzz.run();
				currentNum++;
				notifyAll();
			} else {
				wait();
				continue;
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (currentNum <= n) {
			if (currentNum % 3 == 0 && currentNum % 5 == 0) {
				printFizzBuzz.run();
				currentNum++;
				notifyAll();
			} else {
				wait();
				continue;
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public synchronized void number(IntConsumer printNumber) throws InterruptedException {
		while (currentNum <= n) {
			if (currentNum % 3 != 0 && currentNum % 5 != 0) {
				printNumber.accept(currentNum);
				currentNum++;
				notifyAll();
			} else {
				wait();
				continue;
			}
		}
	}

	public static void main(String[] args) {

		int n = 15000000;

		Runnable printFizz = () -> { System.out.println("Fizz"); };
		Runnable printBuzz = () -> { System.out.println("Buzz"); };
		Runnable printFizzBuzz = () -> { System.out.println("FizzBuzz"); };
		IntConsumer printNum = num -> System.out.println(num);

		FizzBuzzMultithreaded fizzBuzzThread = new FizzBuzzMultithreaded(n);

		Thread fizzThread = new Thread(
						() -> {
							try {
								fizzBuzzThread.fizz(printFizz);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
		);

		Thread buzzThread = new Thread(
						() -> {
							try {
								fizzBuzzThread.buzz(printBuzz);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
		);

		Thread fizzbuzzThread = new Thread(
						() -> {
							try {
								fizzBuzzThread.fizzbuzz(printFizzBuzz);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
		);

		Thread numberThread = new Thread(
						() -> {
							try {
								fizzBuzzThread.number(printNum);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
		);

		fizzThread.start();
		buzzThread.start();
		fizzbuzzThread.start();
		numberThread.start();

	}
}
