package tree.core;

//Self referential structure
public class TreeNode {

	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return String.valueOf(key);
	}

}
