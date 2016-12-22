package com.jianzhioffer;

/**
 * 调整数组顺序使奇数位于偶数前面: 输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，使得
 * 所有奇数位于数组的前半部分，所有的数组位于数组的后半部分。
 * 
 * @author zhouxueyun
 */
public class Problem14 {

	public static void main(String[] args) {
		Problem14 test = new Problem14();
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		test.order(array);
		for (int item : array)
			System.out.println(item);
	}

	public void order(int[] array) {
		if (array == null || array.length == 0)
			return;
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			// 左边为偶数时停止
			while (start < end && !isEven(array[start]))
				start++;
			// 右边为奇数时停止
			while (start < end && isEven(array[end]))
				end--;
			// 左边的偶数与右边的奇数交换
			if (start < end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
	}

	/** 判断某个数是否是偶数 */
	private boolean isEven(int value) {
		return value % 2 == 0;
	}

}
