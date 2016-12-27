package com.jianzhioffer;

/**
 * 我们把只包含因子 2,3,和 5 的称为丑数。求按从小到大的顺序的第 1500 个丑数。<br>
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7. 习惯上我们把 1 当做第一个丑数。
 * 
 * @author zhouxueyun
 *
 */
public class Problem34 {

	public static void main(String[] args) {
		Problem34 test = new Problem34();
		System.out.println(test.getUglyNumber(50));
	}

	/**
	 * 利用已有的丑数计算下一个丑数
	 * @param n
	 * @return
	 */
	public int getUglyNumber(int n) {
		if (n <= 0)
			return 0;
		int[] uglyArray = new int[n];
		uglyArray[0] = 1;
		int p2 = 0;
		int p3 = 0;
		int p5 = 0;
		for (int i = 1; i < uglyArray.length; i++) {
			// 比较的时候从已有数组中取出数据，再进行乘法判断
			int min = min(uglyArray[p2] * 2, uglyArray[p3] * 3, uglyArray[p5] * 5);
			uglyArray[i] = min;
			while (uglyArray[p2] * 2 <= min)
				p2++;
			while (uglyArray[p3] * 3 <= min)
				p3++;
			while (uglyArray[p5] * 5 <= min)
				p5++;
		}
		return uglyArray[n - 1];
	}

	private int min(int i, int j, int k) {
		int min = (i < j) ? i : j;
		return (min < k) ? min : k;
	}

}
