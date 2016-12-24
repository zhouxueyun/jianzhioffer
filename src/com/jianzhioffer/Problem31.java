package com.jianzhioffer;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n)。例
 * 如输入的数组为{1，-2,3,10，-4,7,2，-5}，和最大的子数组为{3,10，-4,7,2}。
 * 
 * @author zhouxueyun
 */
public class Problem31 {

	public static void main(String[] args) {
		Problem31 test = new Problem31();
		int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(test.findGreatestSubArray(array));
	}

	public int findGreatestSubArray(int[] array) {
		if (array==null)
			return 0;
		int currSum = 0;
		int graatestSum = 0;
		for (int i = 0; i < array.length; i++) {
			if (currSum<=0)
				currSum=array[i];
			else
				currSum+=array[i];
			if (currSum>graatestSum){
				graatestSum = currSum;
			}
		}
		return graatestSum;
	}

}
