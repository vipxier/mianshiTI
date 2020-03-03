package datastructure;

import java.util.Stack;

public class DirectedGraphDetectCycle {
	public static boolean detectCycle(Graph graph) {
		for (int i = 0; i < graph.size; i++) {
			boolean[] visited = new boolean[graph.size];
			boolean[] parentVisited = new boolean[graph.size];
			if (detechGraphUtil(graph, i, visited, parentVisited)) {
				return true;
			}
		}
		return false;
	}

	private static boolean detechGraphUtil(Graph graph, int start, boolean[] visited, boolean[] parentVisited) {
		if (parentVisited[start]) {
			return true;
		}

		if (visited[start]) {
			return false;
		}
		parentVisited[start] = true;
		visited[start] = true;

		for (int neighbor : graph.neighbors[start]) {
			if (detechGraphUtil(graph, neighbor, visited, parentVisited)) {
				return true;
			}
		}
		parentVisited[start] = false;
		return false;
	}

	public static boolean detectCycle_Iterative(Graph graph) {
		for (int i = 0; i < graph.size; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(i);
			boolean[] visited = new boolean[graph.size];
			boolean[] parentVisited = new boolean[graph.size];
			parentVisited[0] = true;
			while (!stack.isEmpty()) {
				int parent = stack.pop();

				if(!visited[parent] )
				{
					if(parentVisited[parent]) {
						return true;
					}
					visited[parent] = true;
					parentVisited[parent] = true;
				}
				
				for(int neighbor : graph.neighbors[parent])
				{
					if(!visited[neighbor])
					{
						stack.push(neighbor);
					}
				}
				//parentVisited[parent] = false;
			}
			
		}
		return false;

	}

	public static void main(String[] args) {
		Graph directedGraph = new Graph(5);
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(0, 2);
		directedGraph.addDirectedEdge(1, 3);
		directedGraph.addDirectedEdge(1, 4);
		directedGraph.addDirectedEdge(2, 4);
		//directedGraph.addDirectedEdge(4, 0);

		System.out.println(detectCycle(directedGraph));
		System.out.println(detectCycle_Iterative(directedGraph));
	}
}
