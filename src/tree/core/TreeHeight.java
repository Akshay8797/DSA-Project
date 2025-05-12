package tree.core;

import utils.TreeUtils;

// Height of a binary tree is the max no. of nodes from the root to the longest leaf.
public class TreeHeight {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();;
		System.out.println(getTreeHeight(root));
	}

	// T(n): O(n), S(n): O(h).
	public static int getTreeHeight(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = getTreeHeight(root.left);
		int rightHeight = getTreeHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
