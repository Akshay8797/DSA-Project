package binarySearchTree.core;

import tree.core.TreeNode;
import tree.core.TreeTraversal;
import utils.tree.TreeUtils;

public class BstInsert {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createBST1();
		root = insertNodeRec(root, 8);
		TreeTraversal.doInOrder(root);
	}

	// T(n): O(h), S(n): O(h).
	private static TreeNode insertNodeRec(TreeNode root, int x) {
		if (root == null)
			return new TreeNode(x);
		if (root.key > x)
			root.left = insertNodeRec(root.left, x);
		else
			root.right = insertNodeRec(root.right, x);
		return root;

	}

	// T(n): O(h).
	static TreeNode insertNode(TreeNode root, int x) {
		TreeNode node = new TreeNode(x);
		TreeNode parent = null, curr = root;
		while (curr != null) {
			parent = curr;
			int val = curr.key;
			if (val > x)
				curr = curr.left;
			else if (val < x)
				curr = curr.right;
			else
				return root; // If x already present in the BST.
		}
		if (parent == null)
			return node; // Empty tree - null root.
		if (parent.key > x)
			parent.left = node;
		else
			parent.right = node;
		return root;
	}

}
