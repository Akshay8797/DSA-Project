package linkedList;

import linkedList.core.Node;

public class CycleLength {

	public static void main(String[] args) {
		Node head = CycleDetection.createLinkedListWithLoop();
		System.out.println(getCycleLength(head));
	}

	/*- Detect loop using Floyd's algorithm using slow and fast ref. If slow and fast meet,
	 * 	Move slow one by one until it reaches fast.
	 */
	static int getCycleLength(Node head) {
		if (head == null || head.next == null)
			return -1;
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
		}
		int cycleLen = 0;
		if (fast != slow)
			return -1;
		do {
			cycleLen++;
			slow = slow.next;
		} while (slow != fast);
		return cycleLen;
	}

}
