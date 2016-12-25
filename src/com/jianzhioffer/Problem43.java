package com.jianzhioffer;

/**
 * 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s。输入 n，打印 出 s 的所有可能的值出现的概率。
 * 
 * @author zhouxueyun
 */
public class Problem43 {

	public static void main(String[] args) {
		Problem43 test = new Problem43();
		test.printProbability(2);
	}

	private void printProbability(int number) {
		if (number < 1)
			return;
		int gMaxValue = 6;
		int[][] probabilities = new int[2][];
		probabilities[0] = new int[gMaxValue * number + 1];
		probabilities[1] = new int[gMaxValue * number + 1];
		int flag = 0;
		for (int i = 1; i < gMaxValue; i++) {
			probabilities[flag][i] = 1;
		}
		for (int k = 2; k <= number; ++k) {
			for (int i = 0; i < k; i++) {
				probabilities[1 - flag][i] = 0;
			}
			for (int i = k; i <= gMaxValue * k; i++) {
				probabilities[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= gMaxValue; j++)
					probabilities[1 - flag][i] += probabilities[flag][i - j];
			}
			flag = 1 - flag;
		}
		double total = Math.pow(gMaxValue, number);
		for (int i = number; i < gMaxValue * number; i++) {
			double ratio = (double) probabilities[flag][i] / total;
			System.out.print(i + " ");
			System.out.println(ratio);
		}
	}

}
