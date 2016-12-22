package com.jianzhioffer;

/**
 * 旋转数组的最小数字：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的 旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数
 * 组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为 1.
 * 
 * @author zhouxueyun
 */
public class Problem08 {

	public static void main(String[] args) {
		Problem08 test = new Problem08();
		// int[] array = { 1, 1, 1, 2, 0 };
		int[] array = { 3, 4, 5, 1, 2 };
		// int[] array = { 1, 0, 1, 1, 1 };
		System.out.println(test.findMinNum(array));
	}

	public int findMinNum(int[] array) {
		if (array == null)
			return -1;
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		int mid = 0; // 用中值快速查找
		while (array[leftIndex] >= array[rightIndex]) {
			if (rightIndex - leftIndex <= 1) {
				mid = rightIndex;
				break;
			}
			mid = (leftIndex + rightIndex) / 2;
			if (array[leftIndex] == array[rightIndex] && array[leftIndex] == array[mid]) {
				if (array[leftIndex + 1] != array[rightIndex - 1]) {
					// array[leftIndex + 1] < array[rightIndex - 1]
					// 为true时，最小值为array[leftIndex + 1]
					// 为false时，最小值为array[rightIndex - 1]
					mid = array[leftIndex + 1] < array[rightIndex - 1] ? (leftIndex + 1) : (rightIndex - 1);
					break;
				} else {
					leftIndex++;
					rightIndex--;
				}
			} else {
				if (array[mid] >= array[leftIndex]) // 位于前面的递增数组
					leftIndex = mid;
				else {
					if (array[mid] <= array[rightIndex]) // 位于后面的递增数组
						rightIndex = mid;
				}
			}
		}
		return array[mid];

	}

}
