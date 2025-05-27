package tree;

import java.util.ArrayDeque;
import java.util.Queue;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

/*- Given a binary tree, check if it follows Children sum property.
 * 	Children sum property - Sum of the child nodes should be equal to their parent node.
 */
public class ChildrenSumProperty {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree4();
		System.out.println(isChildSum(root));
	}

	// T(n): O(n), S(n): O(h).
	private static boolean isChildSum(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) // Leaf nodes.
			return true;
		int sum = 0;
		if (root.left != null)
			sum += root.left.key;
		if (root.right != null)
			sum += root.right.key;
		boolean rootIsSum = (root.key == sum);
		boolean leftIsSum = isChildSum(root.left);
		boolean rightIsSum = isChildSum(root.right);
		return rootIsSum && leftIsSum && rightIsSum;
	}

	// T(n): O(n), S(n): O(n) [Width of the tree].
	static boolean isChildSumItr(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);
		while (!que.isEmpty()) {
			TreeNode curr = que.poll();
			if (curr.left == null && curr.right == null) // Leaf nodes
				continue;
			int sum = 0;
			if (curr.left != null) {
				sum += curr.left.key;
				que.offer(curr.left);
			}
			if (curr.right != null) {
				sum += curr.right.key;
				que.offer(curr.right);
			}
			if (sum != curr.key)
				return false;
		}
		return true;
	}

}
