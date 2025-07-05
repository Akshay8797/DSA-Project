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

	public static Node nullHeadInsert(Node node) {
		node.next = node;
		return node;
	}

	public static void swapNodeData(Node node1, Node node2) {
		int temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}

}
