package com.jianzhioffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author zhouxueyun
 */
public class Problem27 {

	public static void main(String[] args) {
		Problem27 test = new Problem27();
		TreeNode root = new TreeNode();
		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode();
		root.value = 10;
		node1.value = 6;
		node2.value = 14;
		node3.value = 4;
		node4.value = 8;
		node5.value = 12;
		node6.value = 16;
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		TreeNode rst = test.convert(root);
		while (rst != null) {
			System.out.print(rst.value + " ");
			rst = rst.right;
		}
	}

	public TreeNode convert(TreeNode root) {
		TreeNode lastNodeList = null;
		lastNodeList = convertNode(root, lastNodeList);
		while (lastNodeList != null && lastNodeList.left != null) {
			lastNodeList = lastNodeList.left;
		}
		return lastNodeList; // 返回到头节点
	}

	/**
	 * 主要是通过中序遍历，递归思想，处理所有节点
	 * 
	 * @param root
	 * @param lastNodeList
	 * @return 返回上一次处理的节点
	 */
	private TreeNode convertNode(TreeNode root, TreeNode lastNodeList) {
		if (root == null)
			return null;
		TreeNode current = root; // 根节点
		if (current.left != null) // 转换左子树
			lastNodeList = convertNode(current.left, lastNodeList);

		current.left = lastNodeList; // 将当前节点的左子树设为上一个处理节点
		if (lastNodeList != null)
			lastNodeList.right = current; // 上一个处理节点的右节点设为当前节点

		lastNodeList = current; // 将上次处理节点设为当前节点，便于下次传入参数处理下一个节点
		if (current.right != null) // 转换右子树
			lastNodeList = convertNode(current.right, lastNodeList);

		return lastNodeList;
	}

}
