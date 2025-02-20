package linkedList;

// self referential structure
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class SingleLinkedList {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);

		printList(head, false);
		head = insertAtBegin(head, 15);
		printList(head, true);
		head = insertAtEnd(head, 35);
		printList(head, true);

	}

	private static Node insertAtEnd(Node head, int x) {
		Node node = new Node(x);
		if (head == null)
			return node;
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		curr.next = node;
		return head;
	}

	private static Node insertAtBegin(Node head, int x) {
		Node node = new Node(x);
		node.next = head;
		return node;
	}

	private static void printList(Node head, boolean toPrintNewLine) {
		if (toPrintNewLine)
			System.out.println();
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

}
