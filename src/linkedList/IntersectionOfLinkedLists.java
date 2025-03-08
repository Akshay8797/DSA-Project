package linkedList;

import java.util.HashSet;
import java.util.Set;

import linkedList.core.Node;
import utils.NodeUtils;

// Given two Linked lists, find the intersection point of the two lists.
public class IntersectionOfLinkedLists {

	public static void main(String[] args) {
		// Creating the common part.
		Node cmnHead = NodeUtils.createSingleLinkedList(10, 12, 15);
		Node head1 = new Node(5);
		head1.next = new Node(8);
		head1.next.next = new Node(7);
		head1.next.next.next = cmnHead;
		Node head2 = new Node(9);
		head2.next = cmnHead;
		System.out.println(getIntersectionNode(null, null));
	}

	// T(n): O(m+n).
	static int getIntersectionNode(Node head1, Node head2) {
		if (head1 == null || head2 == null)
			return -1;
		Node ptr1 = head1;
		Node ptr2 = head2;

		// Traverse both lists ensuring both ptr traverse equal lengths by the time they meet.
		while (ptr1 != ptr2) {
			// Move to next node or switch to the other list's head.
			ptr1 = (ptr1 != null) ? ptr1.next : head2;
			ptr2 = (ptr2 != null) ? ptr2.next : head1;
		}
		return ptr1 != null ? ptr1.data : -1;
	}

	// T(n): O(m+n), S(n): O(n).
	static int getIntersection(Node head1, Node head2) {
		Set<Node> nodes = new HashSet<>();
		for (Node curr = head1; curr != null; curr = curr.next)
			nodes.add(curr);
		for (Node curr = head2; curr != null; curr = curr.next) {
			if (nodes.contains(curr))
				return curr.data;
		}
		return -1;
	}

}
