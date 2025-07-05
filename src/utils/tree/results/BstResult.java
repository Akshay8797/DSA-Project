package utils.tree.results;

import tree.core.TreeNode;

public class BstResult {

	public static class BstInfo {

		public boolean isBst;
		public int min;
		public int max;

		public BstInfo(boolean isBst, int min, int max) {
			this.isBst = isBst;
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "isBst: " + isBst;
		}

	}

	public static class SwapInfo {

		public TreeNode prev;
		public TreeNode first;
		public TreeNode second;

	}

}
