package binarySearchTree;

import java.util.HashSet;

import tree.core.TreeNode;
import utils.TreeUtils;

// Given a BST and a sum. Find whether a pair exists in the BST with sum.
public class PairWithGivenSumInBST {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createBST3();
		HashSet<Integer> nodes = new HashSet<>();
		System.out.println(isPairSumExists(root, 33, nodes)); // True: 25 + 8
	}

	// T(n): O(n), S(n): O(n).
	private static boolean isPairSumExists(TreeNode root, int sum, HashSet<Integer> nodes) {
		if (root == null)
			return (sum == 0);
		if (isPairSumExists(root.left, sum, nodes))
			return true;
		if (nodes.contains(sum - root.key))
			return true;
		else
			nodes.add(root.key);
		return isPairSumExists(root.right, sum, nodes);
	}

}
