package com.jianzhioffer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设前 序遍历和中序遍历结果中都不包含重复的数字，例如输入的前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建出如图所示的二叉树。
 * 
 * @author zhouxueyun
 */
public class Problem06 {

	public static void main(String[] args) throws Exception {
		Problem06 test = new Problem06();
		int[] preOrder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = test.constructCore(preOrder, inOrder);
	}

	public TreeNode constructCore(int[] preorder, int[] inorder) throws Exception {
		if (preorder == null || inorder == null)
			return null;
		if (preorder.length != inorder.length)
			throw new Exception("长度不一样，非法的输入");
		TreeNode root = new TreeNode();
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				root.value = inorder[i];
				System.out.println(root.value);
				root.left = constructCore(Arrays.copyOfRange(preorder, 1, i + 1), // 前包含，后不包含
						Arrays.copyOfRange(inorder, 0, i));
				root.right = constructCore(Arrays.copyOfRange(preorder, i + 1, preorder.length),
						Arrays.copyOfRange(inorder, i + 1, inorder.length));
			}
		}
		return root;
	}

}
