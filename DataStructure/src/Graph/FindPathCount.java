package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Utils.ListUtils;

public class FindPathCount {
	private static int counter = 0;
	public static int findPathCount(List<GraphNode> nodes, GraphNode start, GraphNode end)
	{
		if(nodes == null || nodes.size() == 0)
		{
			return 0;
		}
		
		List<GraphNode> visited = new ArrayList<>();
		DFS(start, end, nodes, visited);
		return counter;
	}
	
	private static void DFS(GraphNode start, GraphNode end, List<GraphNode> nodes, List<GraphNode> visited)
	{
		visited.add(start);
		for(GraphNode neighbor : start.neighbors)
		{
			if(neighbor == end)
			{
				System.out.println("FindPath: ");
				ListUtils.printGraphNodeList(visited);
				counter ++;
				return;
			}
			
			if(!visited.contains(neighbor))
			{
				DFS(neighbor, end, nodes, visited);
				visited.remove(visited.size() - 1);
			}
		}
	}
	
	public static void main(String[] args)
	{
		String[] strings = new String[] { "0,1 2 8", "1,3", "2,1 4 7", "3, 2 5", "4,3 5", "5,6", "6,7", "7,4", "8,2" };

		List<GraphNode> nodes = CreateGraph.crateGraph(strings);
		
		System.out.println("Total pathes : " + findPathCount(nodes, nodes.get(0), nodes.get(7)));
	}
	
	
}
