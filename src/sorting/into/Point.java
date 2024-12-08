package sorting.into;

import java.util.Comparator;

public class Point implements Comparable<Point> {

	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point p) {
		return this.x - p.x;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public static class PointComparatorY implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			return p1.y - p2.y;
		}
	}

}
