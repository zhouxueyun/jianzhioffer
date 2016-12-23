package com.jianzhioffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。假设压入栈的所有数字均不相等。例如压栈序列为 1、2、
 * 3、4、5.序列 4、5、3、2、1 是压栈序列对应的一个弹出序列，但 4、3、5、1、 2 却不是。
 * 
 * @author zhouxueyun
 */
public class Problem22 {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 4, 3, 5, 1, 2 };
		int[] array3 = { 4, 5, 3, 2, 1 };
		Problem22 test = new Problem22();
		System.out.println(test.isPopOrder(array1, array2));
		System.out.println(test.isPopOrder(array1, array3));
	}

	public boolean isPopOrder(int[] line1, int[] line2) {
		if (line1 == null || line2 == null)
			return false;
		int point1 = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < line2.length; i++) {
			if (!stack.isEmpty() && stack.peek() == line2[i]) {
				// 如果栈不为空，且当前栈顶与下一个弹出item相等，栈弹出，i++
				stack.pop();
			} else {
				if (point1 == line1.length) {
					// 如果序列1已经全部入栈，还未能完成序列2的出栈，返回false
					return false;
				} else {
					while (true) {
						// push 序列1的item
						stack.push(line1[point1++]);
						// 如果栈不为空，且当前栈顶与下一个弹出item相等，栈弹出，i++
						if (stack.peek() == line2[i] || point1 == line1.length)
							break;
					}
					if (!stack.isEmpty() && stack.peek() == line2[i])
						// 如果栈不为空，且当前栈顶与弹出序列的item相等，i++,栈弹出
						stack.pop();
					else
						return false;
				}
			}
		}
		return true;
	}

}
