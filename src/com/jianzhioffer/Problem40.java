package com.jianzhioffer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。<br>
 * 请写程序 找出这两个只出现一次的数字。要求时间复杂度是 O(n)，空间复杂度为 O(1)
 * 
 * @author zhouxueyun
 *
 */
public class Problem40 {

	public static void main(String[] args) {
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		Problem40 test = new Problem40();
		test.findNumsAppearOnce(array);
	}

	public void findNumsAppearOnce(int[] array) {
		if (array == null)
			return;
		int number = 0;
		for (int i : array)
			number ^= i;
		// number为两个只出现一次的数的^，需要找到这两个数的差异
		int index = findFirstBitIs1(number);
		int number1 = 0;
		int number2 = 0;
		// 将array按照两数的差异分为两组求^
		for (int i : array) {
			if (isBit1(i, index))
				number1 ^= i;
			else
				number2 ^= i;
		}
		System.out.println(number1);
		System.out.println(number2);
	}

	private int findFirstBitIs1(int number) {
		int indexBit = 0;
		while ((number & 1) == 0) {
			number = number >> 1;
			++indexBit;
		}
		return indexBit;
	}

	private boolean isBit1(int number, int index) {
		number = number >> index;
		return (number & 1) == 0;
	}

}
