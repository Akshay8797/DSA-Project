package linkedList.core;

// Self referential structure
public class Node {

	public int data;
	public Node next;
	public Node prev;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}

}
