package utils;

import linkedList.core.Node;

public class NodeUtils {

	public static Node createSingleLinkedList(int... values) {
		if (values.length == 0)
			return null;
		Node head = new Node(values[0]);
		Node curr = head;
		for (int i = 1; i < values.length; i++) {
			curr.next = new Node(values[i]);
			curr = curr.next;
		}
		return head;
	}

	public static Node nullHeadInsert(Node head, Node node) {
		node.next = node;
		return node;
	}

	public static void swapNodeData(Node head, Node node) {
		int temp = head.data;
		head.data = node.data;
		node.data = temp;
	}

}
