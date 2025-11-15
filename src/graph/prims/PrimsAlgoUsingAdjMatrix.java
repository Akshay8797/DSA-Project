package graph.prims;

import java.util.Arrays;

/*- Given an adjacency matrix representing an undirected, connected, and weighted graph.
 * 	Print the weight of the minimum spanning tree (MST).
 */
public class PrimsAlgoUsingAdjMatrix {

	public static void main(String[] args) {
		int[][] graph = { { 0, 0, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 0 },
				{ 0, 5, 7, 0, 0 } };
		System.out.println("Weight of the MST: " + getMstWeight(graph));

	}

	private static int getMstWeight(int[][] graph) {
		int vrtx = graph.length, res = 0, key[] = new int[vrtx];
		Arrays.fill(key, Integer.MAX_VALUE);
		key[0] = 0;
		boolean[] mstSet = new boolean[vrtx];
		for (int cnt = 0; cnt < vrtx; cnt++) {
			int u = -1;
			// Find the vertex with the minimum key value, not yet included in MST.
			for (int i = 0; i < vrtx; i++) {
				if (!mstSet[i] && (u == -1 || key[i] < key[u]))
					u = i;
			}
			mstSet[u] = true;
			res = res + key[u];
			// Update key values of adjacent vertices of the picked vertex.
			for (int v = 0; v < vrtx; v++) {
				if (!mstSet[v] && graph[u][v] != 0 && graph[u][v] < key[v])
					key[v] = graph[u][v];
			}
		}
		return res;
	}

}
