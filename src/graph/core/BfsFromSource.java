package graph.core;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import utils.GraphUtils;

/*-	Given an undirected connected graph and the source, print BFS of the graph. 
 * 	BFS (Breadth-First Search): Explores all neighbors of a node before moving to next level.
 * 		BFS traverses the graph level-by-level, uses a Queue.
 */
public class BfsFromSource {

	public static void main(String[] args) {
		int[][] edges = { { 1, 5, 2 }, { 0, 3 }, { 0, 4 }, { 1, 5 }, { 2, 5 }, { 0, 3, 4 } };
		int vrtx = 6;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		printBFS(adj, 0);
	}

	// T(n): O(v+e), S(n): O(v).
	private static void printBFS(List<List<Integer>> adj, int src) {
		int vrtx = adj.size();
		boolean[] visited = new boolean[vrtx];
		visited[src] = true;
		Queue<Integer> que = new ArrayDeque<>(vrtx);
		que.offer(src);
		while (!que.isEmpty()) {
			int u = que.poll();
			System.out.print(u + " ");
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					que.offer(v);
					visited[v] = true;
				}
			}
		}
	}

}
