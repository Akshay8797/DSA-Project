package linkedList.core;

public class DoubleLinkedList {

	static Node deleteLast(Node head) {
		if (head == null || head.next == null)
			return null;
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		curr.prev.next = null;
		return head;
	}

	static Node deleteHead(Node head) {
		if (head == null || head.next == null)
			return null;
		head = head.next;
		head.prev = null;
		return head;
	}

	static Node reverse(Node head) {
		Node curr = head, temp = null;
		if (head == null || head.next == null)
			return head;
		while (curr != null) {
			temp = curr.prev; // swap next and prev.
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev; // as next and prev swapped.
		}
		return temp.prev;
	}

	static Node insertAtEnd(Node head, int data) {
		Node node = new Node(data);
		if (head == null)
			return node;
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		curr.next = node;
		node.prev = curr;
		return head;
	}

	static Node insertAtBegin(Node head, int data) {
		Node node = new Node(data);
		node.next = head;
		if (head != null)
			head.prev = node;
		return node;
	}

}
