package binarySearchTree;

import utils.tree.TreeNodeAug;

// Design a DS that supports Search, insert, delete, and kth smallest element efficiently.
public class KthSmallestElement {

	public static void main(String[] args) {
		TreeNodeAug root = null;
		root = insertNode(root, 10);
		root = insertNode(root, 5);
		root = insertNode(root, 15);
		root = insertNode(root, 30);
		root = insertNode(root, 12);
		System.out.print("Initial tree: ");
		printInorder(root);
		root = safeDelete(root, 30);
		System.out.print("\nPost delete: ");
		printInorder(root);
		System.out.print("\n3rd smallest: " + getKthSmallest(root, 3));
	}

	// All functions have T(n): O(h).
	static TreeNodeAug getKthSmallest(TreeNodeAug root, int k) {
		if (root == null)
			return null;
		else if (root.lCount + 1 > k)
			return getKthSmallest(root.left, k);
		else if (root.lCount + 1 < k)
			return getKthSmallest(root.right, k - root.lCount - 1);
		else
			return root;
	}

	static boolean searchNode(TreeNodeAug root, int x) {
		if (root == null)
			return false;
		else if (root.key == x)
			return true;
		else if (root.key > x)
			return searchNode(root.left, x);
		else
			return searchNode(root.right, x);
	}

	static TreeNodeAug insertNode(TreeNodeAug root, int x) {
		if (root == null)
			return new TreeNodeAug(x);
		else if (root.key > x) {
			root.lCount++;
			root.left = insertNode(root.left, x);
		} else
			root.right = insertNode(root.right, x);
		return root;
	}

	static TreeNodeAug safeDelete(TreeNodeAug root, int x) {
		if (!searchNode(root, x)) {
			System.out.print("\nDeletion failed! Key " + x + " is not present.");
			return root;
		}
		return deleteNode(root, x);
	}

	static TreeNodeAug deleteNode(TreeNodeAug root, int x) {
		if (root == null)
			return null;
		else if (root.key > x) {
			root.left = deleteNode(root.left, x);
			root.lCount--;
		} else if (root.key < x)
			root.right = deleteNode(root.right, x);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else { // Both left and right children are present
				TreeNodeAug succ = getSucc(root);
				root.key = succ.key;
				root.right = deleteNode(root.right, succ.key);
			}
		}
		return root;
	}

	// Get Successor on the right.
	private static TreeNodeAug getSucc(TreeNodeAug root) {
		TreeNodeAug curr = root.right;
		while (curr != null && curr.left != null)
			curr = curr.left;
		return curr;
	}

	// InOrder traversal utility.
	static void printInorder(TreeNodeAug root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.key + " ");
			printInorder(root.right);
		}
	}

}
