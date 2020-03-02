package OA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CriticalEdges {
	
	private class Graph
	{
		int size;
		Set<Integer>[] neighbors;
		
		public Graph(int size)
		{
			this.size = size;
			neighbors = new HashSet[size];
			for(int i = 0; i < size; i ++)
			{
				neighbors[i] = new HashSet<Integer>();
			}
		}
		
		public void addEdge(int source, int destination)
		{
			this.neighbors[source].add(destination);
			this.neighbors[destination].add(source);
		}
		
		public void removeEdge(int source, int destination)
		{
			this.neighbors[source].remove(destination);
			this.neighbors[destination].remove(source);
		}
		
	}
	public List<int[]> getCriticalEdges(int numNodes, int numEdges, int[][] edges)
	{
		List<int[]> result = new ArrayList<int[]>();
		if(edges == null || edges.length == 0 || edges[0].length == 0 || numEdges != edges.length)
		{
			return result;
		}
		
		Graph graph = new Graph(numNodes);
		
		for(int edgeIndex = 0; edgeIndex < edges.length; edgeIndex ++)
		{
			graph.addEdge(edges[edgeIndex][0], edges[edgeIndex][1]);
		}
		
		for(int index = 0; index < edges.length; index ++)
		{
			graph.removeEdge(edges[index][0], edges[index][1]);
			int nodeCount = BFSToFindNodes(graph, 0);
			if(nodeCount != numNodes)
			{
				result.add(edges[index]);
			}
			graph.addEdge(edges[index][0], edges[index][1]);
		}
		
		return result;
	} 
	
	private int BFSToFindNodes(Graph graph, int start)
	{
		int nodeCount = 0;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.size];
		queue.offer(start);
		while(!queue.isEmpty())
		{
			int currentNode = queue.poll();
			
			if(!visited[currentNode])
			{
				nodeCount ++;
				visited[currentNode] = true;
			}
			
			for(int neighbor : graph.neighbors[currentNode])
			{
				if(!visited[neighbor])
				{
					queue.offer(neighbor);
				}
			}
		}
		return nodeCount;
	}
	
	public static void main(String[] args)
	{
		int[][] edges = new int[][] {{0,1},{1,2},{2,0},{1,3}};
		CriticalEdges solution = new CriticalEdges();
		System.out.println(solution.getCriticalEdges(4,4,edges));
	}                                             
}
