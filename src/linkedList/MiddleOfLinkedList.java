package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

// Given a linked list, find the middle element (2nd middle in case of even nodes).
public class MiddleOfLinkedList {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 5, 20, 15, 25);
		SingleLinkedList.printList("List:", head);
		getMiddleElementEff(head);
	}

	// One traversal.
	static void getMiddleElementEff(Node head) {
		if (head == null)
			return;
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow);
	}

	// Two traversals.
	static void getMiddleElement(Node head) {
		if (head == null)
			return;
		int len = 0;
		for (Node node = head; node != null; node = node.next)
			len++;
		Node curr = head;
		for (int i = 0; i < len / 2; i++)
			curr = curr.next;
		System.out.println(curr.data);
	}

}
