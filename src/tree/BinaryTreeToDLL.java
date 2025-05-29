package tree;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

// Given a Binary tree convert it to Doubly linked list using InOrder traversal
public class BinaryTreeToDLL {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree3();
		TreeNode head = treeToDLL(root);
		System.out.println(printTreeDLL(head));
	}

	private static TreeNode prev = null;

	// T(n): O(n), S(n): O(h).
	private static TreeNode treeToDLL(TreeNode root) {
		if (root == null)
			return root;
		TreeNode head = treeToDLL(root.left); // returns null.
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		treeToDLL(root.right);
		return head;
	}

	private static String printTreeDLL(TreeNode head) {
		StringBuilder sb = new StringBuilder();
		if (head == null)
			return String.valueOf(sb.append("Null"));
		for (TreeNode n = head; n != null; n = n.right) {
			if (n != head)
				sb.append(" <-> ");
			sb.append(n);
		}
		return String.valueOf(sb);
	}

}
