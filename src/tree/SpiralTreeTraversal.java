package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

public class SpiralTreeTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();
		printSprialTraversalEff(root);
	}

	// T(n): O(n) [precisely O(4n)], S(n): O(n).
	static void printSprialTraversal(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);
		Deque<TreeNode> lvlStack = new ArrayDeque<>();
		boolean reverse = false;

		while (!que.isEmpty()) {
			int lvlWidth = que.size();
			for (int i = 0; i < lvlWidth; i++) {
				TreeNode curr = que.poll();
				if (reverse)
					lvlStack.push(curr);
				else
					System.out.print(curr + " ");
				if (curr.left != null)
					que.offer(curr.left);
				if (curr.right != null)
					que.offer(curr.right);
			}
			if (reverse) {
				while (!lvlStack.isEmpty())
					System.out.print(lvlStack.pop() + " ");
			}
			reverse = !reverse;
		}
	}

	// T(n): O(n) [precisely O(2n)], S(n): O(n).
	static void printSprialTraversalEff(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack1 = new ArrayDeque<>();
		stack1.push(root);
		Deque<TreeNode> stack2 = new ArrayDeque<>();
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				TreeNode curr = stack1.pop();
				System.out.print(curr + " ");
				if (curr.left != null)
					stack2.push(curr.left);
				if (curr.right != null)
					stack2.push(curr.right);
			}
			while (!stack2.isEmpty()) {
				TreeNode curr = stack2.pop();
				System.out.print(curr + " ");
				if (curr.right != null)
					stack1.push(curr.right);
				if (curr.left != null)
					stack1.push(curr.left);
			}
		}
	}

}
