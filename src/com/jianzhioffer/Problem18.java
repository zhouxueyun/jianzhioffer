package com.jianzhioffer;

/**
 * 树的子结构: 输入两颗二叉树 A 和 B，判断 B 是不是 A 的子结构。
 * 
 * @author zhouxueyun
 */
public class Problem18 {

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
		TreeNode root2 = new TreeNode();
		TreeNode a = new TreeNode();
		TreeNode b = new TreeNode();
		root2.left = a;
		root2.right = b;
		root2.value = 8;
		a.value = 9;
		b.value = 2;
		Problem18 test = new Problem18();
		System.out.println(test.hasSubTree(root1, root2));
	}

	public boolean hasSubTree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.value == root2.value) // 如果两个根节点的值相同，则判断子节点是否相同
				result = doesTree1HaveTree2(root1, root2);
			if (!result) // 判断根节点的左孩子是否包含root2
				result = hasSubTree(root1.left, root2);
			if (!result) // 判断根节点的右孩子是否包含root2
				result = hasSubTree(root1.right, root2);
		}
		return result;
	}

	private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null)
			return true;
		if (root1 == null)
			return false;
		if (root1.value != root2.value)
			return false;
		return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
	}
}
