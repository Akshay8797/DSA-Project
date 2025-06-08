package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import tree.core.TreeNode;
import tree.core.TreeTraversal;
import utils.tree.TreeUtils;

/*- Given root reference of BT, convert it to a string or an array such that the BT can be reconstructed.
 * 	Serialization: Process of converting BT to array or String.
 * 	Deserialization: Process of constructing the BT from the array or string.
 */

public class SerializeDeserialize {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree3();
		List<Integer> data = new ArrayList<>();
		serialize(root, data);
		System.out.println("Serialized Tree: " + data);
		TreeNode reconstRoot = deserialize(data, new AtomicInteger(0));
		System.out.print("Deseriaized [InOrder]: ");
		TreeTraversal.doPreOrder(reconstRoot);
	}

	private static final int NULL_NODE = -1;

	// T(n): O(n), S(n): O(n) [O(2n+1) precisely].
	private static void serialize(TreeNode root, List<Integer> data) {
		if (root == null) {
			data.add(NULL_NODE);
			return;
		}
		data.add(root.key);
		serialize(root.left, data);
		serialize(root.right, data);
	}

	/*- AtomicInteger used since it is mutable int object to avoid stale index going to root.right
	 * 	T(n): O(n), S(n): O(h).
	 */
	private static TreeNode deserialize(List<Integer> data, AtomicInteger index) {
		if (index.get() == data.size())
			return null;
		int key = data.get(index.getAndIncrement());
		if (key == NULL_NODE)
			return null;
		TreeNode root = new TreeNode(key);
		root.left = deserialize(data, index);
		root.right = deserialize(data, index);
		return root;
	}

}
