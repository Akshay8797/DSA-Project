package utils.tree;

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

	/*-		  10
	 *        /
	 *       20   
	 *      /
	 *     30
	 *    /	 \
	 *   40	  50
	 *   	   \
	 *   	   60
	 */
	public static TreeNode createTree5() {
		return createBinaryTree(10, 20, null, 30, null, 40, 50, null, null, null, 60);
	}

	/*-		 10
	 *      /  \
	 *     20  30
	 *        /  \
	 *       40   50 
	 *    	/	 / \
	 *     60	70  80
	 */
	public static TreeNode createTree6() {
		return createBinaryTree(10, 20, 30, null, null, 40, 50, 60, null, 70, 80);
	}

	/*-		 10
	 *      /  \
	 *     20  30
	 *    /  \   \
	 *   40  50  60
	 */
	public static TreeNode createTree7() {
		return createBinaryTree(10, 20, 30, 40, 50, null, 60);
	}

	/*-		 10
	 *      /  \
	 *     20   30
	 *    /  \ 
	 *   40  50
	 */
	public static TreeNode createTree8() {
		return createBinaryTree(10, 20, 30, 40, 50);
	}

	/*-		 15
	 *      /  \
	 *     5   20
	 *    /    / \
	 *   3	  18  80
	 *   	 /
	 *   	16
	 */
	public static TreeNode createBST1() {
		return createBinaryTree(15, 5, 20, 3, null, 18, 80, null, null, 16);
	}

	/*-		 50
	 *      /  \
	 *    30    70
	 *   /  \   / \
	 *  20  40 60  80
	 *   	  /  \
	 *   	 55  65
	 */
	public static TreeNode createBST2() {
		return createBinaryTree(50, 30, 70, 20, 40, 60, 80, null, null, null, null, 55, 65);
	}

}
