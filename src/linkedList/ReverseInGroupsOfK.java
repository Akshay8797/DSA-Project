package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

/*- Given a linked list, reverse the linked list in groups of k.
 * 	If no. of elements are less than k, reverse all elements left.
 * 	The last element of the linked list after the first pass will be the new head.
 */
public class ReverseInGroupsOfK {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 20, 30, 40, 50, 60, 70);
		SingleLinkedList.printList("Initial list:", head);
		head = groupReverse(head, 3);
		SingleLinkedList.printList("Post groupReverse:", head);
	}

	static Node groupReverse(Node head, int k) {
		Node curr = head, prevFirst = null;
		boolean isFirstPass = true;
		while (curr != null) {
			Node first = curr, prev = null;
			int cnt = 0;
			while (curr != null && cnt < k) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				cnt++;
			}
			if (isFirstPass) {
				head = prev;
				isFirstPass = false;
			} else
				prevFirst.next = prev;
			prevFirst = first;
		}
		return head;
	}

	static Node groupReverseRec(Node head, int k) {
		Node curr = head, next = null, prev = null;
		int cnt = 0;
		while (curr != null && cnt < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			cnt++;
		}
		if (next != null) {
			Node restHead = groupReverseRec(next, k);
			head.next = restHead;
		}
		return prev; // new head.
	}

}
