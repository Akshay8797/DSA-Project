package utils;

import linkedList.core.Node;

public class NodeUtils {
	
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
