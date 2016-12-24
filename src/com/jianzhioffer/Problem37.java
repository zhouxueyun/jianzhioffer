package com.jianzhioffer;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * @author zhouxueyun
 */
public class Problem37 {

	public static void main(String[] args) {
		Problem37 test = new Problem37();
		ListNode head1 = new ListNode();
		ListNode second1 = new ListNode();
		ListNode third1 = new ListNode();
		ListNode forth1 = new ListNode();
		ListNode fifth1 = new ListNode();
		ListNode head2 = new ListNode();
		ListNode second2 = new ListNode();
		ListNode third2 = new ListNode();
		ListNode forth2 = new ListNode();
		head1.next = second1;
		second1.next = third1;
		third1.next = forth1;
		forth1.next = fifth1;
		head2.next = second2;
		second2.next = forth1;
		third2.next = fifth1;
		head1.data = 1;
		second1.data = 2;
		third1.data = 3;
		forth1.data = 6;
		fifth1.data = 7;
		head2.data = 4;
		second2.data = 5;
		third2.data = 6;
		forth2.data = 7;
		System.out.println(test.findFirstCommonNode(head1, head2).data);
	}

	public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
		int len1 = getListLength(head1);
		int len2 = getListLength(head2);
		ListNode longListNode = null;
		ListNode shortListNode = null;
		int dif = 0;
		if (len1 > len2) {
			longListNode = head1;
			shortListNode = head2;
			dif = len1 - len2;
		} else {
			longListNode = head2;
			shortListNode = head1;
			dif = len2 - len1;
		}
		// 长链表先走几步
		for (int i = 0; i < dif; i++) {
			longListNode = longListNode.next;
		}
		// 同时遍历
		while (longListNode != null && shortListNode != null && longListNode != shortListNode) {
			longListNode = longListNode.next;
			shortListNode = shortListNode.next;
		}
		return longListNode;
	}

	private int getListLength(ListNode head) {
		int result = 0;
		if (head == null)
			return result;
		ListNode point = head;
		while (point != null) {
			point = point.next;
			result++;
		}
		return result;
	}

}
