package com.jianzhioffer;

/**
 * 链表中倒数第 k 个结点: 输入一个链表，输出该链表中倒数第 k 个结点。为了符合大多数人的习惯， 本题从 1
 * 开始计数，即链表的尾结点是倒数第一个结点。例如一个有 6 个结点的 链表，从头结点依次是 1,2,3,4,5,6。倒数第三个结点就是值为 4 的结点。
 * 
 * @author zhouxueyun
 *
 */
public class Problem15 {

	public static void main(String[] args) {
		Problem15 test = new Problem15();
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
		ListNode resultListNode = test.findKthToTail(head, 3);
		System.out.println(resultListNode.data);
	}

	public ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k == 0)
			return null;
		ListNode resultNode = head;
		ListNode headNode = head;
		for (int i = 0; i < k; i++) {
			if (headNode.next != null) {
				headNode = headNode.next;
			} else {
				return null;
			}
		}
		while (headNode != null) {
			headNode = headNode.next;
			resultNode = resultNode.next;
		}
		return resultNode;
	}
}
