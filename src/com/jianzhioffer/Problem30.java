package com.jianzhioffer;

import java.util.Arrays;

/**
 * 输入 n 个整数，找出其中最小的 k 个数。例如输入 4,5,1,6,2,7,3,8 这 8 个数字，则最小的 4 个数字是 1,2,3,4.
 * 
 * @author zhouxueyun
 */
public class Problem30 {

	public static void main(String[] args) {
		Problem30 test = new Problem30();
		int[] array = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
		test.getLeastNumber(array, 3);
		test.getLeastNumber(array, 4);
		test.getLeastNumber(array, 5);
	}

	public void getLeastNumber(int[] array, int k) {
		if (array == null || k < 0 || k > array.length)
			return;
		// 初始化堆数据
		int[] maxHeap = Arrays.copyOfRange(array, 0, k);
		// 将初始化的堆调整为最大堆
		for (int i = (maxHeap.length - 1) / 2; i >= 0; i--) {
			adjustHeap(maxHeap, i);
		}
		// 遍历初始数组不断调整最大堆
		for (int i = k; i < array.length; i++) {
			if (array[i] < maxHeap[0]) {
				maxHeap[0] = array[i];
				adjustHeap(maxHeap, 0);
			}
		}
		// 输出
		for (int i : maxHeap) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * 构造大顶堆
	 * @param maxHeap
	 * @param i
	 */
	private void adjustHeap(int[] maxHeap, int i) {
		int largest = i;
		int lchild = 2 * i + 1; // i的左孩子节点序号
		int rchild = 2 * i + 2; // i的右孩子节点序号
		if (largest <= (maxHeap.length - 1) / 2) {
			// 寻找子节点中最大的节点
			if (lchild < maxHeap.length && maxHeap[largest] < maxHeap[lchild]) {
				largest = lchild;
			}
			if (rchild < maxHeap.length && maxHeap[largest] < maxHeap[rchild]) {
				largest = rchild;
			}

			if (i != largest) {
				// 将当前节点与最大的子节点交换
				int tmp = maxHeap[largest];
				maxHeap[largest] = maxHeap[i];
				maxHeap[i] = tmp;
				// 交换后，子树可能不满足最大推，递归调整。
				adjustHeap(maxHeap, largest);
			}
		}
	}

}
