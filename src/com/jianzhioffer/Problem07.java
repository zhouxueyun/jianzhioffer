package com.jianzhioffer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列，实现对了的两个函数 appendTail 和 deleteHead，分别完成在队列尾插入结点和在队列头部删除结点的功能。
 * 
 * @author zhouxueyun
 */
public class Problem07 {

	public static void main(String[] args) throws Exception {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.appendTail(5);
		System.out.println(queue.deleteHead());
		queue.appendTail(4);
		queue.appendTail(3);
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
	}

}

class MyQueue<T> {
	// 存储入队数据
	private Stack<T> stack1 = new Stack<T>();
	// 存储出队数据
	private Stack<T> stack2 = new Stack<T>();

	public void appendTail(T t) {
		stack1.push(t);
	}

	public T deleteHead() throws Exception {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			throw new Exception("队列为空，不能删除");
		}
		return stack2.pop();
	}
}
