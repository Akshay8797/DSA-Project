package tree.core;

import java.util.ArrayDeque;
import java.util.Queue;

import utils.TreeUtils;

// Level Order Traversal - Breadth First Search
public class LevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();
		printLevelOrderEff(root);
	}

	// T(n):O(n), S(n):O(n) [For perfect binary tree the last level has (n+1)/2 nodes].
	private static void printLevelOrderEff(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);
		while (!que.isEmpty()) {
			TreeNode curr = que.poll();
			System.out.print(curr + " ");
			if (curr.left != null)
				que.offer(curr.left);
			if (curr.right != null)
				que.offer(curr.right);
		}
	}

	// T(n): O(h*n), S(n): O(h).
	static void printLevelOrder(TreeNode root) {
		if (root == null)
			return;
		int h = TreeHeight.getTreeHeight(root);
		for (int i = 0; i < h; i++)
			PrintNodesAtDistanceK.printNodesAtK(root, i);
	}

}
