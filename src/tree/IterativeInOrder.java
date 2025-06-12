package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

// InOrder: Left -> root -> right.
public class IterativeInOrder {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();
		printInOrder(root);
	}

	// T(n): O(n), S(n): O(h).
	private static void printInOrder(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.print(curr + " ");
			curr = curr.right;
		}
	}

}
