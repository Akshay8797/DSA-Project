package utils;

import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

	/*- Builds the adjacency list representation of a graph.
	 * 	@param v: the number of vertices in the graph.
	 * 	@param edges: 2D array where each row contains the neighbors of a vertex.
	 * 		Row i in edges represents the list of neighbors for vertex i.
	 * 	@return the adjacency list of the graph where adj.get(i) is the list of neighbors of vertex i.
	 */
	public static List<List<Integer>> buildGraph(int v, int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>(v);
		if (edges.length > v)
			throw new IllegalArgumentException("Size of adj list cannot exceed no. of vertices");
		for (int[] row : edges) {
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

	public record Edge(int to, int weight) {
	}

	/*- Builds the adjacency list representation of a directed, weighted graph.
	 * 	@param v: the number of vertices in the graph.
	 * 	@param edges: list of int arrays, where each array represents an edge as {from, to, weight}.
	 * 	@return the adjacency list of the graph.
	 */
	public static List<List<Edge>> buildWeightedGraph(int v, List<int[]> edges) {
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < v; i++)
			graph.add(new ArrayList<>());
		for (int[] edge : edges) {
			if (edge.length != 3)
				throw new IllegalArgumentException("An edge must have from, to and weight!");
			int from = edge[0];
			int to = edge[1];
			int weight = edge[2];
			if (from < 0 || from >= v || to < 0 || to >= v)
				throw new IllegalArgumentException("Vertex index out of bounds!");
			graph.get(from).add(new Edge(to, weight));
		}
		return graph;
	}

	public static void printWeightedGraph(List<List<Edge>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print("Node " + i + ": ");
			for (Edge edge : graph.get(i)) {
				System.out.print("[to: " + edge.to() + ", weight: " + edge.weight() + "] ");
			}
			System.out.println();
		}
	}

}
