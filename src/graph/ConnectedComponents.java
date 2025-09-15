package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*- Given an undirected disconnected graph, 
 * 		find the no. of connected graphs or components in it. 
 */
public class ConnectedComponents {

	// T(n): O(v+e), S(n): O(v+e).
	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>(5);
		adj.add(List.of(1, 2));
		adj.add(List.of(0, 2));
		adj.add(List.of(0, 1));
		adj.add(List.of(4));
		adj.add(List.of(3));
		System.out.println(getConnectedComp(adj));
	}

	private static int getConnectedComp(List<List<Integer>> adj) {
		int vrtx = adj.size(), compCount = 0;
		boolean[] visited = new boolean[vrtx];
		for (int i = 0; i < vrtx; i++) {
			if (!visited[i]) {
				compCount++;
				doBfs(adj, vrtx, i, visited);
			}
		}
		return compCount;
	}

	private static void doBfs(List<List<Integer>> adj, int vrtx, int src, boolean[] visited) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(src);
		while (!que.isEmpty()) {
			int u = que.poll();
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					que.offer(v);
					visited[v] = true;
				}
			}
		}
	}

}
