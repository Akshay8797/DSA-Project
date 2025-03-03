package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

// Given a sorted linked list, remove the duplicates from it.
public class RemoveDuplicatesFromSorted {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 20, 20, 30, 30, 30);
		SingleLinkedList.printList("Initial list:", head);
		removeDupsFromSortedList(head);
		SingleLinkedList.printList("Post removing dups:", head);
	}

	static void removeDupsFromSortedList(Node head) {
		Node curr = head;
		while (curr != null && curr.next != null) {
			if (curr.data == curr.next.data)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
	}

}
