package linkedList.circular;

import linkedList.core.Node;

public class CircularDoublyLinkedList {

	public static void main(String[] args) {
		Node head = new Node(8);
		Node second = new Node(12);
		Node third = new Node(16);
		head.next = second;
		head.prev = third;
		second.prev = head;
		second.next = third;
		third.prev = second;
		third.next = head;

		CircularLinkedList.printList("Initial list:", head);
		head = insertAtBegin(head, 4);
		CircularLinkedList.printList("Post insertAtBegin:", head);
		head = insertAtEnd(head, 18);
		CircularLinkedList.printList("Post insertAtEnd:", head);
	}

	private static Node insertAtBegin(Node head, int x) {
		Node node = new Node(x);
		if (head == null) {
			node.next = node;
			node.prev = node;
			return node;
		}
		node.prev = head.prev;
		node.next = head;
		head.prev.next = node;
		head.prev = node;
		return node;
	}

	private static Node insertAtEnd(Node head, int x) {
		// same as insertAtBegin without head update.
		Node node = new Node(x);
		if (head == null) {
			node.next = node;
			node.prev = node;
			return node;
		}
		node.prev = head.prev;
		node.next = head;
		head.prev.next = node;
		head.prev = node;
		return head;
	}

}
