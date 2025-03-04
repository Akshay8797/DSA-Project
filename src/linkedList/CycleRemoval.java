package linkedList;

import java.util.HashSet;
import java.util.Set;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;

public class CycleRemoval {

	public static void main(String[] args) {
		Node head = CycleDetection.createLinkedListWithLoop();
		detectAndRemoveLoopFA(head);
		SingleLinkedList.printList("Post detectAndRemoveLoop:", head);
	}

	/*- Detect loop using Floyd's algorithm using slow and fast ref. If slow and fast meet,
	 * 	Move slow to the start of the linked list and move both slow and fast now at the same speed.
	 * 	The point where they now meet is the first node of the loop.
	 */
	static void detectAndRemoveLoopFA(Node head) {
		if (head == null || head.next == null)
			return;
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (slow != fast)
			return;
		slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;
	}

	static void detectAndRemoveLoop(Node head) {
		Set<Node> seenNodes = new HashSet<>();
		Node prev = null;
		Node curr = head;
		while (curr != null) {
			if (seenNodes.contains(curr)) {
				prev.next = null;
				return;
			}
			seenNodes.add(curr);
			prev = curr;
			curr = curr.next;
		}
	}

}
