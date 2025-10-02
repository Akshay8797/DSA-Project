package graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import utils.GraphUtils;

public class CycleInUndirectedGraph {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 0 }, { 0, 3, 4 }, { 2, 4 }, { 2, 3 } };
		int vrtx = 5;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		boolean hasCycle = false, visited[] = new boolean[vrtx];
		for (int i = 0; i < vrtx; i++) {
			if (!visited[i]) {
//				if (hasCycleBFS(i, adj, visited)) {
				if (hasCycleDFS(i, -1, adj, visited)) {
					hasCycle = true;
					break;
				}
			}
		}
		System.out.println("Cycle present: " + hasCycle);
	}

	static boolean hasCycleDFS(int src, int par, List<List<Integer>> adj, boolean[] visited) {
		visited[src] = true;
		for (int v : adj.get(src)) {
			if (!visited[v]) {
				if (hasCycleDFS(v, src, adj, visited))
					return true; // Found a cycle in this branch.
			} else if (v != par)
				return true; // Found a back edge, cycle exists.
		}
		return false;
	}

	static boolean hasCycleBFS(int src, List<List<Integer>> adj, boolean[] visited) {
		Queue<VertexParent> que = new ArrayDeque<>();
		que.add(new VertexParent(src, -1));
		visited[src] = true;
		while (!que.isEmpty()) {
			VertexParent u = que.poll();
			for (int v : adj.get(u.vertex)) {
				if (v != u.parent) {
					if (!visited[v]) {
						visited[v] = true; // Mark as visited and add to queue.
						que.offer(new VertexParent(v, u.vertex));
					} else // Visited neighbor not parent, cycle detected.
						return true;
				}
			}
		}
		return false;

	}

	private record VertexParent(int vertex, int parent) {
	}

}
