package tree;

import java.util.ArrayDeque;
import java.util.Queue;

import tree.core.TreeNode;
import utils.TreeUtils;

// Given a binary tree, Print its left view - Leftmost node at each level. 
public class LeftView {

	private static int maxLevel = 0;

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree3();
		printLeft(root, 1);
	}

	// T(n): O(n), S(n): O(h) - PreOrder traversal.
	private static void printLeft(TreeNode root, int level) {
		if (root == null)
			return;
		if (maxLevel < level) {
			System.out.print(root.key + " ");
			maxLevel = level;
		}
		printLeft(root.left, level + 1);
		printLeft(root.right, level + 1);
	}

	// T(n): O(n), S(n): O(n) [Width of the tree].
	static void printLeftViewItr(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);
		while (!que.isEmpty()) {
			int lvlWidth = que.size();
			for (int i = 0; i < lvlWidth; i++) {
				TreeNode curr = que.poll();
				if (i == 0)
					System.out.print(curr + " ");
				if (curr.left != null)
					que.offer(curr.left);
				if (curr.right != null)
					que.offer(curr.right);
			}
		}
	}

}
