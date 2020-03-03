package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
	public static List<Integer> BFS(Graph graph, int start)
	{
		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> queue= new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.size];
		
		queue.offer(start);
		
		while(!queue.isEmpty())
		{
			int parent = queue.poll();
			if(!visited[parent]) {
				result.add(parent);
				visited[parent] = true;
			}
			for(int neighbor : graph.neighbors[parent])
			{
				if(!visited[neighbor])
				{
					queue.offer(neighbor);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		// graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);

		System.out.println(BFS(graph, 0));
	}
}
