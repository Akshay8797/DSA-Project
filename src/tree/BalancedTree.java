package tree;

import tree.core.TreeHeight;
import tree.core.TreeNode;
import utils.TreeUtils;

/*- Given a binary tree, check if it is height balanced for each node.
 * 	Height balanced - Difference b/w heights of left and right subtrees should not be more than 1.
 */
public class BalancedTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree4();
		System.out.println(isHeightBalanced(root));
	}

	private static boolean isHeightBalanced(TreeNode root) {
		return isBalanced(root) != -1;
	}

	/*- Combine height calculation and balance check in one traversal.
	 * 	Returns height of the tree if it is balanced else returns -1.
	 * 	T(n): O(n), S(n): O(h).
	 */
	private static int isBalanced(TreeNode root) {
		if (root == null)
			return 0;
		int leftHt = isBalanced(root.left);
		if (leftHt == -1)
			return -1;
		int rightHt = isBalanced(root.left);
		if (rightHt == -1)
			return -1;
		if (Math.abs(rightHt - leftHt) > 1)
			return -1;
		else
			return Math.max(leftHt, rightHt) + 1;
	}

	// T(n): O(n^2), S(n): O(h^2).
	static boolean isBalancedNaive(TreeNode root) {
		if (root == null)
			return true;
		int leftHt = TreeHeight.getTreeHeight(root.left);
		int rightHt = TreeHeight.getTreeHeight(root.right);
		return (Math.abs(rightHt - leftHt) <= 1) && isBalancedNaive(root.left) && isBalancedNaive(root.right);
	}

}
