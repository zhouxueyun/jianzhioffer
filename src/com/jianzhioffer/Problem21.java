package com.jianzhioffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min 函数。在该栈中，调用min、push及pop德尔时间复杂度都是O(1)
 * 
 * @author zhouxueyun
 */
public class Problem21 {

	public static void main(String[] args) {
		MyStack test = new MyStack();
		test.push(3);
		test.push(2);
		test.push(1);
		test.push(4);
		test.push(5);
		System.out.println(test.min());

	}

}

class MyStack {
	Stack<Integer> minStack = new Stack<Integer>();
	Stack<Integer> dataStack = new Stack<Integer>();

	public void push(int value) {
		if (minStack.isEmpty() || value <= minStack.peek())
			minStack.push(value);
		dataStack.push(value);
	}

	public Integer pop() {
		if (dataStack.isEmpty())
			return null;
		if (minStack.peek() == dataStack.peek())
			minStack.pop();
		return dataStack.pop();
	}

	public Integer min() {
		if (minStack.isEmpty())
			return null;
		return minStack.peek();
	}
}
