package utils.tree.results;

public class BurnInfo {

	public int distanceToLeaf; // Distance from current node to burning leaf (-1 if leaf not found)
	public int maxBurnTime; // Maximum burn time found so far
	public int height; // height of current subtree

	public BurnInfo(int distance, int maxTime, int height) {
		this.distanceToLeaf = distance;
		this.maxBurnTime = maxTime;
		this.height = height;
	}

	@Override
	public String toString() {
		return "BurnInfo [distance=" + distanceToLeaf + ", maxTime=" + maxBurnTime + ", height=" + height + "]";
	}

}
