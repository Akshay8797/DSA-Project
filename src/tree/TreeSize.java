package tree;

import java.util.ArrayDeque;
import java.util.Queue;

import tree.core.TreeNode;
import utils.TreeUtils;

public class TreeSize {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();;
		System.out.println(getTreeSize(root));
	}

	// T(n): O(n), S(n): O(h).
	private static int getTreeSize(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + getTreeSize(root.left) + getTreeSize(root.right);
	}

	// T(n): O(n), S(n): O(n) [Width of the tree].
	static int getTreeSizeItr(TreeNode root) {
		if (root == null)
			return 0;
		int count = 0;
		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);
		while (!que.isEmpty()) {
			TreeNode curr = que.poll();
			count++;
			if (curr.left != null)
				que.offer(curr.left);
			if (curr.right != null)
				que.offer(curr.right);
		}
		return count;
	}

}
