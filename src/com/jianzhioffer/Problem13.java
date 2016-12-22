package com.jianzhioffer;

/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 
 * @author zhouxueyun
 */
public class Problem13 {

	public static void main(String[] args) {
		Problem13 test = new Problem13();
		ListNode head = new ListNode();
		ListNode second = new ListNode();
		ListNode third = new ListNode();
		head.data = 1;
		second.data = 2;
		third.data = 3;
		head.next = second;
		second.next = third;
		test.deleteNode(head, second);
		System.out.println(head.next.data);
	}

	public void deleteNode(ListNode head, ListNode deListNode) {
		if (head == null || deListNode == null)
			return;
		if (head == deListNode) { // 删除头节点
			head = null;
		} else {
			if (deListNode.next == null) { // 删除尾节点
				// 不能将deListNode置为空， 因为它在链表中还有引用
				ListNode pointListNode = head;
				while (pointListNode.next.next != null) {
					pointListNode = pointListNode.next;
				}
				pointListNode.next = null;
			} else { // 不是尾节点
				deListNode.data = deListNode.next.data;
				deListNode.next = deListNode.next.next;
			}

		}

	}

}
