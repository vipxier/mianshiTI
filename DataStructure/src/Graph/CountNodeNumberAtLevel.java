package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountNodeNumberAtLevel {
	private class Graph
	{
		int size;
		ArrayList<Integer>[] neighbors;
		
		public Graph(int size)
		{
			this.size = size;
			this.neighbors = new ArrayList[size];
			
			for(int i = 0; i < size; i ++)
			{
				neighbors[i] = new ArrayList<Integer>();
			}
		}
		
		public void AddEdge(int source, int destination)
		{
			neighbors[source].add(destination);
			neighbors[destination].add(source);
		}
		
		public int BFS(int start, int level)
		{
			boolean[] visited = new boolean[size];
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(start);
			
			while(!queue.isEmpty())
			{
				int size = queue.size();
				List<Integer> resultLevelNodes = new ArrayList<Integer>();
				for(int i = 0; i < size; i ++)
				{
					int currentNode = queue.poll();
					visited[currentNode] = true;
					for(Integer num : neighbors[currentNode])
					{
						if(!visited[num])
						{
							resultLevelNodes.add(num);
							queue.offer(num);
						}
					}
				}
				level --;
				if(level == 0)
				{
					return resultLevelNodes.size();
				}
			}
			
			return 0;
		}
	}
	private int size = 0;
	private Graph graph;
	
	public CountNodeNumberAtLevel(int size)
	{
		this.size = size;
		this.graph = new Graph(size);
	}
	
	public Graph getGraph()
	{
		return this.graph;
	}
	
	public static void main(String[] args)
	{
		/**
		 * 7
          0 1
          0 2
          1 3
          1 4 
          1 5
          2 6
          2
		 */
		Graph graph = new CountNodeNumberAtLevel(7).getGraph();
		graph.AddEdge(0, 1);
		graph.AddEdge(0, 2);
		graph.AddEdge(1, 3);
		graph.AddEdge(1, 4);
		graph.AddEdge(1, 5);
		graph.AddEdge(2, 6);
		
		System.out.println(graph.BFS(0, 2));
		
	}
}
