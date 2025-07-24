package binarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import tree.core.TreeNode;
import utils.TreeUtils;
import utils.tree.results.BstResult.VDistTreeNode;

/*- Given a binary tree, print it vertically from leftmost vertical line to rightmost.
 * 	Horizontal distance (HD) is used to determine if two nodes are on the same vertical line.
 *  HD for the root is 0, for the left and right child HD is HD of its Parent -1 and +1 respectively.
 */
public class VerticalTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree11();
		TreeMap<Integer, List<VDistTreeNode>> vNodesMap = fillVerticalNodes(root);
		for (Map.Entry<Integer, List<VDistTreeNode>> entry : vNodesMap.entrySet()) {
			for (VDistTreeNode node : entry.getValue())
				System.out.print(node + " ");
			System.out.println();
		}
	}

	// T(n): O(n * log n) [TC for tree map is O(log n)], S(n): O(n).
	private static TreeMap<Integer, List<VDistTreeNode>> fillVerticalNodes(TreeNode root) {
		TreeMap<Integer, List<VDistTreeNode>> vNodesMap = new TreeMap<>();
		if (root != null) {
			Queue<VDistTreeNode> que = new ArrayDeque<>();
			que.offer(new VDistTreeNode(root, 0));
			while (!que.isEmpty()) {
				VDistTreeNode curr = que.poll();
				int dist = curr.vDistance;
		// computeIfAbsent(d, k -> new List<>()): Returns the list for key d if map has it, else create an empty list.
				vNodesMap.computeIfAbsent(dist, k -> new ArrayList<>()).add(curr);
				if (curr.node.left != null)
					que.offer(new VDistTreeNode(curr.node.left, dist - 1));
				if (curr.node.right != null)
					que.offer(new VDistTreeNode(curr.node.right, dist + 1));
			}
		}
		return vNodesMap;
	}

}
