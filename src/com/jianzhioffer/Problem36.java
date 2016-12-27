package com.jianzhioffer;

/**
 * 在数组中的两个数字如果前一个数字大于后一个数字，则这两个数字组成一个逆序对。 <br>
 * 输入一个数组，求出这个数组的逆序对的总数。例如在数组{7,5,6,4} 中，一共存在 5 个逆序对，分别是(7,6)、(7、5)，(7、4)，(6、4)，
 * (5、4)。
 * 
 * @author zhouxueyun
 *
 */
public class Problem36 {

	public static void main(String[] args) {
		Problem36 test = new Problem36();
		int[] array = { 7, 5, 6, 4 };
		System.out.println(test.inversePairs(array));
	}

	public int inversePairs(int[] array) {
		if (array == null)
			return 0;
		int[] copy = array.clone(); 
		return mergeSort(array, copy, 0, array.length - 1);
	}

	/**
	 * 
	 * @param array
	 * @param copy
	 * @param start
	 * @param end
	 * @return
	 */
	private int mergeSort(int[] array, int[] copy, int start, int end) {
		if (start == end) {
			copy[start] = array[start];
			return 0;
		}
		int length = (end - start) / 2;
		int left = mergeSort(copy, array, start, start + length);
		int right = mergeSort(copy, array, start + length + 1, end);
		// 逆序对总数
		int count = 0;
		// 前半段最后一个下标
		int leftIndex = start + length;
		// 后半段最后一个下标
		int rightIndex = end;
		int point = end;
		// 合并排序，并统计逆序对
		while (leftIndex >= start && rightIndex >= start + length + 1) {
			if (array[leftIndex] > array[rightIndex]) {
				copy[point--] = array[leftIndex--];
				count += rightIndex - start - length; // 从rightIndex直到后半段开头
			} else {
				copy[point--] = array[rightIndex--];
			}
		}
		// 下面的两个循环只有一个有效
		for (int i = leftIndex; i >= start; i--)
			copy[point--] = array[i];
		for (int j = rightIndex; j >= start + length + 1; j--)
			copy[point--] = array[j];
		return left + right + count;
	}
}
