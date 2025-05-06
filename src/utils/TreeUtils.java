package utils;

import java.util.LinkedList;
import java.util.Queue;

import tree.core.TreeNode;

public class TreeUtils {

	public static TreeNode createBinaryTree(Integer... keys) {
		if (keys.length == 0 || keys[0] == null) {
			return null;
		}
		TreeNode root = new TreeNode(keys[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (i < keys.length) {
			TreeNode current = queue.poll();
			// Add left child
			if (i < keys.length && keys[i] != null) {
				current.left = new TreeNode(keys[i]);
				queue.add(current.left);
			}
			i++;
			// Add right child
			if (i < keys.length && keys[i] != null) {
				current.right = new TreeNode(keys[i]);
				queue.add(current.right);
			}
			i++;
		}
		return root;
	}

	/*-		 10
	 *      /  \
	 *     20  30
	 *    /  \   \
	 *   40   50  60 
	 *   	  / \
	 *       70  80
	 */
	public static TreeNode createTree1() {
		return createBinaryTree(10, 20, 30, 40, 50, null, 60, null, null, 70, 80);
	}

	/*-		 10
	 *      /  \
	 *     30  40
	 *    /   /  \
	 *   80  60   20 
	 *    \
	 *     70
	 */
	public static TreeNode createTree2() {
		return createBinaryTree(10, 30, 40, 80, null, 60, 20, null, 70);
	}

	/*-		 10
	 *      /  \
	 *     50  60
	 *        /  \
	 *       70   20 
	 *    	  \
	 *     	   8
	 */
	public static TreeNode createTree3() {
		return createBinaryTree(10, 50, 60, null, null, 70, 20, null, 8);
	}

	/*-		 20
	 *      /  \
	 *     8   12
	 *    / \
	 *   3   5 
	 */
	public static TreeNode createTree4() {
		return createBinaryTree(20, 8, 12, 3, 5);
	}

}
