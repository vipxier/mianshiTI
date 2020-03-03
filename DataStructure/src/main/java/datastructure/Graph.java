package datastructure;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	int size;
	LinkedList<Integer>[] neighbors;

	public Graph(int size) {
		this.size = size;
		this.neighbors = new LinkedList[size];

		for (int i = 0; i < size; i++) {
			neighbors[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination) {
		neighbors[source].add(destination);
		neighbors[destination].add(source);
	}

	public void addDirectedEdge(int source, int destination) {
		neighbors[source].add(destination);
	}

	public ArrayList<Integer> BFS(int source) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[size];

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(source);
		visited[source] = true;
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			result.add(new Integer(currentNode));
			// visited[currentNode] = true;
			for (int num : neighbors[currentNode]) {
				if (!visited[num]) {
					visited[num] = true;
					queue.offer(num);
				}
			}
		}

		return result;
	}

	public ArrayList<Integer> DFS(int start) {
		boolean[] visited = new boolean[size];

		ArrayList<Integer> result = new ArrayList<Integer>();

		DFSUtil(result, start, visited);

		return result;
	}

	private void DFSUtil(ArrayList<Integer> result, int start, boolean[] visited) {
		visited[start] = true;
		result.add(start);

		for (int neighbor : neighbors[start]) {
			if (!visited[neighbor]) {
				DFSUtil(result, neighbor, visited);
			}
		}
	}

	public boolean detectCycle_directedGraph() {
		for (int i = 0; i < this.size; i++) {
			boolean[] visited = new boolean[size];
			boolean[] back = new boolean[size];
			if (findCycle_directed(visited, back, i, neighbors)) {
				return true;
			}
		}
		return false;
	}

	private boolean findCycle_directed(boolean[] visited, boolean[] back, int start, LinkedList<Integer>[] neighbors) {
		if (back[start]) {
			return true;
		}

		if (visited[start]) {
			return false;
		}

		back[start] = true;
		visited[start] = true;

		for (int neighbor : neighbors[start]) {
			if (findCycle_directed(visited, back, neighbor, neighbors)) {
				return true;
			}
		}

		back[start] = false;
		return false;
	}

	public boolean detectCycle_undirectedGraph() {
		boolean[] visited = new boolean[size];

		for (int i = 0; i < size; i++) {
			if (detectCycle_undirectedGraph(visited, i, -1)) {
				return true;
			}
		}

		return false;
	}

	private boolean detectCycle_undirectedGraph(boolean[] visited, int currentNode, int parent) {
		visited[currentNode] = true;

		for (int neighbor : neighbors[currentNode]) {
			if (neighbor != parent) {
				if (visited[neighbor]) {
					return true;
				} else {
					if (detectCycle_undirectedGraph(visited, neighbor, parent)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		// graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		System.out.println(graph.BFS(0));

		System.out.println(graph.DFS(0));

		Graph directedGraph = new Graph(5);
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(0, 2);
		directedGraph.addDirectedEdge(1, 3);
		directedGraph.addDirectedEdge(1, 4);
		directedGraph.addDirectedEdge(2, 4);
		directedGraph.addDirectedEdge(4, 0);

		System.out.println(directedGraph.detectCycle_directedGraph());
	}

}
