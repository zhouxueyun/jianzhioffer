package com.jianzhioffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则 运算符号。
 * 
 * @author zhouxueyun
 */
public class Problem47 {

	public static void main(String[] args) {
		Problem47 test = new Problem47();
		System.out.println(test.add(8, 16));
	}

	public int add(int num1, int num2) {
		int sum;
		int carry;
		while (true) {
			sum = num1 ^ num2; // 不含进位的和
			carry = (num1 & num2) << 1; // 进位
			if (carry == 0) // 无进位时跳出
				break;
			num1 = sum;
			num2 = carry;
		}
		return sum;
	}

}
