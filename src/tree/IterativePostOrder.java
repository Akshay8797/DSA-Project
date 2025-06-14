package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

// PostOrder: Left -> right -> root.
public class IterativePostOrder {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();
		printPostOrder(root);
	}

	// T(n): O(n), S(n): O(h).
	private static void printPostOrder(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		TreeNode lastVisited = null;
		while (curr != null || !stack.isEmpty()) {
			// Go to leftmost node.
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			TreeNode peekNode = stack.peek();
			// If right child exists and not visited yet, go right.
			if (peekNode.right != null && lastVisited != peekNode.right) {
				curr = peekNode.right;
			} else {
				// Process node.
				System.out.print(peekNode + " ");
				lastVisited = stack.pop();
			}
		}
	}

}
