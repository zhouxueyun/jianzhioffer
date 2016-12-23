package com.jianzhioffer;

import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * @author zhouxueyun
 */
public class Problem25 {

	public static void main(String[] args) {
		Problem25 test = new Problem25();
		TreeNode root = new TreeNode();
		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		root.value = 10;
		node1.value = 5;
		node2.value = 12;
		node3.value = 4;
		node4.value = 7;
		test.findPath(root, 22, new Stack<Integer>());
	}

	public void findPath(TreeNode root, int dst, Stack<Integer> stack) {
		if (root == null)
			return;
		stack.push(root.value);
		if (root.left == null && root.right == null) {// 走到了叶节点
			if (dst == root.value) { // 打印
				System.out.print("找到一条路径：");
				for (Integer path : stack) {
					System.out.print(path + " ");
				}
				System.out.println();
			}
		}
		int remain = dst - root.value;
		if (root.left != null)
			findPath(root.left, remain, stack);
		if (root.right != null)
			findPath(root.right, remain, stack);
		stack.pop();
	}

}
