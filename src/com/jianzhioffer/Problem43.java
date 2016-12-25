package com.jianzhioffer;

/**
 * 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s。输入 n，打印 出 s 的所有可能的值出现的概率。
 * 
 * @author zhouxueyun
 */
public class Problem43 {

	public static void main(String[] args) {
		Problem43 test = new Problem43();
		test.printProbability(3);
	}

	/**
	 * n个骰子出现的可能的总和和及出现概率
	 * @param n 骰子个数
	 */
	private void printProbability(int n) {
		if (n < 1)
			return;
		int gMaxValue = 6;
		// 一行处理k-1个骰子出现的次数，另一行处理k个骰子出现的次数
		int[][] probabilities = new int[2][];
		probabilities[0] = new int[gMaxValue * n + 1];
		probabilities[1] = new int[gMaxValue * n + 1];
		int flag = 0;
		// 处理第1个骰子
		for (int value = 1; value <= gMaxValue; value++) {
			probabilities[flag][value] = 1;
		}
		// 处理第2个到第number个骰子
		for (int k = 2; k <= n; k++) { // k表示第k个骰子
			// 将小于骰子个数的item置为0，因为不可能出现这种情况
			for (int i = 0; i < k; i++) {
				probabilities[1 - flag][i] = 0; 
			}
			for (int sum = k; sum <= gMaxValue * k; sum++) { // sum 代表k个骰子出现点数的总和
				probabilities[1 - flag][sum] = 0; // 先置0
				for (int newValue = 1; newValue <= sum && newValue <= gMaxValue; newValue++) { 
					// newValue 表示第k个骰子出现的数
					// newValue <= sum 表示单个骰子的值不可能超过sum
					// newValue <= gMaxValue 表示最多只有1~gMaxValue种情况
					// diff 表示如果第k个骰子的点数为j，则前k-1个骰子的和应该为diff
					int diff = sum - newValue;
					probabilities[1 - flag][sum] += probabilities[flag][diff];
				}
			}
			flag = 1 - flag; // 交换数组，进行下一个骰子的处理
		}
		double total = Math.pow(gMaxValue, n);
		for (int i = n; i <= gMaxValue * n; i++) {
			double ratio = (double) probabilities[flag][i] / total;
			System.out.print(i + " ");
			System.out.println(ratio);
		}
	}

}
