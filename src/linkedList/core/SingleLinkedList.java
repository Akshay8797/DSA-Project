package linkedList.core;

public class SingleLinkedList {

	static int search(Node head, int x) {
		for (int i = 1; head != null; i++) {
			if (head.data == x)
				return i;
			head = head.next;
		}
		return -1;
	}

	static Node deleteLast(Node head) {
		if (head == null || head.next == null)
			return null;
		Node curr = head;
		while (curr.next.next != null)
			curr = curr.next;
		curr.next = null;
		return head;
	}

	static Node deleteFirst(Node head) {
		if (head == null)
			return null;
		return head.next;
	}

	static Node insertAtPos(Node head, int pos, int x) {
		if (pos == 1)
			return insertAtBegin(head, x);
		Node curr = head;
		for (int i = 1; i < pos - 1 && curr != null; i++) {
			curr = curr.next;
		}
		if (curr == null)
			return head;
		Node node = new Node(x);
		node.next = curr.next;
		curr.next = node;
		return head;
	}

	static Node insertAtEnd(Node head, int x) {
		Node node = new Node(x);
		if (head == null)
			return node;
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		curr.next = node;
		return head;
	}

	static Node insertAtBegin(Node head, int x) {
		Node node = new Node(x);
		node.next = head;
		return node;
	}

	static void printList(String msg, Node head) {
		System.out.print(msg + " ");
		if (head == null)
			return;
		for (Node n = head; n != null; n = n.next)
			System.out.print(n.data + " ");
		System.out.println();
	}

}
