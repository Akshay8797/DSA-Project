package binarySearchTree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import tree.core.TreeNode;
import utils.TreeUtils;
import utils.tree.results.BstResult.VDistTreeNode;

/*- Print the top view of binary tree - Top node in each vertical line.
 * 	If 2 nodes are the top node in a vertical line, we consider left node.
 *  Horizontal distance (HD) is used to determine if two nodes are on the same vertical line.
 *  HD for the root is 0, for the left and right child HD is HD of its Parent -1 and +1 respectively.
 */
public class TopView {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree11();
		TreeMap<Integer, VDistTreeNode> topNodesMap = fillTopNodes(root);
		for (Map.Entry<Integer, VDistTreeNode> entry : topNodesMap.entrySet())
			System.out.print(entry.getValue() + " ");
	}

	private static TreeMap<Integer, VDistTreeNode> fillTopNodes(TreeNode root) {
		TreeMap<Integer, VDistTreeNode> topNodesMap = new TreeMap<>();
		if (root != null) {
			Queue<VDistTreeNode> que = new ArrayDeque<>();
			que.offer(new VDistTreeNode(root, 0));
			while (!que.isEmpty()) {
				VDistTreeNode curr = que.poll();
				int dist = curr.vDistance;
				// Only top level nodes are to be considered for a HD.
				if (!topNodesMap.containsKey(dist))
					topNodesMap.put(dist, curr);
				if (curr.node.left != null)
					que.offer(new VDistTreeNode(curr.node.left, dist - 1));
				if (curr.node.right != null)
					que.offer(new VDistTreeNode(curr.node.right, dist + 1));
			}
		}
		return topNodesMap;
	}

}
