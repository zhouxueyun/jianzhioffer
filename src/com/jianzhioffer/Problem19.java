package com.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * 
 * @author zhouxueyun
 */
public class Problem19 {

	public static void main(String[] args) {
		Problem19 test = new Problem19();
		TreeNode root = new TreeNode();
		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode();
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = node5;
		node4.right = node6;
		root.value = 8;
		node1.value = 8;
		node2.value = 7;
		node3.value = 9;
		node4.value = 2;
		node5.value = 4;
		node6.value = 7;
		printTreeNode(root);
		root = test.mirror(root);
		// root = test.mirrorNotRecursion(root);
		printTreeNode(root);
	}

	private static void printTreeNode(TreeNode root) {
		if (root != null) {
			System.out.println(root.value);
			printTreeNode(root.left);
			printTreeNode(root.right);
		}
	}

	public TreeNode mirror(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		mirror(root.left);
		mirror(root.right);
		return root;
	}

	public TreeNode mirrorNotRecursion(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			TreeNode tmp = currNode.left;
			currNode.left = currNode.right;
			currNode.right = tmp;
			if (currNode.left != null)
				stack.push(currNode.left);
			if (currNode.right != null)
				stack.push(currNode.right);
		}
		return root;
	}

}
