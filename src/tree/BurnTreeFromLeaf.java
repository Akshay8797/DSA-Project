package tree;

import tree.core.TreeNode;
import utils.tree.BurnInfo;
import utils.tree.TreeUtils;

/*- Given a binary tree and a leaf node, find the time to burn the tree if initially leaf is burnt.
 * 	Ex: TreeUtils.createTree7() - 50 is burnt at t0, then the order will be:
 * 		t1 - 20, t2 - 40 and 10, t3 - 30, t4 - 40. Hence o/p is 4.
 * 	Similar to finding the distance between the given leaf node to the farthest node.
 */
public class BurnTreeFromLeaf {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree7();
		BurnInfo result = burnTime(root, 50);
		System.out.println(result.maxBurnTime);
	}
	
	// T(n): O(n), S(n): O(h).
	private static BurnInfo burnTime(TreeNode root, int leaf) {
		if (root == null) {
			return new BurnInfo(-1, 0, 0);
		}
		BurnInfo leftInfo = burnTime(root.left, leaf);
		BurnInfo rightInfo = burnTime(root.right, leaf);
		int height = 1 + Math.max(leftInfo.height, rightInfo.height);
		// Check if current node is the leaf.
		if (root.key == leaf) {
			// Distance to leaf is zero at leaf.
			return new BurnInfo(0, 0, height);
		}
		int distanceToLeaf = -1;
		int maxBurnTime = Math.max(leftInfo.maxBurnTime, rightInfo.maxBurnTime);
		if (leftInfo.distanceToLeaf != -1) {
			// Leaf found in left subtree.
			distanceToLeaf = leftInfo.distanceToLeaf + 1;
			// Burn time is distance to leaf + height of right subtree.
			maxBurnTime = Math.max(maxBurnTime, distanceToLeaf + rightInfo.height);
		} else if (rightInfo.distanceToLeaf != -1) {
			// Leaf found in right subtree
			distanceToLeaf = rightInfo.distanceToLeaf + 1;
			// Burn time is distance to leaf + height of left subtree.
			maxBurnTime = Math.max(maxBurnTime, distanceToLeaf + leftInfo.height);
		}
		return new BurnInfo(distanceToLeaf, maxBurnTime, height);
	}

}
