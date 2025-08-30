package heap.median;

import utils.tree.results.TreeNodeAug;

/*- Given a Stream or Array, find the median at each point.
 * 	Median is the middle value when the numbers of the sequence are arranged in order, 
 * 	If the sequence has even no. of items, Median is the average of two middle values. 
 * 	Ex: [25, 7, 10, 15, 20] => 25, 16, 10, 12.5, 15
 */
public class MedianUsingBST {

	public static void main(String[] args) {
		int[] arr = { 25, 7, 10, 15, 20 };
		printMedians(arr);
	}

	// T(n): O(n * h). Where h on average is log n. 
	private static void printMedians(int[] arr) {
		TreeNodeAug root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insertToBST(root, arr[i]);
			int size = i + 1;
			int med = getKSmallest(root, (size / 2) + 1).key;
			if (size % 2 != 0)
				System.out.println(med);
			else {
				int medBefore = getKSmallest(root, (size / 2)).key;
				System.out.println((medBefore + med) / 2.0);
			}
		}
	}

	private static TreeNodeAug insertToBST(TreeNodeAug root, int x) {
		if (root == null)
			return new TreeNodeAug(x);
		if (root.key > x) {
			root.lCount++;
			root.left = insertToBST(root.left, x);
		} else
			root.right = insertToBST(root.right, x);
		return root;
	}

	private static TreeNodeAug getKSmallest(TreeNodeAug root, int k) {
		if (root == null)
			return null;
		if (root.lCount + 1 == k)
			return root;
		else if (root.lCount + 1 > k)
			return getKSmallest(root.left, k);
		else
			return getKSmallest(root.right, k - root.lCount - 1);
	}

}
