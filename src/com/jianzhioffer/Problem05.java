package com.jianzhioffer;

import java.util.Stack;

/**
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 * 
 * @author zhouxueyun
 */
public class Problem05 {

	public static void main(String[] args) {
		Problem05 test = new Problem05();
		ListNode node1 = new ListNode();
		ListNode node2 = new ListNode();
		ListNode node3 = new ListNode();
		node1.data = 1;
		node2.data = 2;
		node3.data = 3;
		node1.next = node2;
		node2.next = node3;
		System.out.println("printListReverse");
		test.printListReverse(node1);
		System.out.println("printListReverseRecursion");
		test.printListReverseRecursion(node1);
	}

	public void printListReverse(ListNode head) {
		if (head == null)
			return;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().data);
		}
	}

	public void printListReverseRecursion(ListNode head) {
		if (head == null)
			return;
		if (head.next != null) {
			printListReverseRecursion(head.next);
		}
		System.out.println(head.data);
	}

}

class ListNode {
	int data;
	ListNode next;
}
