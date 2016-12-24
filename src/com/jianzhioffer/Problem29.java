package com.jianzhioffer;

/**
 * 数组中有一个数字出现次数超过数组长度的一半，请找出这个数字。例如 输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。2出现的次数超过数组长度的
 * 一半，因此输出2.
 * 
 * @author zhouxueyun
 */
public class Problem29 {

	public static void main(String[] args) {
		Problem29 test = new Problem29();
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(test.moreThanHalfNum(array));
	}

	public Integer moreThanHalfNum(int[] array) {
		if (array == null)
			return null;
		int count = 0;
		Integer rstInt = null;
		for (int i = 0; i < array.length; i++) {
			if (count == 0) { // 当count设为1的时候，记录结果整数
				rstInt = array[i];
				count++;
			} else {
				if (array[i] == rstInt) {
					count++;
				} else {
					count--;
				}
			}
		}
		if (checkMoreThanHalf(array, rstInt))
			return rstInt;
		else
			return null;

	}

	private boolean checkMoreThanHalf(int[] array, Integer number) {
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number)
				times++;
		}
		if (times * 2 > array.length)
			return true;
		else
			return false;
	}

}
