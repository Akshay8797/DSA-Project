package graph.prims;

import java.util.Arrays;

/*- Given an adjacency matrix representing an undirected, connected, and weighted graph.
 * 	Print the weight of the minimum spanning tree (MST).
 */
public class PrimsMst {

	public static void main(String[] args) {
		int[][] graph = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 0 },
				{ 0, 5, 7, 0, 0 } };
		System.out.println("Weight of the MST: " + getMstWeight(graph));

	}

	// T(n): O(V²), S(n): O(V²),
	private static int getMstWeight(int[][] graph) {
		int n = graph.length, totalWeight = 0, key[] = new int[n];
		Arrays.fill(key, Integer.MAX_VALUE);
		key[0] = 0;
		boolean[] inMST = new boolean[n];
		for (int count = 0; count < n; count++) {
			int u = -1;
			// Find the vertex with the minimum key value, not yet included in MST.
			for (int i = 0; i < n; i++) {
				if (!inMST[i] && (u == -1 || key[i] < key[u]))
					u = i;
			}
			if (key[u] == Integer.MAX_VALUE)
				return -1; // Graph is disconnected, MST not possible.
			inMST[u] = true;
			totalWeight = totalWeight + key[u];
			// Update key values of adjacent vertices of the picked vertex.
			for (int v = 0; v < n; v++) {
				if (!inMST[v] && graph[u][v] != 0 && graph[u][v] < key[v])
					key[v] = graph[u][v];
			}
		}
		return totalWeight;
	}

}
