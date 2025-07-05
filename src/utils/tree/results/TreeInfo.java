package utils.tree.results;

public class TreeInfo {

	public int height;
	public int diameter;
	public boolean hasLeaf;

	public TreeInfo(int height, int diameter, boolean hasLeaf) {
		this.height = height;
		this.diameter = diameter;
		this.hasLeaf = hasLeaf;
	}

	@Override
	public String toString() {
		return "TreeInfo: height=" + height + ", diameter=" + diameter;
	}

}
