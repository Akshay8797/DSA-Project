package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

/*- Given a Linked list swap its nodes pairwise.
 * 	Ex: 1->2->3->4 will be 2->1->4->3. In case of odd nodes, ignore the last node.
 */
public class PairwiseSwapNodes {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(1, 2, 3, 4, 5);
		SingleLinkedList.printList("Initial list:", head);
		head = swapPairwiseNodes(head);
		SingleLinkedList.printList("Post swapPairwise:", head);
	}

	static void swapPairwise(Node head) {
		for (Node curr = head; curr != null && curr.next != null; curr = curr.next.next)
			NodeUtils.swapNodeData(curr, curr.next);
	}

	// Without swapping data.
	static Node swapPairwiseNodes(Node head) {
		if (head == null || head.next == null)
			return head;
		// At each step we have a circular linked list pair.
		Node curr = head.next.next;
		Node prev = head;
		head = head.next;
		head.next = prev;
		while (curr != null && curr.next != null) {
			prev.next = curr.next;
			prev = curr;
			Node next = curr.next.next; // ref to the next pair.
			curr.next.next = curr; // ref back.
			curr = next;
		}
		prev.next = curr;
		return head;
	}

}
