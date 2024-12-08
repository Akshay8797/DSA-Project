package sorting.into;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {

	public static void main(String[] args) {

		List<Point> pointsList = new ArrayList<>();
		pointsList.add(new Point(5, 10));
		pointsList.add(new Point(2, 20));
		pointsList.add(new Point(10, 30));
		Collections.sort(pointsList);
		pointsList.stream().forEach(x -> System.out.print(x + " "));

		System.out.println();
		Collections.sort(pointsList, new Point.PointComparatorY());
		pointsList.stream().forEach(x -> System.out.print(x + " "));

	}

}
