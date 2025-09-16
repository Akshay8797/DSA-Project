package utils;

import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

	public static List<List<Integer>> crateAdjList(int v, int[][] neighbors) {
		List<List<Integer>> adj = new ArrayList<>(v);
		if (neighbors.length > v)
			throw new IllegalArgumentException("Size of adj list cannot exceed no. of vertices");
		for (int[] row : neighbors) {
			List<Integer> edgeRow = new ArrayList<>();
			for (int nbr : row)
				edgeRow.add(nbr);
			adj.add(edgeRow);
		}
		return adj;
	}

	public static void printGraph(List<List<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i + " -> [");
			List<Integer> edges = adj.get(i);
			for (int j = 0; j < edges.size(); j++) {
				System.out.print(edges.get(j));
				if (j != edges.size() - 1)
					System.out.print(" ");
			}
			System.out.print("] \n");
		}
	}

}
