package binarySearchTree;

import java.util.Map;
import java.util.TreeMap;

import tree.core.TreeNode;
import utils.TreeUtils;

/*- Given a binary tree, find the sum of nodes on the same vertical lines.
 *  Horizontal distance (HD) is used to determine if two nodes are on the same vertical line.
 *  HD for the root is 0, for the left and right child HD is HD of its Parent -1 and +1 respectively.
 */
public class VerticalSum {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree11();
		TreeMap<Integer, Integer> distSumMap = new TreeMap<>();
		getVDistSums(root, 0, distSumMap);
		for (Map.Entry<Integer, Integer> entry : distSumMap.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	// T(n): O(n * log(hd)) - hd: No. of possible height distances.
	private static void getVDistSums(TreeNode root, int dist, TreeMap<Integer, Integer> distSumMap) {
		if (root == null)
			return;
		distSumMap.put(dist, (root.key + distSumMap.getOrDefault(dist, 0)));
		getVDistSums(root.left, dist - 1, distSumMap);
		getVDistSums(root.right, dist + 1, distSumMap);
	}

}
