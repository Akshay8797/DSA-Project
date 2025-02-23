package linkedList.core;

public class SingleLinkedListTest {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);

		SingleLinkedList.printList("Initial list:", head);
		head = SingleLinkedList.insertAtBegin(head, 5);
		SingleLinkedList.printList("Post insertAtBegin:", head);
		head = SingleLinkedList.insertAtEnd(head, 35);
		SingleLinkedList.printList("Post insertAtEnd:", head);
		head = SingleLinkedList.insertAtPos(head, 4, 25);
		SingleLinkedList.printList("Post insertAtPos:", head);

		head = SingleLinkedList.deleteFirst(head);
		SingleLinkedList.printList("Post deleteFirst:", head);
		head = SingleLinkedList.deleteLast(head);
		SingleLinkedList.printList("Post deleteLast:", head);
		int idx = SingleLinkedList.search(head, 30);
		System.out.println("Search index: " + idx);
	}

}
