package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*- Given an undirected graph and a source vertex 's'. Print BFS.
 * 	1 5 2
 * 	0 3
 * 	0 4		=> For s at 0, BFS is 0 1 5 2 3 4.
 * 	1 5
 * 	2 5
 * 	0 3 4
 */
public class BreadthFirstSearch {

	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>(5);
		adj.add(List.of(1, 5, 2));
		adj.add(List.of(0, 3));
		adj.add(List.of(0, 4));
		adj.add(List.of(1, 5));
		adj.add(List.of(2, 5));
		adj.add(List.of(0, 3, 4));
		printBfs(adj, 0);
	}

	// T(n): O(v+e), S(n): O(v+e).
	private static void printBfs(List<List<Integer>> adj, int src) {
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
