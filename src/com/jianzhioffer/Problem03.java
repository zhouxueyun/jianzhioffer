package com.jianzhioffer;

/**
 * 一个二维数组，每一行从左到右递增，每一列从上到下递增.输 入一个二维数组和一个整数，判断数组中是否含有整数。
 * 
 * @author zhouxueyun
 */
public class Problem03 {

	public static void main(String[] args) {
		Problem03 test = new Problem03();
		int[][] testarray = new int[4][4];
		testarray[0][0] = 1;
		testarray[0][1] = 2;
		testarray[0][2] = 8;
		testarray[0][3] = 9;
		testarray[1][0] = 2;
		testarray[1][1] = 4;
		testarray[1][2] = 9;
		testarray[1][3] = 12;
		testarray[2][0] = 4;
		testarray[2][1] = 7;
		testarray[2][2] = 10;
		testarray[2][3] = 13;
		testarray[3][0] = 6;
		testarray[3][1] = 8;
		testarray[3][2] = 11;
		testarray[3][3] = 15;
		System.out.println(test.findNumberInMatrix(testarray, 7));
		System.out.println(test.findNumberInMatrix(testarray, 5));
	}

	public boolean findNumberInMatrix(int[][] data, int num) {
		if (data == null)
			return false;
		int rows = data.length;
		int columns = data[0].length;
		if (rows > 0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			while (row < rows && column >= 0) {
				if (data[row][column] == num) {
					return true;
				} else if (data[row][column] > num) {
					column--;
				} else {
					row++;
				}

			}
		}
		return false;
	}

}
