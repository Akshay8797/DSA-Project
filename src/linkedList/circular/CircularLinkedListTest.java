package linkedList.circular;

import linkedList.core.Node;

public class CircularLinkedListTest {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(15);
		head.next.next = new Node(20);
		head.next.next.next = head;

		CircularLinkedList.printList("Initial list:", head);
		head = CircularLinkedList.insertAtBegin(head, 5);
		CircularLinkedList.printList("Post insertAtBegin:", head);
		head = CircularLinkedList.insertAtBeginEff(head, 2);
		CircularLinkedList.printList("Post insertAtBeginEff:", head);
		head = CircularLinkedList.insertAtEnd(head, 25);
		CircularLinkedList.printList("Post insertAtEnd:", head);
		head = CircularLinkedList.insertAtEndEff(head, 30);
		CircularLinkedList.printList("Post insertAtEndEff:", head);

		head = CircularLinkedList.deleteHead(head);
		CircularLinkedList.printList("Post deleteHead:", head);
		head = CircularLinkedList.deleteHeadEff(head);
		CircularLinkedList.printList("Post deleteHeadEff:", head);
		head = CircularLinkedList.deleteKth(head, 3);
		CircularLinkedList.printList("Post delete-3rd:", head);
	}

}
