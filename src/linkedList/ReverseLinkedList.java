package linkedList;

import java.util.ArrayList;
import java.util.List;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

// Given a linked list, reverse the linked list.
public class ReverseLinkedList {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 20, 30, 40);
		SingleLinkedList.printList("Initial list:", head);
		head = reverseEff(head);
		SingleLinkedList.printList("Post reverse:", head);
	}

	static Node reverseEff(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		return prev;
	}

	static void reverseLinkedList(Node head) {
		List<Integer> nums = new ArrayList<>();
		for (Node curr = head; curr != null; curr = curr.next)
			nums.add(curr.data);
		for (Node curr = head; curr != null; curr = curr.next)
			curr.data = nums.remove(nums.size() - 1);
	}

}
