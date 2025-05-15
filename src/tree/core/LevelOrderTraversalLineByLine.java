package tree.core;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeUtils;

// Print each level of the binary tree in separate line.
public class LevelOrderTraversalLineByLine {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();
		printLevelOrderLine(root);
	}

	// T(n): O(n), S(n): O(n) [Width of the tree].
	static void printLevelOrderLine(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		que.offer(null); // To mark end of the current level.
		while (que.size() > 1) {
			TreeNode curr = que.poll();
			if (curr == null) {
				System.out.println();
				que.offer(null); // To mark the end of the next level.
				continue;
			}
			System.out.print(curr + " ");
			if (curr.left != null)
				que.offer(curr.left);
			if (curr.right != null)
				que.offer(curr.right);
		}
	}

	// T(n): O(n), S(n): O(n) [Width of the tree].
	static void printLevelOrderLine2(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);
		while (!que.isEmpty()) {
			int lvlWidth = que.size();
			for (int i = 0; i < lvlWidth; i++) {
				TreeNode curr = que.poll();
				System.out.print(curr + " ");
				if (curr.left != null)
					que.offer(curr.left);
				if (curr.right != null)
					que.offer(curr.right);
			}
			System.out.println();
		}
	}

}
