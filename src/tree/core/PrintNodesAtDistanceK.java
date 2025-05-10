package tree.core;

import utils.TreeUtils;

public class PrintNodesAtDistanceK {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();;
		printNodesAtK(root, 2);
	}

	// T(n): O(n), S(n): O(k).
	static void printNodesAtK(TreeNode root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.print(root + " ");
			return;
		}
		printNodesAtK(root.left, k - 1);
		printNodesAtK(root.right, k - 1);
	}

}
