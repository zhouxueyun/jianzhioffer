package com.jianzhioffer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 
 * @author zhouxueyun
 */
public class Problem20 {

	public static void main(String[] args) {
		Problem20 test = new Problem20();
		int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },{ 13, 14, 15, 16 } };
		// int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		// int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		test.printMatixClockwisely(array);
	}

	public void printMatixClockwisely(int[][] array) {
		if (array == null)
			return;
		int start = 0;
		while (array.length > start * 2 && array[0].length > start * 2) {
			printOneCircle(array, start);
			start++;
		}
	}

	private void printOneCircle(int[][] array, int start) {
		if (array.length - 1 - start == start && array[0].length - 1 - start == start) {
			// 行与列均为1
			System.out.print(array[start][start] + " ");
		} else if (array.length - 1 - start == start && array[0].length - 1 - start > start) {
			// 行为1
			for (int i = start; i < array[0].length - start; i++) {
				System.out.print(array[start][i] + " ");
			}
		} else if (array[0].length - 1 - start == start && array.length - 1 - start > start) {
			// 列为1
			for (int i = start; i < array.length - start; i++) {
				System.out.print(array[i][start] + " ");
			}
		} else {
			// 行大于1且列大于1
			// 向右
			for (int i = start; i < array[0].length - 1 - start; i++) {
				System.out.print(array[start][i] + " ");
			}
			// 向下
			for (int i = start; i < array.length - 1 - start; i++) {
				System.out.print(array[i][array[0].length - 1 - start] + " ");
			}
			// 向左
			for (int i = array[0].length - 1 - start; i > start; i--) {
				System.out.print(array[array.length - 1 - start][i] + " ");
			}
			// 向上
			for (int i = array.length - 1 - start; i > start; i--) {
				System.out.print(array[i][start] + " ");
			}
		}
	}

}
