package tree;

import java.util.ArrayDeque;
import java.util.Queue;

import tree.core.TreeNode;
import utils.TreeUtils;

// Given a Binary tree, find its maximum width.
public class TreeWidth {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree2();
		System.out.println(getMaxWidth(root));
	}

	// T(n): O(n), S(n): O(n) [Width of the tree].
	private static int getMaxWidth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);
		int width = 1;
		while (!que.isEmpty()) {
			int lvlWidth = que.size();
			width = Math.max(width, lvlWidth);
			for (int i = 0; i < lvlWidth; i++) {
				TreeNode curr = que.poll();
				if (curr.left != null)
					que.offer(curr.left);
				if (curr.right != null)
					que.offer(curr.right);
			}
		}
		return width;
	}

}
