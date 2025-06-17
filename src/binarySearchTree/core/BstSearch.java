package binarySearchTree.core;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

public class BstSearch {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createBST1();
		System.out.println(isPresent(root, 18));
	}

	// T(n): O(h) - For self balancing BST h is log(n).
	private static boolean isPresent(TreeNode root, int x) {
		while (root != null) {
			int val = root.key;
			if (val == x)
				return true;
			if (val > x)
				root = root.left;
			else
				root = root.right;
		}
		return false;
	}

	static boolean isPresentRec(TreeNode root, int x) {
		if (root == null)
			return false;
		if (root.key > x)
			return isPresentRec(root.left, x);
		else if (root.key < x)
			return isPresentRec(root.right, x);
		else // root.key == x
			return true;
	}

}
