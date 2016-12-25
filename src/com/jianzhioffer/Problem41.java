package com.jianzhioffer;

/**
 * 题目1：<br>
 * 输一个递增排序的数组和一个数字 s,在数组中查找两个数使得它们的 和正好是 s。如果有多对数字的和等于 s，输出任意一对即可。<br>
 * 例如:输入数组 {1,2,4,7,11,15}和数字为 15.输出 4 和 11. 题目二:<br>
 * 输入一个正数 s，打印出所有和为 s 的连续正数序列(至少含两个数)。 <br>
 * 例如输入 15，由于 1+2+3+4+5=4+5+6=7+8=15，所以结果打印出 3 个连续序列 1-5、 4-6、和 7-8.
 * 
 * @author zhouxueyun
 */
public class Problem41 {

	public static void main(String[] args) {
		Problem41 test = new Problem41();
		int[] array = new int[] { 1, 2, 4, 7, 11, 15 };
		System.out.println(test.findNumberWithSum(array, 15));
		test.findContinuesSequence(15);
	}

	/**
	 * 题目1
	 * 
	 * @param data
	 * @param sum
	 * @return
	 */
	public boolean findNumberWithSum(int[] data, int sum) {
		boolean found = false;
		if (data == null)
			return found;
		int num1 = 0;
		int num2 = 0;
		int start = 0;
		int end = data.length - 1;
		while (start < end) {
			int curSum = data[start] + data[end];
			if (curSum == sum) { // 相等，输出
				num1 = data[start];
				num2 = data[end];
				found = true;
				break;
			} else if (curSum > sum) // 大于，end向前
				end--;
			else // 小于，start向后
				start++;
		}
		System.out.println(num1);
		System.out.println(num2);
		return found;
	}

	/**
	 * 题目2
	 * 
	 * @param sum
	 */
	public void findContinuesSequence(int sum) {
		if (sum < 3)
			return;
		int small = 1; // 序列中小的数
		int big = 2; // 序列中大的数
		int middle = (1 + sum) / 2;
		int curSum = small + big;
		while (small < middle) {
			if (curSum == sum) {
				printContineNum(small, big);
			}
			while (curSum > sum && small < middle) {
				curSum -= small; // 小数向后移位
				small++;
				if (curSum == sum)
					printContineNum(small, big);
			}
			big++; // 大数向后移位
			curSum += big;
		}
	}

	private void printContineNum(int small, int big) {
		for (int i = small; i <= big; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
