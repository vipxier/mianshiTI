package ReviewQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CriticalEdgeOfGraph {
	private class Graph
	{
		int size;
		List<Integer>[] edges;
		
		public Graph(int size)
		{
			this.size = size;
			this.edges = new ArrayList[size];
			
			for(int i = 0; i < size; i ++)
			{
				edges[i] = new ArrayList<Integer>();
			}
		}
		
		public void addEdge(int source, int destination)
		{
			this.edges[source].add(destination);
			this.edges[destination].add(source);
		}
		
		public void removeEdge(int source, int destination)
		{
			this.edges[source].remove(destination);
			this.edges[destination].remove(source);
		}
		
	}
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> criticalEdges = new ArrayList<>();
		if(connections == null || connections.size() == 0)
		{
			return criticalEdges;
		}
		
		Graph graph = new Graph(n);
		for(List<Integer> connection : connections)
		{
			graph.addEdge(connection.get(0), connection.get(1));
		}
		
		for(List<Integer> connection : connections)
		{
			graph.removeEdge(connection.get(0), connection.get(1));
			if(BFSToFindNodeCount(graph, 0) != n)
			{
				criticalEdges.add(connection);
			}
			graph.addEdge(connection.get(0), connection.get(1));
		}
		return criticalEdges;
	}
	
	private int BFSToFindNodeCount(Graph graph, int startNode)
	{
		int nodeCount = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.size];
		
		queue.offer(startNode);
		
		while(!queue.isEmpty())
		{
			int node = queue.poll();
			if(!visited[node])
			{
				nodeCount ++;
				visited[node] = true;
			}
			
			for(int neighbor : graph.edges[node])
			{
				if(!visited[neighbor])
				{
					queue.offer(neighbor);
					
				}
			}
		}
		return nodeCount;
		
	}
}
