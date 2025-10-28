package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import utils.GraphUtils;

public class ToplogicalSortingDFS {
	public static void main(String[] args) {
		int[][] edges = { { 2, 3 }, { 3, 4 }, { 3 }, {}, {} };
		int vrtx = 5;
		List<List<Integer>> adj = GraphUtils.buildGraph(vrtx, edges);
		printTopoOrderDFS(adj, vrtx);
	}

	private static void printTopoOrderDFS(List<List<Integer>> adj, int vrtx) {
		Deque<Integer> stack = new ArrayDeque<>(vrtx);
		boolean[] visited = new boolean[vrtx];
		for (int u = 0; u < vrtx; u++) {
			if (!visited[u])
				doDFS(adj, u, stack, visited);
		}
		// Print topological order (from stack)
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	private static void doDFS(List<List<Integer>> adj, int u, Deque<Integer> stack, boolean[] visited) {
		visited[u] = true;
		for (int v : adj.get(u)) {
			if (!visited[v])
				doDFS(adj, v, stack, visited);
		}
		stack.push(u); // push after processing descendants
	}

}
