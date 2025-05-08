package tree.core;

import utils.TreeUtils;

/*- Depth first traversal: 
 * 	InOrder: Left -> root -> right.
 * 	PreOrder: Root -> left -> right.
 * 	PostOrder: Left -> right -> root.
 */
public class TreeTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree1();
		System.out.print("InOrder traversal: ");
		doInOrder(root);
		System.out.print("\nPreOrder traversal: ");
		doPreOrder(root);
		System.out.print("\nPostOrder traversal: ");
		doPostOrder(root);
	}

	// T(n): O(n), S(n): O(h) - height of the binary tree.
	private static void doInOrder(TreeNode root) {
		if (root != null) {
			doInOrder(root.left);
			System.out.print(root.key + " ");
			doInOrder(root.right);
		}
	}

	// T(n): O(n), S(n): O(h).
	private static void doPreOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.key + " ");
			doPreOrder(root.left);
			doPreOrder(root.right);
		}
	}

	// T(n): O(n), S(n): O(h).
	private static void doPostOrder(TreeNode root) {
		if (root != null) {
			doPostOrder(root.left);
			doPostOrder(root.right);
			System.out.print(root.key + " ");
		}
	}

}
