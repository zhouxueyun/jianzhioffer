package com.jianzhioffer;

/**
 * 实现函数复制一个复杂链表。在复杂链表中，每个结点除了有一个 next 指针指向下一个结点外，还有一个指向链表中任意结点或 null。
 * 
 * @author zhouxueyun
 */
public class Problem26 {

	public static void main(String[] args) {
		Problem26 test = new Problem26();
		ComplexListNode root = new ComplexListNode();
		ComplexListNode node1 = new ComplexListNode();
		ComplexListNode node2 = new ComplexListNode();
		ComplexListNode node3 = new ComplexListNode();
		ComplexListNode node4 = new ComplexListNode();
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		root.data = 1;
		node1.data = 2;
		node2.data = 3;
		node3.data = 4;
		node4.data = 5;
		root.sibling = node2;
		node1.sibling = node4;
		node3.sibling = node1;
		ComplexListNode result = test.clone(root);
		System.out.println(result.data);
		System.out.println(result.next.data);
		System.out.println(result.sibling.data);
	}

	public ComplexListNode clone(ComplexListNode head) {
		cloneNodes(head);
		cloneSiblingNodes(head);
		return reconnectNodes(head);
	}

	/**
	 * 复制节点
	 * @param head
	 */
	private void cloneNodes(ComplexListNode head) {
		ComplexListNode node = head; // 复制一份
		while (node != null) {
			// 复制
			ComplexListNode cloned = new ComplexListNode();
			cloned.data = node.data;
			cloned.next = node.next;
			cloned.sibling = null;
			// 连接
			node.next = cloned;
			// 执行下一次
			node = cloned.next;
		}
	}

	/**
	 * 复制sibling
	 * @param head
	 */
	private void cloneSiblingNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while (node!=null) {
			ComplexListNode cloned = node.next;
			if (node.sibling!=null) // 默认向后移一位
				cloned.sibling = node.sibling.next;
			node = cloned.next;
		}
	}
	
	/**
	 * 拆分
	 * @param head
	 * @return
	 */
	private ComplexListNode reconnectNodes(ComplexListNode head) {
		ComplexListNode node = head;
		ComplexListNode clonedHead = null;
		ComplexListNode clonedNode = null;
		if (node!=null) { // set head
			clonedHead = node.next;
			clonedNode = node.next;
			node.next = clonedNode.next; // == node.next.next
			node = node.next;
		}
		while (node!=null) {
			clonedNode.next = node.next;
			clonedNode = clonedNode.next; // next loop
			node.next = clonedNode.next; // == node.next.next
			node = node.next; // next loop
		}
		return clonedHead;
	}

}
