package linkedList.core;

public class DoubleLinkedListTest {

	public static void main(String[] args) {
		Node head = new Node(15);
		Node second = new Node(25);
		Node third = new Node(50);
		head.next = second;
		second.prev = head;
		second.next = third;
		third.prev = second;

		SingleLinkedList.printList("Initial list:", head);
		head = DoubleLinkedList.insertAtBegin(head, 5);
		SingleLinkedList.printList("Post insertAtBegin:", head);
		head = DoubleLinkedList.insertAtEnd(head, 60);
		SingleLinkedList.printList("Post insertAtEnd:", head);
		head = DoubleLinkedList.reverse(head);
		SingleLinkedList.printList("Post reverse:", head);
		head = DoubleLinkedList.deleteHead(head);
		SingleLinkedList.printList("Post deleteHead:", head);
		head = DoubleLinkedList.deleteLast(head);
		SingleLinkedList.printList("Post deleteLast:", head);
	}

}
