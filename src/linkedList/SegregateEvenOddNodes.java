package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

/*- Given a Linked list segregate the nodes, such that the even nodes appear first and then odd nodes.
 *  Note: The order between the groups should be same as the original order.
 * 	Ex: 17->15->8->12->5  =>  8->12->17->15->5	
 */
public class SegregateEvenOddNodes {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 5, 4, 3, 6);
		SingleLinkedList.printList("Initial list:", head);
		head = segregateEvenOdds(head);
		SingleLinkedList.printList("Post segregateEvenOdd:", head);
	}

	// T(n): O(n) - Maintain two sublists.
	static Node segregateEvenOdds(Node head) {
		Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;
		for (Node curr = head; curr != null; curr = curr.next) {
			if (curr.data % 2 == 0) {
				if (evenStart == null)
					evenStart = evenEnd = curr;
				else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			} else if (oddStart == null) // If Linked list is empty or has only evens or odds.
				oddStart = oddEnd = curr;
			else {
				oddEnd.next = curr;
				oddEnd = oddEnd.next;
			}
		}
		if (oddStart == null || evenStart == null)
			return head;
		evenEnd.next = oddStart;
		oddEnd.next = null;
		return evenStart;
	}

}
