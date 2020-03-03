package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {
	public static List<Integer>DFS(Graph graph, int source)
	{
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.size];
		
		DFSUtil(result, visited, graph, source);
		return result;
	}
	
	private static void DFSUtil(List<Integer> result, boolean[] visited, Graph graph, int source)
	{
		visited[source] = true;
		result.add(source);
		
		for(int neighbor : graph.neighbors[source])
		{
			if(!visited[neighbor])
			{
				DFSUtil(result, visited, graph, neighbor);
			}
		}
	}
	
	public static List<Integer> DFS_Traversal(Graph graph, int source)
	{
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.size];
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(source);
		
		while(!stack.isEmpty())
		{
			int parentNode = stack.pop();
			if(!visited[parentNode])
			{
				result.add(parentNode);
				visited[parentNode] = true;
			}
			for(int neighbor : graph.neighbors[parentNode])
			{
				if(!visited[neighbor])
				{
					stack.push(neighbor);
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
		
		System.out.println(DFS(graph, 0));
		System.out.println(DFS_Traversal(graph, 0));
		
	}
}
