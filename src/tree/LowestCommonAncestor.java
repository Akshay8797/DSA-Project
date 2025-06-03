package tree;

import java.util.ArrayList;
import java.util.List;

import tree.core.TreeNode;
import utils.tree.TreeUtils;

/*- Given a binary tree and two nodes inside it, find the LCA.
 * 	Ancestor of a node is the node, its parent, parent's parent and so on.
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree6();
		System.out.println(findLcaEff(root, 60, 70));
	}

	// T(n): O(n), S(n): O(h) [Assumes both nodes are present in the tree].
	public static TreeNode findLcaEff(TreeNode root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.key == n1 || root.key == n2)
			return root;
		TreeNode leftLca = findLcaEff(root.left, n1, n2);
		TreeNode rightLca = findLcaEff(root.right, n1, n2);
		if (leftLca != null && rightLca != null)
			return root;
		return (leftLca != null) ? leftLca : rightLca;
	}

	// T(n): O(n) [3 traversals in worst case], S(n): O(n)
	static Integer findLca(TreeNode root, int n1, int n2) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
		if (!findPath(root, path1, n1) || !findPath(root, path2, n2))
			return null; // If either node is not present, return null.
		int i = 0;
		while (i < path1.size() && i < path2.size()) {
			if (!path1.get(i).equals(path2.get(i)))
				break;
			i++;
		}
		return path1.get(i - 1); // The last common node is LCA.
	}

	private static boolean findPath(TreeNode root, List<Integer> path, int node) {
		if (root == null)
			return false;
		path.add(root.key);
		if (root.key == node)
			return true;
		if (findPath(root.left, path, node) || findPath(root.right, path, node))
			return true;
		path.remove(path.size() - 1); // Backtrack if node not found in this path
		return false;
	}

}
