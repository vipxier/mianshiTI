package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {
	public static List<Integer> DFS_Recursion(Graph graph, int start) {
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.size];

		DFSUtil(result, graph, start, visited);
		return result;
	}

	private static void DFSUtil(List<Integer> result, Graph graph, int start, boolean[] visited) {
		visited[start] = true;
		result.add(start);

		for (int neighbor : graph.neighbors[start]) {
			if (!visited[neighbor]) {
				DFSUtil(result, graph, neighbor, visited);
			}
		}
	}

	public static List<Integer> DFS_Iterative(Graph graph, int start) {
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.size];
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(start);

		while (!stack.isEmpty()) {
			int parent = stack.pop();
			if (!visited[parent]) {
				visited[parent] = true;
				result.add(parent);
			}

			for (int neighbor : graph.neighbors[parent]) {
				if (!visited[neighbor]) {
					stack.push(neighbor);
				}
			}
		}
		return result;
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

		System.out.println(DFS_Recursion(graph, 0));
		System.out.println(DFS_Iterative(graph, 0));
	}
}
