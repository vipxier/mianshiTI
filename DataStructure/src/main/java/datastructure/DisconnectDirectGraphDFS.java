package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DisconnectDirectGraphDFS {
	
	public static List<Integer> DFS_iterative(Graph graph)
	{
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.size];
		for(int i = 0; i < graph.size; i ++)
		{
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(i);
			
			while(!stack.isEmpty())
			{
				int parent = stack.pop();
				if(!visited[parent])
				{
					visited[parent] = true;
					result.add(parent);
				}
				
				for(int neighbor : graph.neighbors[parent])
				{
					if(!visited[neighbor])
					{
						stack.push(neighbor);
					}
				}
			}
		}
		return result;
	}
	
	public static List<Integer> DFS(Graph graph)
	{
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.size];
		for(int i = 0; i < graph.size; i ++)
		{
			if(!visited[i])
			{
				DFSUtil(result, graph, i, visited);
			}
		}
		
		return result;
	}
	
	private static void DFSUtil(List<Integer> result, Graph graph, int start, boolean[] visited)
	{
		if(!visited[start])
		{
			result.add(start);
			visited[start] = true;
		}
		
		for(int neighbor : graph.neighbors[start])
		{
			if(!visited[neighbor]) {
				DFSUtil(result, graph, neighbor, visited);
			}
		}
	}
	
	public static void main(String[] args)
	{
		 	int vertices = 7;
	        Graph graph = new Graph(vertices);
	        graph.addDirectedEdge(1,3);
	        graph.addDirectedEdge(2,3);
	        graph.addDirectedEdge(0,4);
	        graph.addDirectedEdge(4,5);
	        graph.addDirectedEdge(5,6);
	        
	        System.out.println(DFS(graph));
	        
	        System.out.println(DFS_iterative(graph));
	}
}
