package binarySearchTree.core;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

/* Given the root of BST and a key. Find the floor of the key in the BST.
 * Floor: Equal or closest smaller value.
 */
public class FloorInBst {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createBST2();
		System.out.println(getFloor(root, 58));
	}

	// T(n): O(h).
	private static Integer getFloor(TreeNode root, int x) {
		Integer floor = null;
		while (root != null) {
			if (root.key == x)
				return x;
			if (root.key > x)
				root = root.left;
			else {
				floor = root.key;
				root = root.right;
			}
		}
		return floor;
	}

}
