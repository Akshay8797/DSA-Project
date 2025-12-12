package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import utils.GraphUtils;

/*- Given a directed graph. Find and print the Strongly Connected Components (SCC) in it.
 * 	An SCC in a directed graph is a maximal set of vertices such that,
 *		there is a path from each vertex to every other vertex in the set.
 *	Note: Vertices in an SCC can be printed in any order.
 */
public class KosarajuAlgorithm {

	/*-	1. Order the vertices in decreasing order of their finish times in DFS.
	 * 	2. Reverse all the edges.
	 * 	3. Do DFS of the reversal graph in the order obtained in step 1.
	 */
	public static void main(String[] args) {
		int[][] edges = { { 1 }, { 2, 3 }, { 0 }, { 4 }, {} };
		int n = 5;
		List<List<Integer>> graph = GraphUtils.buildGraph(n, edges);
		printSCC(graph, n);
	}

	// T(n): O(V + E), S(n): O(V + E).
	private static void printSCC(List<List<Integer>> graph, int n) {
		Deque<Integer> stack = new ArrayDeque<>(); // Stack to store the order of nodes by finish time.
		boolean[] visited = new boolean[n]; // Visited array for DFS

		// Step-1: Order vertices by finish time in the original graph.
		for (int u = 0; u < n; u++) {
			if (!visited[u])
				doDFS(graph, u, stack, visited);
		}
		// Step-2: Get the transpose of the graph (edges reversed).
		List<List<Integer>> transposeGraph = getTranspose(graph, n);
		Arrays.fill(visited, false); // Reset visited array for 2nd DFS.

		// Step-3: Perform DFS on the transpose using the order (Stack) from Step-1.
		while (!stack.isEmpty()) {
			int v = stack.pop();
			Deque<Integer> scc = new ArrayDeque<>();
			if (!visited[v]) {
				doDFS(transposeGraph, v, scc, visited);
				System.out.println(scc);
			}
		}
	}

	private static List<List<Integer>> getTranspose(List<List<Integer>> graph, int n) {
		List<List<Integer>> transposeGraph = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			transposeGraph.add(new ArrayList<>());
		// Reverse the direction of all edges.
		for (int u = 0; u < n; u++) {
			for (int v : graph.get(u))
				transposeGraph.get(v).add(u);
		}
		return transposeGraph;
	}

	private static void doDFS(List<List<Integer>> graph, int u, Deque<Integer> stack, boolean[] visited) {
		visited[u] = true;
		for (int v : graph.get(u)) {
			if (!visited[v])
				doDFS(graph, v, stack, visited);
		}
		stack.push(u); // Add to stack after all descendants (Post-order).
	}

}
