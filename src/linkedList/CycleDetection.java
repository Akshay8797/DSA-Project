package linkedList;

import java.util.HashSet;
import java.util.Set;

import linkedList.core.Node;

public class CycleDetection {

	public static void main(String[] args) {
		Node head = createLinkedListWithLoop();
		System.out.println("Loop exists: " + detectLoop(head));
	}

	// Floyd cycle detection
	static boolean detectLoop(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	static boolean isLoopExists(Node head) {
		Set<Node> nodes = new HashSet<>();
		for (Node curr = head; curr != null; curr = curr.next) {
			if (nodes.contains(curr))
				return true;
			nodes.add(curr);
		}
		return false;
	}

	static Node createLinkedListWithLoop() {
		Node head = new Node(10);
		Node second = new Node(15);
		Node third = new Node(12);
		Node fourth = new Node(20);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = second;
		return head;
	}

}
