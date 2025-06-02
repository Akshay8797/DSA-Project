package tree;

import tree.core.TreeHeight;
import tree.core.TreeNode;
import utils.tree.TreeInfo;
import utils.tree.TreeUtils;

/*- Given a binary tree, find it's diameter.
 * 	Diameter is the no. of nodes on the longest path between two leaf nodes.
 * 	Ex: TreeUtils.createTree3() should return 5 which is node 50 to 8.
 * 	A Tree with only 1 node has diameter of 1.
 */
public class DiameterOfTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree5();
		System.out.println(getDiameterAndHeight(root));
	}

	/*- TreeInfo class is introduced to track the leaf presence information.
	 * 	Diameter is the max of: The diameter of left and right subtrees
	 *		and diameter passing through the root (only if both subtrees have leaves).
	 * 	T(n): O(n), S(n): O(h) - Optimal solution.
	 */
	private static TreeInfo getDiameterAndHeight(TreeNode root) {
		if (root == null)
			return new TreeInfo(0, 0, false); // Empty tree
		if (root.left == null && root.right == null) {
			// Leaf node: height = 1, diameter = 1, hasLeaf = true
			return new TreeInfo(1, 1, true);
		}
		TreeInfo left = getDiameterAndHeight(root.left);
		TreeInfo right = getDiameterAndHeight(root.right);

		int height = 1 + Math.max(left.height, right.height);
		int diameter = Math.max(left.diameter, right.diameter);

		if (left.hasLeaf && right.hasLeaf)
			diameter = Math.max(diameter, left.height + right.height + 1);
		boolean hasLeaf = left.hasLeaf || right.hasLeaf;
		return new TreeInfo(height, diameter, hasLeaf);
	}

	/*- For every node find Max(1 + leftHeight + rightHeight).
	 * 	T(n): O(n^2), S(n): O(h).
	 * 	Better solution would be to pre-compute the heights in a map.
	 */
	static int getDiameter(TreeNode root) {
		if (root == null)
			return 0;
		// If the node is a leaf, diameter is 1.
		if (root.left == null && root.right == null)
			return 1;
		int dRoot = 0;
		// Valid only if both children exists else path would not be leaf-to-leaf.
		if (root.left != null && root.right != null) {
			int leftHt = TreeHeight.getTreeHeight(root.left);
			int rightHt = TreeHeight.getTreeHeight(root.right);
			dRoot = 1 + leftHt + rightHt;
		}
		int dLeft = getDiameter(root.left);
		int dRight = getDiameter(root.right);
		return Math.max(dRoot, Math.max(dLeft, dRight));
	}

}
