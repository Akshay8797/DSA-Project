package graph.articulation;

import java.util.ArrayList;
import java.util.List;

import utils.GraphUtils;

/*- Given an undirected and connected graph, find the articulation points (or cut vertices).
 * 	Articulation points are the vertices removing which (including the associated edges) results in multiple components.
 */
public class ArticulationPointSimple {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 0, 2 }, { 0, 1, 3 }, { 2, 4 }, { 3 } };
		List<List<Integer>> graph = GraphUtils.buildGraph(5, edges);
		List<Integer> articulationPoints = getArticulationPoints(graph);
		System.out.println(articulationPoints);
	}

	/*- For each vertex v, temporarily remove v. Run a BFS or DFS from any other vertex.
	 * 	If not all vertices (except v) are visited, the vertex is an articulation point.
	 * 	To check if the graph is connected perform a BFS or DFS from any node and see if all nodes are visited.
	 * 	T(n): O(V x (V + E)), S(n): O(V + E).
	 */
	private static List<Integer> getArticulationPoints(List<List<Integer>> graph) {
		List<Integer> artPoints = new ArrayList<>();
		int n = graph.size();
		if (n <= 1)
			return artPoints; // No articulation points in a single-node graph
		for (int u = 0; u < n; u++) {
			if (isArticulationPoint(u, graph))
				artPoints.add(u);
		}
		return artPoints;
	}

	private static boolean isArticulationPoint(int removedVrtx, List<List<Integer>> graph) {
		int n = graph.size();
		boolean[] visited = new boolean[n];
		int startVrtx = (removedVrtx == 0) ? 1 : 0;
		runDFS(startVrtx, removedVrtx, visited, graph);
		for (int i = 0; i < n; i++) {
			if (i != removedVrtx && !visited[i])
				return true;
		}
		return false;
	}

	private static void runDFS(int u, int removedVrtx, boolean[] visited, List<List<Integer>> graph) {
		visited[u] = true;
		for (int v : graph.get(u)) {
			if (v != removedVrtx && !visited[v])
				runDFS(v, removedVrtx, visited, graph);
		}
	}

}
