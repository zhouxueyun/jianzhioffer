package com.jianzhioffer;

/**
 * 题目:求 1+2+...+n,要求不能用除法、for、while、if、else、switch、case 等关键字及条件判断语句(A?B:C)。
 * 
 * @author zhouxueyun
 */
public class Problem46 {

	public static void main(String[] args) {
		Problem46 test = new Problem46();
		System.out.println(test.sum1(100));
	}

	public int sum1(int n) {
		try {
			int[] array = new int[n - 2]; // 当n=1时，即new
											// int[-1]时，会出现java.lang.NegativeArraySizeException，代替判断语句
			return n + sum1(n - 1);
		} catch (Exception e) {
			return 1;
		}
	}

}
