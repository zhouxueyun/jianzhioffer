package com.jianzhioffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 是则返回true，否则返回false。
 * 
 * @author zhouxueyun
 */
public class Problem24 {

	public static void main(String[] args) {
		Problem24 test = new Problem24();
		int[] array = { 5, 7, 6, 9, 11, 10, 8 };
		int[] array1 = { 7, 4, 6, 5 };
		int[] array2 = { 6, 7, 8, 5 };
		int[] array3 = { 6, 5, 8, 7 };
		System.out.println(test.verfiySequenceOfBST(array));
		System.out.println(test.verfiySequenceOfBST(array1));
		System.out.println(test.verfiySequenceOfBST(array2));
		System.out.println(test.verfiySequenceOfBST(array3));
	}

	public boolean verfiySequenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0)
			return false;
		if (sequence.length <= 2) // 如果序列只有一个或者两个元素，返回true
			return true;
		int length = sequence.length;
		int root = sequence[length - 1];
		int cut = -1;
		for (int i = 0; i < length - 1; i++) {
			// 找到分割位置
			if (sequence[i] > root) {
				cut = i;
				break;
			}
		}
		if (cut == -1) { // 找不到分割位置，左侧全比root小，直接判断左子数
			return verfiySequenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
		} else { // 正常情况，应该分割位置以及后面的数据均比root大，如果遇到比root小的，返回false
			for (int j = cut; j < length - 1; j++) { //
				if (sequence[j] < root)
					return false;
			}
		}
		boolean left = true;
		if (cut > 0)
			left = verfiySequenceOfBST(Arrays.copyOfRange(sequence, 0, cut));// 左子数
		boolean right = true;
		if (cut < length - 1)
			right = verfiySequenceOfBST(Arrays.copyOfRange(sequence, cut, length - 1)); // 右子数
		return (right && left);
	}

}
