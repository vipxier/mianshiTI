package OA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CritcalEdges {
	private class Graph {
		int size;
		Set<Integer>[] neighbors;

		public Graph(int size) {
			this.size = size;
			neighbors = new HashSet[size];
			for (int i = 0; i < size; i++) {
				neighbors[i] = new HashSet<Integer>();
			}
		}

		public void addEdge(int source, int destination) {
			this.neighbors[source].add(destination);
			this.neighbors[destination].add(source);
		}

		public void removeEdge(int source, int destination) {
			this.neighbors[source].remove(destination);
			this.neighbors[destination].remove(source);
		}
	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		List<List<Integer>> result = new ArrayList<>();
		if (connections == null || connections.size() == 0) {
			return result;
		}

		Graph graph = new Graph(n);

		for (int edgeIndex = 0; edgeIndex < connections.size(); edgeIndex++) {
			graph.addEdge(connections.get(edgeIndex).get(0), connections.get(edgeIndex).get(1));
		}

		for (int index = 0; index < connections.size(); index++) {
			graph.removeEdge(connections.get(index).get(0), connections.get(index).get(1));
			int nodeCount = BFSToFindNodes(graph, 0);
			if (nodeCount != n) {
				List<Integer> edge = new ArrayList<Integer>();
				edge.add(connections.get(index).get(0));
				edge.add(connections.get(index).get(1));
				result.add(new ArrayList<Integer>(edge));
			}
			graph.addEdge(connections.get(index).get(0), connections.get(index).get(1));
		}

		return result;

	}

	private int BFSToFindNodes(Graph graph, int start) {
		int nodeCount = 0;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.size];
		queue.offer(start);
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			if (!visited[currentNode]) {
				nodeCount++;
				visited[currentNode] = true;
			}

			for (int neighbor : graph.neighbors[currentNode]) {
				if (!visited[neighbor]) {
					queue.offer(neighbor);
				}
			}
		}
		return nodeCount;
	}

	public static void main(String[] args) {
		int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 } };
		CriticalEdges solution = new CriticalEdges();
		System.out.println(solution.getCriticalEdges(4, 4, edges));
	}
}
