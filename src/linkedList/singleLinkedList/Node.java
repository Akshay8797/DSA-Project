package linkedList.singleLinkedList;

// Self referential structure
public class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}

}
