package linkedList;

import linkedList.core.Node;
import linkedList.core.SingleLinkedList;
import utils.NodeUtils;

// Given reference to a single node of a Linked list, delete the node.
public class DeleteNodeWithRef {

	public static void main(String[] args) {
		Node head = NodeUtils.createSingleLinkedList(10, 20, 30, 40, 50);
		SingleLinkedList.printList("Initial list:", head);
		Node toDelete = head.next.next;
		deleteNodeWithRef(toDelete);
		SingleLinkedList.printList("Post delete:", head);
	}

	// Node to be deleted shouldn't be the tail node.
	static void deleteNodeWithRef(Node node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

}
