package linkedList;

import linkedList.core.Node;
import utils.NodeUtils;

// Given a linked list, print the nth node from the end.
public class NthNodeFromEnd {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 20, 30, 40, 50);
		getNthNodeFromEndEff(head, 5);
	}

	// One traversal - Two pointer approach.
	static void getNthNodeFromEndEff(Node head, int n) {
		if (head == null)
			return;
		Node first = head;
		for (int i = 0; i < n; i++) { // move first to n+1 pos.
			if (first == null) // return if n > len.
				return;
			first = first.next;
		}
		Node second = head;
		while (first != null) {
			second = second.next;
			first = first.next;
		}
		System.out.println(second);
	}

	// Two traversal.
	static void getNthNodeFromEnd(Node head, int n) {
		int len = 0;
		for (Node node = head; node != null; node = node.next)
			len++;
		if (n > len || n <= 0)
			return;
		Node curr = head;
		for (int i = 0; i < len - n; i++)
			curr = curr.next;
		System.out.println(curr);
	}

}
