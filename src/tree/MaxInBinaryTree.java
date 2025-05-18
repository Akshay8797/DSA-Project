package tree;

import java.util.ArrayDeque;
import java.util.Queue;

import tree.core.TreeNode;
import utils.TreeUtils;

// Find the maximum value node in a Binary tree.
public class MaxInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree2();
		System.out.println(getTreeMax(root));
	}

	// T(n): O(n), S(n): O(h).
	private static int getTreeMax(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		else
			return Math.max(root.key, Math.max(getTreeMax(root.left), getTreeMax(root.right)));
	}

	// T(n): O(n), S(n): O(n) [Width of the tree].
	static int getTreeMaxItr(TreeNode root) {
		int res = Integer.MIN_VALUE;
		if (root == null)
			return res;
		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);
		while (!que.isEmpty()) {
			TreeNode curr = que.poll();
			if (curr.key > res)
				res = curr.key;
			if (curr.left != null)
				que.offer(curr.left);
			if (curr.right != null)
				que.offer(curr.right);
		}
		return res;
	}

}
