package com.jianzhioffer;

/**
 * 输入一棵二叉树的根结点，求该树的深度。<br>
 * 从根结点到叶结点依次经过 的结点(含根、叶结点)形成树的一条路径，最长路径的长度为树的深度。
 * 
 * @author zhouxueyun
 *
 */
public class Problem39 {

	public static void main(String[] args) {
		Problem39 test = new Problem39();
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
		node2.right = node5;
		node4.left = node6;
		root.value = 1;
		node1.value = 2;
		node2.value = 3;
		node3.value = 4;
		node4.value = 5;
		node5.value = 6;
		node6.value = 7;
		System.out.println(test.treeDepth(root));
		System.out.println(test.isBalanced(root));
	}

	public int treeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		return left > right ? left + 1 : right + 1;
	}

	public boolean isBalanced(TreeNode root) {
		int[] depth = new int[] { 0 };
		return isBalanced(root, depth);
	}

	/**
	 * @param root
	 * @param depth
	 *            这里由于java的传值与传引用问题，用传int[1]代替int
	 * @return
	 */
	private boolean isBalanced(TreeNode root, int[] depth) {
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		int[] left = new int[] { 0 };
		int[] right = new int[] { 0 };
		if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
			int diff = left[0] - right[0];
			if (diff <= 1 && diff >= -1) {
				depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
				return true;
			}
		}
		return false;
	}

}
