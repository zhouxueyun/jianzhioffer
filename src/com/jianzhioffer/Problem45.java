package com.jianzhioffer;

/**
 * 圆圈中最后剩下的数字<br>
 * 0,1，...,n-1 这 n 个数排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。求出这个圆圈里剩下的最后一个数字。
 * 
 * @author zhouxueyun
 */
public class Problem45 {

	public static void main(String[] args) {
		Problem45 test = new Problem45();
		System.out.println(test.lastRemaining(6, 3));
	}

	public int lastRemaining(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}

}
