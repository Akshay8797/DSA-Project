package utils.tree;

public class BstInfo {

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
		return "BstInfo [isBst=" + isBst + ", min=" + min + ", max=" + max + "]";
	}

}
