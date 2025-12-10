package utils;

import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

	/*- Builds the adjacency list representation of a graph.
	 * 	@param v: the number of vertices in the graph.
	 * 	@param edges: 2D array where each row contains the neighbors of that vertex (index).
	 * 		Row i in edges represents the list of neighbors for vertex i.
	 * 	@return the adjacency list of the graph where adj.get(i) is the list of neighbors of vertex i.
	 */
	public static List<List<Integer>> buildGraph(int numVertices, int[][] neighborsPerVertex) {
		List<List<Integer>> adjadjList = new ArrayList<>(numVertices);
		if (neighborsPerVertex.length > numVertices)
			throw new IllegalArgumentException("Size of adj list cannot exceed no. of vertices");
		for (int[] neighbors : neighborsPerVertex) {
			List<Integer> edgeRow = new ArrayList<>();
			for (int neighbor : neighbors) {
				if (neighbor < 0 || neighbor >= numVertices)
					throw new IllegalArgumentException("Neighbor index out of bounds!");
				edgeRow.add(neighbor);
			}
			adjadjList.add(edgeRow);
		}
		return adjadjList;
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

	// Weighted edge.
	public record Edge(int to, int weight) implements Comparable<Edge> {
		@Override
		public int compareTo(Edge v) {
			return Integer.compare(this.weight, v.weight);
		}
	};

	/*- Builds the adjacency list representation of a directed, weighted graph.
	 * 	@param numVertices: the number of vertices in the graph.
	 * 	@param edgesPerVertex: 2D array where each row contains the neighbors of that vertex (index).
	 * 		Row i in edges represents the list of neighbors for vertex i.
	 * 	@return the adjacency list of the graph.
	 */
	public static List<List<Edge>> buildWeightedGraph(int numVertices, Edge[][] edgesPerVertex) {
		List<List<Edge>> adjList = new ArrayList<>();
		if (edgesPerVertex.length > numVertices)
			throw new IllegalArgumentException("Size of adj list cannot exceed no. of vertices");
		for (Edge[] adjacentEdges : edgesPerVertex) {
			List<Edge> edgeList = new ArrayList<>();
			for (Edge edge : adjacentEdges) {
				if (edge.to() < 0 || edge.to() >= numVertices)
					throw new IllegalArgumentException("Vertex index out of bounds!");
				edgeList.add(edge);
			}
			adjList.add(edgeList);
		}
		return adjList;
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
