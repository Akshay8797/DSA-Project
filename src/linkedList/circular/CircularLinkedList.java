package linkedList.circular;

import linkedList.core.Node;
import utils.NodeUtils;

public class CircularLinkedList {

	// Delete kth node from the beginning.
	static Node deleteKth(Node head, int k) {
		if (head == null)
			return null;
		if (k == 1)
			return deleteHeadEff(head);
		Node node = head;
		int len = 1;
		do {
			if (len == k - 1) { // get prev node.
				node.next = node.next.next;
				break;
			}
			node = node.next;
			len++;
		} while (node != head);
		return head;
	}

	// T(n): O(1).
	static Node deleteHeadEff(Node head) {
		if (head == null || head.next == null)
			return null;
		Node nextHead = head.next;
		head.data = nextHead.data;
		head.next = nextHead.next;
		return head;
	}

	// T(n): O(n).
	static Node deleteHead(Node head) {
		if (head == null || head.next == null)
			return null;
		Node curr = head;
		while (curr.next != head)
			curr = curr.next;
		curr.next = head.next;
		return head.next;
	}

	// T(n): O(1).
	static Node insertAtEndEff(Node head, int x) {
		Node node = new Node(x);
		if (head == null)
			return NodeUtils.nullHeadInsert(head, node);
		node.next = head.next; // insert node after the head.
		head.next = node;
		NodeUtils.swapNodeData(head, node);
		return node;
	}

	// T(n): O(n).
	static Node insertAtEnd(Node head, int x) {
		Node node = new Node(x);
		if (head == null)
			return NodeUtils.nullHeadInsert(head, node);
		Node curr = head;
		while (curr.next != head)
			curr = curr.next;
		curr.next = node;
		node.next = head;
		return head;
	}

	// T(n): O(1).
	static Node insertAtBeginEff(Node head, int x) {
		Node node = new Node(x);
		if (head == null)
			return NodeUtils.nullHeadInsert(head, node);
		node.next = head.next; // insert node after the head.
		head.next = node;
		NodeUtils.swapNodeData(head, node);
		return head;
	}

	// T(n): O(n).
	static Node insertAtBegin(Node head, int x) {
		Node node = new Node(x);
		if (head == null)
			return NodeUtils.nullHeadInsert(head, node);
		Node curr = head;
		while (curr.next != head)
			curr = curr.next;
		curr.next = node;
		node.next = head;
		return node;

	}

	static void printList(String msg, Node head) {
		System.out.print(msg + " ");
		if (head == null)
			return;
		System.out.print(head.data + " ");
		for (Node n = head.next; n != head; n = n.next)
			System.out.print(n.data + " ");
		System.out.println();
	}

}
