package com.jianzhioffer;

/**
 * 写一个函数，输入 n，求斐波那契数列的第 n 项。
 * 
 * @author zhouxueyun
 */
public class Problem09 {

	public static void main(String[] args) {
		Problem09 test = new Problem09();
		System.out.println(test.fibonacci(12));
		System.out.println(test.fibonacciRecursion(12));
	}

	public long fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);

	}

	public long fibonacciRecursion(int n) {
		long result = 0;
		long preOne = 0;
		long preTwo = 1;
		if (n == 0)
			return preOne;
		if (n == 1)
			return preTwo;
		for (int i = 2; i <= n; i++) {
			result = preOne + preTwo;
			preOne = preTwo;
			preTwo = result;
		}
		return result;
	}

}
