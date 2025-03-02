package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

public class RecursiveReverse {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 20, 30, 40);
		SingleLinkedList.printList("Initial list:", head);
		head = recReverse2(head, null);
		SingleLinkedList.printList("Post reverse:", head);
	}

	static Node recReverse1(Node head) {
		if (head == null || head.next == null)
			return head;
		Node restHead = recReverse1(head.next);
		Node restTail = head.next;
		restTail.next = head;
		head.next = null;
		return restHead;
	}

	static Node recReverse2(Node curr, Node prev) {
		if (curr == null)
			return prev;
		Node next = curr.next;
		curr.next = prev;
		return recReverse2(next, curr);
	}

}
