package graph;

import java.util.ArrayList;
import java.util.List;

/*-  0 -- 1 -- 3
 *	  \  /
 *	    2 
 */
public class AdjacencyList {

	public static void main(String[] args) {
		int v = 5;
		List<List<Integer>> adj = new ArrayList<>(v);
		for (int i = 0; i < v; i++)
			adj.add(new ArrayList<Integer>());
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		printGraph(adj);
	}

	private static void addEdge(List<List<Integer>> adj, int u, int v) {
		adj.get(u).add(v); // u to v edge.
		adj.get(v).add(u); // v to u edge.
	}

	private static void printGraph(List<List<Integer>> adj) {
		for (List<Integer> edges : adj) {
			for (int edge : edges)
				System.out.print(edge + " ");
			System.out.println();
		}
	}

}
