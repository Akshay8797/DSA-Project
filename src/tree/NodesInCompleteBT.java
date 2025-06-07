package tree;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

// Given a complete binary tree, count the no. of nodes in it.
// A complete BT has all levels filled except possibly the last, which is filled from left to right.
public class NodesInCompleteBT {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree8();
		System.out.println(countNodes(root));
	}

	// T(n): O(log ^ 2n), S(n): O(log n)
	private static int countNodes(TreeNode root) {
		int lHeight = 0, rHeight = 0;
		TreeNode curr = root;
		while (curr != null) {
			lHeight++;
			curr = curr.left;
		}
		curr = root;
		while (curr != null) {
			rHeight++;
			curr = curr.right;
		}
		if (lHeight == rHeight)
			return (int) Math.pow(2, lHeight) - 1;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	// T(n): O(n), S(n): O(h) - Doesn't use the fact that tree is complete.
	static int countNodesNaive(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + countNodesNaive(root.left) + countNodesNaive(root.right);
	}

}
