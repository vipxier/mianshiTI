package datastructure;

public class DetectCycleInDirectedGraph {
	public static boolean detectCycle(Graph graph) {
		if (graph == null) {
			return false;
		}

		for (int i = 0; i < graph.size; i++) {
			boolean[] visited = new boolean[graph.size];
			boolean[] parent = new boolean[graph.size];

			if (detectCycleUtil(graph, i, visited, parent)) {
				return true;
			}
		}

		return false;
	}

	private static boolean detectCycleUtil(Graph graph, int source, boolean[] visited, boolean[] parent) {
		if (parent[source]) {
			return true;
		}

		if (visited[source]) {
			return false;
		}

		parent[source] = true;
		visited[source] = true;

		for (int neighbor : graph.neighbors[source]) {
			if (detectCycleUtil(graph, neighbor, visited, parent)) {
				return true;
			}

		}
		parent[source] = false;
		return false;
	}

	public static void main(String[] args) {
		Graph directedGraph = new Graph(5);
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(0, 2);
		directedGraph.addDirectedEdge(1, 3);
		directedGraph.addDirectedEdge(1, 4);
		directedGraph.addDirectedEdge(2, 4);
		directedGraph.addDirectedEdge(4, 0);

		System.out.println(detectCycle(directedGraph));
	}
}
