package com.jianzhioffer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。<br>
 * 2-10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，而大小王可以看成任意的数字。
 * 
 * @author zhouxueyun
 *
 */
public class Problem44 {

	public static void main(String[] args) {
		int[] array = { 0, 4, 6, 8, 0 };
		Problem44 test = new Problem44();
		System.out.println(test.isContinuous(array));
	}

	public boolean isContinuous(int[] number) {
		if (number == null) {
			return false;
		}
		Arrays.sort(number);
		int numberZero = 0;
		int numberGap = 0;
		// 先判断有几个0
		for (int i = 0; i < number.length && number[i] == 0; i++) {
			numberZero++;
		}
		int small = numberZero;
		int big = small + 1;
		// 判断数字中间有多少空缺
		while (big < number.length) {
			if (number[small] == number[big]) // 两数相等，不满足情况
				return false;
			numberGap += number[big] - number[small] - 1;
			small = big;
			big++; // 向后遍历
		}
		return (numberGap > numberZero) ? false : true; // 如果空缺数量大于0的个数，不满足情况
	}

}
