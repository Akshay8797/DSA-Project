package binarySearchTree.core;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

/* Given the root of BST and a key. Find the ceiling of the key in the BST.
 * Ceiling: Equal or closest greater value.
 */
public class CeilingInBst {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createBST2();
		System.out.println(getCeil(root, 52));
	}

	// T(n): O(h).
	private static Integer getCeil(TreeNode root, int x) {
		Integer ceil = null;
		while (root != null) {
			if (root.key == x)
				return x;
			if (root.key > x) {
				ceil = root.key;
				root = root.left;
			} else
				root = root.right;
		}
		return ceil;
	}

}
