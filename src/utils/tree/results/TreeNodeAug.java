package utils.tree.results;

public class TreeNodeAug {

	public int key;
	public TreeNodeAug left;
	public TreeNodeAug right;
	public int lCount;

	public TreeNodeAug(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return String.valueOf(key);
	}

}
