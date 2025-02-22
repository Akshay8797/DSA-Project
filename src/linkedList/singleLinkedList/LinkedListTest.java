package linkedList.singleLinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);

		System.out.println("Initial list : " + LinkedList.printList(head));
		head = LinkedList.insertAtBegin(head, 5);
		System.out.println("After insertAtBegin : " + LinkedList.printList(head));
		head = LinkedList.insertAtEnd(head, 35);
		System.out.println("After insertAtEnd : " + LinkedList.printList(head));
		head = LinkedList.insertAtPos(head, 4, 25);
		System.out.println("After insertAtPos : " + LinkedList.printList(head));

		head = LinkedList.deleteFirst(head);
		System.out.println("After deleteFirst : " + LinkedList.printList(head));
		head = LinkedList.deleteLast(head);
		System.out.println("After deleteLast : " + LinkedList.printList(head));
		int idx = LinkedList.search(head, 30);
		System.out.println("Search idx : " + idx);
	}

}
