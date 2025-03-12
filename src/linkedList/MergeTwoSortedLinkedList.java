package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

// Given two sorted Linked lists, merge them in-place.
public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		Node head1 = NodeUtils.createSingleLinkedList(10, 20, 30);
		Node head2 = NodeUtils.createSingleLinkedList(5, 25);
		SingleLinkedList.printList("List-1:", head1);
		SingleLinkedList.printList("List-2:", head2);
		Node head = mergeSortedLinkedLists(head1, head2);
		SingleLinkedList.printList("Post merge:", head);
	}

	// T(n): O(m + n), S(n): O(1).
	static Node mergeSortedLinkedLists(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Node head = head1, tail = head1;
		if (head1.data <= head2.data)
			head1 = head1.next;
		else {
			head = head2;
			tail = head2;
			head2 = head2.next;
		}

		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				tail.next = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		// Either head1 or head2 will have some nodes left after the loop.
		if (head1 == null)
			tail.next = head2;
		else
			tail.next = head1;
		return head;
	}

}
