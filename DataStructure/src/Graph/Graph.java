package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Graph {
	private int size;
	private ArrayList<Integer>[] nodes;

	public Graph(int size) {
		this.size = size;
		this.nodes = new ArrayList[size];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public ArrayList<Integer>[] getNodes(){
		return this.nodes;
	}

	public void addEdge(int source, int destination) {
		if (source <= size - 1) {
			this.nodes[source].add(destination);
			this.nodes[destination].add(source);
		}
	}

	public void printGraph() {
		for (int i = 0; i < size; i++) {
			System.out.println("Graph node " + i + " neighbor: ");
			for (Integer neighbor : nodes[i]) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}

	public void BFS(int startNode) {
		boolean[] visited = new boolean[size];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[startNode] = true;
		queue.add(startNode);
		System.out.print(startNode + " ");
		while (!queue.isEmpty()) {
			int node = queue.poll();
			if (!visited[node]) {
				System.out.print(node + " ");
			}

			for (Integer neighbor : nodes[node]) {
				if (!visited[neighbor]) {
					queue.offer(neighbor);
				}
			}
			visited[node] = true;
		}
	}

	public void DFS(int startNode) {
		boolean[] visited = new boolean[size];
		DepthFirstSearchTraversal(visited, nodes, startNode);
	}

	private void DepthFirstSearchTraversal(boolean[] visited, ArrayList<Integer>[] nodes, int node) {
		System.out.print(node + " ");
		visited[node] = true;

		for (Integer neighbor : nodes[node]) {
			if (!visited[neighbor]) {
				DepthFirstSearchTraversal(visited, nodes, neighbor);
			}
		}

	}

	public boolean checkCycle() {
		boolean[] visited = new boolean[size];
		return DFSTraversal(visited, nodes, 0);
	}

	private boolean DFSTraversal(boolean[] visited, ArrayList<Integer>[] nodes, int startNode) {
		visited[startNode] = true;
		for (Integer neighbor : nodes[startNode]) {
			if (visited[neighbor] && neighbor != startNode) {
				return true;
			} 
			else {
				System.out.print(neighbor + " ");
				return DFSTraversal(visited, nodes, neighbor);
			}
		}
		return false;
	}
	
	

	public static void main(String args[]) {
		// create the graph given in above figure
		int V = 5;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// print the adjacency list representation of
		// the above graph
		System.out.println("BFS: ");
		graph.printGraph();
		graph.BFS(2);
		System.out.println();
		System.out.println("DFS: ");
		graph.DFS(2);

		System.out.println();
		System.out.println("Check Cycle: ");
		if (graph.checkCycle()) {
			System.out.println("Cycle Exists!");
		} else {
			System.out.println("No cycle found");
		}
	}
}
