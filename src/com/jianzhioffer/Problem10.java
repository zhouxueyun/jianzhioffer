package com.jianzhioffer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。 例如把9表示成二进制是1001;有2位是1，因此如果输入9，函数输出2.
 * 
 * @author zhouxueyun
 */
public class Problem10 {

	public static void main(String[] args) {
		Problem10 test = new Problem10();
		System.out.println(test.numberOf1InBinary(9));
		System.out.println(test.numberOf1InBinary(15));
	}

	public int numberOf1InBinary(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = n & (n - 1);
		}
		return count;
	}

}
