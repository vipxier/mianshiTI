package OA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CriticalRouter {
	/**
	 * The input to the function/method consists of three arguments:
		numNodes, an integer representing the number of nodes in the graph.
		numEdges, an integer representing the number of edges in the graph.
		edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
	 */
	private class Graph
	{
		int size;
		Set<Integer>[] neighbors;
		
		public Graph(int size)
		{
			this.size = size;
			this.neighbors = new HashSet[size];
			
			for(int i = 0; i < size; i ++)
			{
				this.neighbors[i] = new HashSet<Integer>();
			}
		}
		
		public void addEdge(int source, int destination)
		{
			this.neighbors[source].add(destination);
			this.neighbors[destination].add(source);
		}
	}
	
	public List<Integer> criticalRouter(int numNodes, int numEdges, int[][] edges)
	{
		List<Integer> result = new ArrayList<Integer>();
		
		if(numNodes <= 0 && numEdges <= 0 || edges == null || edges.length == 0 || edges[0].length == 0)
		{
			return result;
		}
		
		for(int nodeIndex = 0; nodeIndex < numNodes; nodeIndex ++)
		{
			Graph graph = new Graph(numNodes);
			for(int edgeIndex = 0; edgeIndex < numEdges; edgeIndex ++)
			{
				if(edges[edgeIndex][0] == nodeIndex || edges[edgeIndex][1] == nodeIndex)
				{
					continue;
				}
				
				graph.addEdge(edges[edgeIndex][0], edges[edgeIndex][1]);
			}
			
			
			int startNode = 0;
			
			if(nodeIndex == 0)
			{
				startNode = numNodes - 1;
			}
			else
			{
				startNode = nodeIndex - 1;
			}
			int nodeCount = BFSToFindCount(graph, startNode);
			
			if(nodeCount != numNodes - 1)
			{
				result.add(nodeIndex);
			}
		}
		
		return result;
	}
	
	private int BFSToFindCount(Graph graph, int startNode)
	{
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.size];
		queue.offer(startNode);
		int nodeCounter = 0;
		while(!queue.isEmpty())
		{
			int currentNode = queue.poll();
			if(!visited[currentNode])
			{
				nodeCounter ++;
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
		
		return nodeCounter;
	}
	
	public static void main(String[] args)
	{
		int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
		CriticalRouter solution = new CriticalRouter();
		System.out.println(solution.criticalRouter(7, 7, edges));
	}
}
