package com.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 * 
 * @author zhouxueyun
 */
public class Problem23 {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode();
		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode();
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = node5;
		node4.right = node6;
		root1.value = 8;
		node1.value = 8;
		node2.value = 7;
		node3.value = 9;
		node4.value = 2;
		node5.value = 4;
		node6.value = 7;
		Problem23 test = new Problem23();
		test.printFromTopToBottom(root1);
	}

	public void printFromTopToBottom(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) { // 与非递归实现左右子数交换类似
			TreeNode node = queue.poll();
			System.out.print(node.value + " ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

}
