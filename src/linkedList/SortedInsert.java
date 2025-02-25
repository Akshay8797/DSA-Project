package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

// Given a sorted linked list and a data item x, insert x such that the linked list remains sorted.
public class SortedInsert {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 15, 20, 30);
		SingleLinkedList.printList("Initial list:", head);
		head = sortedInsert(head, 25);
		SingleLinkedList.printList("After insert:", head);
	}

	// T(n): O(position)
	static Node sortedInsert(Node head, int x) {
		Node node = new Node(x);
		if (head == null || head.data > x) { // insert at head.
			node.next = head;
			return node;
		}
		Node curr = head;
		while (curr.next != null && curr.next.data < x) {
			curr = curr.next;
		}
		node.next = curr.next;
		curr.next = node;
		return head;
	}

}
