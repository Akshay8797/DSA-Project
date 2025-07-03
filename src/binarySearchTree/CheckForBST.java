package binarySearchTree;

import tree.core.TreeNode;
import utils.tree.BstInfo;
import utils.tree.TreeUtils;

// Given a binary tree, check if it is BS. Only distinct values are considered in BST.
public class CheckForBST {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree9();
		System.out.println(isBst1(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	/*- Pass a range for every node, -∞ to +∞ for root.
	 *- For left child upper bound is changed to node's value.
	 *- For right child lower bound is changed to node's value.
	 *- T(n): O(n), S(n): O(h).
	 */
	private static boolean isBst1(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		return (root.key > min && root.key < max && isBst1(root.left, min, root.key)
				&& isBst1(root.right, root.key, max));
	}

	// T(n): O(n), S(n): O(h).
	static BstInfo isBst2(TreeNode node) {
		if (node == null)
			// Empty subtree is BST with min = +∞ and max = -∞
			return new BstInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
		BstInfo left = isBst2(node.left);
		BstInfo right = isBst2(node.right);
		boolean nodeIsBst = left.isBst && right.isBst && node.key > left.max && node.key < right.min;
		int subTreeMin = Math.min(node.key, left.min);
		int subTreeMax = Math.min(node.key, right.max);
		return new BstInfo(nodeIsBst, subTreeMin, subTreeMax);
	}

	static int prev = Integer.MIN_VALUE;

	/*- A binary tree is a BST, if its InOrder traversal is in increasing order.
	 * 	T(n): O(n), S(n): O(h).
	 */
	static boolean isBst3(TreeNode root) {
		if (root == null)
			return true;
		if (!isBst3(root.left))
			return false;
		if (root.key <= prev)
			return false;
		prev = root.key;
		return isBst3(root.right);
	}

}
