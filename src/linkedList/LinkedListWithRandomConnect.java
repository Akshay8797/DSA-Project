package linkedList;

import java.util.HashMap;
import java.util.Map;

import linkedList.core.Node;

/*- Given a linked list with usual next refs and an additional random refs,
 * 	Clone the linked list. 
 */
public class LinkedListWithRandomConnect {

	public static void main(String[] args) {
		Node head = getLinkedListWithRandomConnections();
		printRandomLinkedList(head);
		Node head2 = cloneRandomList2(null);
		printRandomLinkedList(head2);
	}

	// T(n): O(n), S(n): O(n).
	static Node cloneRandomList1(Node head) {
		Map<Node, Node> nodeMap = new HashMap<>();
		for (Node curr = head; curr != null; curr = (Node) curr.next)
			nodeMap.put(curr, new Node(curr.data));
		for (Node curr = head; curr != null; curr = (Node) curr.next) {
			Node cloneCurr = nodeMap.get(curr);
			cloneCurr.next = nodeMap.get(curr.next);
			cloneCurr.random = nodeMap.get(curr.random);
		}
		return nodeMap.get(head);
	}

	// T(n): O(n), S(n): O(1).
	static Node cloneRandomList2(Node head1) {
		Node curr = head1;
		// insert clone nodes and set next ref.
		while (curr != null) {
			Node nxt = curr.next;
			curr.next = new Node(curr.data);
			curr.next.next = nxt;
			curr = nxt;
		}
		// set random ref. since even nodes always (curr.next != null) check isn't needed.
		for (curr = head1; curr != null; curr = curr.next.next)
			curr.next.random = (curr.random == null) ? null : curr.random.next;
		Node head2 = (head1 == null) ? null : head1.next;
		// segregate original and clone nodes.
		Node cloneCurr = head2;
		for (curr = head1; curr != null; curr = curr.next) {
			curr.next = curr.next.next;
			cloneCurr.next = (cloneCurr.next != null) ? cloneCurr.next.next : null;
			cloneCurr = cloneCurr.next;
		}
		return head2;
	}

	static Node getLinkedListWithRandomConnections() {
		Node node1 = new Node(10);
		Node node2 = new Node(5);
		Node node3 = new Node(20);
		Node node4 = new Node(15);
		Node node5 = new Node(20);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node1.random = node3;
		node2.random = node4;
		node3.random = node1;
		node4.random = node3;
		node5.random = node4;
		return node1;
	}

	static void printRandomLinkedList(Node head) {
		if (head == null) {
			System.out.println("null");
			return;
		}
		for (Node curr = head; curr != null; curr = (Node) curr.next) {
			System.out.println("data: " + curr + ", next: " + curr.next + ", random: " + curr.random);
		}
		System.out.println();
	}

}
