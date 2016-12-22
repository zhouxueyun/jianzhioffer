package com.jianzhioffer;

import java.util.Stack;

/**
 * 反转链表： 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的 头结点。
 * 
 * @author zhouxueyun
 */
public class Problem16 {

	public static void main(String[] args) {
		Problem16 test = new Problem16();
		ListNode head = new ListNode();
		ListNode second = new ListNode();
		ListNode third = new ListNode();
		ListNode forth = new ListNode();
		head.next = second;
		second.next = third;
		third.next = forth;
		head.data = 1;
		second.data = 2;
		third.data = 3;
		forth.data = 4;
		ListNode result = test.reverseList(head);
		while (result != null) {
			System.out.println(result.data);
			result = result.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode reversedNode = null;
		ListNode currNode = head;
		ListNode preNode = null;
		while (currNode != null) {
			ListNode nextNode = currNode.next;
			if (currNode.next == null) // 说明已到链表尾节点，为防止断链，需走完此次循环
				reversedNode = currNode;
			currNode.next = preNode; // next 指向 上一个节点
			preNode = currNode; // 前一个节点 变为 当前节点
			currNode = nextNode; // 当前节点 变为 记录好的下一个节点
		}
		return reversedNode;
	}

}
