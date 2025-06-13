package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

// PreOrder: root -> left -> right.
public class IterativePreOrder {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();
		printPreOrder(root);
	}

	// T(n): O(n), S(n): O(h).
	private static void printPreOrder(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				System.out.print(curr + " ");
				if (curr.right != null)
					stack.push(curr.right);
				curr = curr.left;
			}
			if (!stack.isEmpty())
				curr = stack.pop();
		}
	}

	/*-	
		private static void printPreOrder(TreeNode root) {
			Deque<TreeNode> stack = new ArrayDeque<>();
			TreeNode curr = root;
			while (curr != null || !stack.isEmpty()) {
				while (curr != null) {
					System.out.print(curr + " ");
					stack.push(curr);
					curr = curr.left;
				}
				curr = stack.pop();
				curr = curr.right;
			}
		}
	*/

}
