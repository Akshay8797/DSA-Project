package binarySearchTree.core;

import tree.core.TreeNode;
import tree.core.TreeTraversal;
import utils.tree.TreeUtils;

public class BstDeleteRecursive {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createBST1();
		root = deleteNodeRec(root, 15);
		TreeTraversal.doInOrder(root);
	}

	private static TreeNode deleteNodeRec(TreeNode root, int x) {
		if (root == null)
			return null;
		if (root.key > x)
			root.left = deleteNodeRec(root.left, x);
		else if (root.key < x)
			root.right = deleteNodeRec(root.right, x);
		else { // root.key is x.
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else { // Both left and right child are present.
				TreeNode succ = getSuccessor(root);
				root.key = succ.key;
				root.right = deleteNodeRec(root.right, succ.key);
			}
		}
		return root;
	}

	// Finds the InOrder successor - Next greater element.
	private static TreeNode getSuccessor(TreeNode root) {
		TreeNode curr = root.right;
		while (curr != null && curr.left != null)
			curr = curr.left;
		return curr;
	}

}
