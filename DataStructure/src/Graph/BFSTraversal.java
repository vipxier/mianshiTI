package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
	public static List<Integer> BFS(Graph graph, int source) {
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.size];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(source);
		visited[source] = true;
		while (!queue.isEmpty()) {
			int parentNode = queue.poll();
			result.add(parentNode);
			for (int neighbor : graph.neighbors[parentNode]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.offer(neighbor);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		Graph graph = new Graph(5);
		
		graph.addUndirectedEdge(1, 0);
		graph.addUndirectedEdge(0, 2);
		graph.addUndirectedEdge(2, 1);
		graph.addUndirectedEdge(0, 3);
		graph.addUndirectedEdge(1, 4);
		
		System.out.println(BFS(graph, 0));
		System.out.println(BFS(graph, 4));
		//System.out.println(DFS_Traversal(graph, 0));
		
	}
}
