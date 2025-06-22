package binarySearchTree.core;

import tree.core.TreeNode;
import tree.core.TreeTraversal;
import utils.tree.TreeUtils;

public class BstDeleteIterative {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createBST1();
		System.out.println("Before: " + root.left.left);
		root = deleteNode(root, 3);
		System.out.println("After: " + root.left.left);
		TreeTraversal.doInOrder(root);
	}

	private static TreeNode deleteNode(TreeNode root, int x) {
		TreeNode curr = root, parent = null;
		while (curr != null && curr.key != x) { // Find node to delete and its parent.
			parent = curr;
			if (curr.key > x)
				curr = curr.left;
			else
				curr = curr.right;
		}
		if (curr == null) // Tree empty or x is not present.
			return root;
		if (curr.left != null && curr.right != null) {
			// Find the successor and its parent
			TreeNode succParent = curr, succ = curr.right;
			while (succ.left != null) {
				succParent = succ;
				succ = succ.left;
			}
			curr.key = succ.key; // Copy successor to current.
			// Shifts the deletion target to successor which would have at most one child.
			curr = succ;
			parent = succParent;
		}

		// Handle nodes with 0 or 1 child
		TreeNode child = (root.left != null) ? root.left : root.right;
		if (parent == null)
			return child; // Deleting root node.
		if (parent.left == curr)
			parent.left = child;
		else
			parent.right = child;
		return root;
	}

}
