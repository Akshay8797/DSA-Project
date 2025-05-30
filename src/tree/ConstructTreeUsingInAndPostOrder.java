package tree;

import java.util.HashMap;
import java.util.Map;

import tree.core.TreeNode;
import tree.core.TreeTraversal;

/*- Given InOrder and PreOrder traversals of a binary tree as two arrays.
 * 	Construct the binary tree and return the root.
 * 	Note: Binary tree can only be constructed using InOrder and PreOrder combination,
 * 			or InOrder and PostOrder combination.
 * 		  InOrder can also be used with level order to reconstruct the tree. 
 */
public class ConstructTreeUsingInAndPostOrder {

	private static int preIndex = 0;
	private static Map<Integer, Integer> inOrderMap;

	public static void main(String[] args) {
		int[] inOrder = { 20, 10, 40, 30, 50 }, preOrder = { 10, 20, 30, 40, 50 };
		int n = inOrder.length;
		// Using HashMap to avoid using array to get inIndex.
		inOrderMap = new HashMap<>();
		for (int i = 0; i < n; i++)
			inOrderMap.put(inOrder[i], i);
		TreeNode root = createTree(inOrder, preOrder, 0, n - 1);
		TreeTraversal.doInOrder(root);
	}

	/*- Construct the tree in PreOrder fashion, using preIndex variable.
	 * 	T(n): O(n), S(n): O(n).
	 */
	private static TreeNode createTree(int[] inOrder, int[] preOrder, int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(preOrder[preIndex++]);
		int inIndex = inOrderMap.get(root.key);
		root.left = createTree(inOrder, preOrder, inStart, inIndex - 1);
		root.right = createTree(inOrder, preOrder, inIndex + 1, inEnd);
		return root;
	}

}
