package binarySearchTree;

import tree.core.TreeNode;
import tree.core.TreeTraversal;
import utils.TreeUtils;
import utils.tree.results.BstResult;

/*- Given a BST with 2 nodes swapped, fix the BST.
 * 	Solution - Use InOrder traversal as manipulating ranges checks a node only against its ancestors. 
 * 		It does not consider the relative order of nodes within the entire subtree beneath it.
 * 	Ex:    20
 *        /  \		 Here, 10 and 15 are swapped. But using ranges 15 is not detected.
 *       15   30
 *      /  \     
 *     5    10  
 */
public class FixBstWith2NodesSwapped {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree10();
		BstResult.SwapInfo swapInfo = new BstResult.SwapInfo();
		getSwappedNodes(root, swapInfo);
		swapfirstAndSecond(swapInfo);
		TreeTraversal.doInOrder(root);
	}

	// T(n): O(n).
	private static void getSwappedNodes(TreeNode root, BstResult.SwapInfo swapInfo) {
		if (root == null)
			return;
		getSwappedNodes(root.left, swapInfo);
		if (swapInfo.prev != null && root.key < swapInfo.prev.key) {
			if (swapInfo.first == null)
				swapInfo.first = swapInfo.prev;
			swapInfo.second = root;
		}
		swapInfo.prev = root;
		getSwappedNodes(root.right, swapInfo);
	}

	private static void swapfirstAndSecond(BstResult.SwapInfo swapInfo) {
		if (swapInfo.first != null && swapInfo.second != null) {
			int temp = swapInfo.first.key;
			swapInfo.first.key = swapInfo.second.key;
			swapInfo.second.key = temp;
		}
	}

}
