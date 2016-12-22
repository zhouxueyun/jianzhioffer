package com.jianzhioffer;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位进制数。比如输入 3，则打 印出 1、2、3 一直到 999.
 * 
 * @author zhouxueyun
 */
public class Problem12 {

	public static void main(String[] args) {
		Problem12 test = new Problem12();
		test.print1ToMaxOfNDigits(3);
	}

	public void print1ToMaxOfNDigits(int n) {
		if (n <= 0)
			return;
		int[] num = new int[n];
		printArray(num);
		printArray(num, 0);
	}

	/**
	 * 全排列处理，复杂度 10^n*n
	 * 
	 * @param array
	 * @param n
	 */
	private void printArray(int[] array, int n) {
		for (int i = 0; i < 10; i++) {
			if (n != array.length) {
				array[n] = i;
				printArray(array, n + 1);
			} else {
				boolean isFirstNo0 = false;
				for (int j = 0; j < array.length; j++) {
					if (array[j] != 0) {
						System.out.print(array[j]);
						if (!isFirstNo0)
							isFirstNo0 = true;
					} else {
						if (isFirstNo0) {
							System.out.print(array[j]);
						}
					}
				}
				System.out.println();
				return;
			}
		}
	}

	/**
	 * 逐一处理，复杂度10^n*(0.5+0.5+1)n
	 * 
	 * @param array
	 */
	private void printArray(int[] array) {
		// 判断是否全为9
		boolean isAll9 = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 9) {
				isAll9 = false;
				break;
			}
		}
		if (isAll9)
			return;
		// 如果没有全为9，则处理下一个数
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == 9) {
				array[i] = 0;
			} else {
				array[i]++;
				break;
			}
		}
		// 打印一个特定的数
		boolean isFirstNot0 = false;
		for (int i = 0; i < array.length; i++) {
			if (isFirstNot0) {
				System.out.print(array[i]);
			} else if (array[i] != 0) {
				System.out.print(array[i]);
				isFirstNot0 = true;
			}
		}
		System.out.println();
		printArray(array);
	}

}
