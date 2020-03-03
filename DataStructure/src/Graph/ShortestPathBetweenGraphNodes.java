package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestPathBetweenGraphNodes {
	public int shortestPath(List<GraphNode> nodes, GraphNode start, GraphNode destination)
	{
		Set<GraphNode> visited = new HashSet<GraphNode>();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		
		queue.offer(start);
		int minPathCount = Integer.MAX_VALUE;
		int currentLayer = 0;
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			currentLayer++;
			for(int i = 0; i < size; i ++)
			{
				GraphNode gn = queue.poll();
				visited.add(gn);
				for(GraphNode neighbor : gn.neighbors)
				{
					if(neighbor == destination)
					{
						System.out.println("Fid target at " + (currentLayer + 1));
						minPathCount = Math.min(minPathCount, (currentLayer + 1));
						break;
					}
					
					if(!visited.contains(neighbor))
					{
						queue.offer(neighbor);
					}
				}
			}
		}
		
		return minPathCount;
	}
	
	public static void main(String[] args)
	{
		ShortestPathBetweenGraphNodes solution = new ShortestPathBetweenGraphNodes();
		String[] strings = new String[] { "0,1 2 8", "1,3", "2,1 4 7", "3, 2 5", "4,3 5", "5,6", "6,7", "7,4", "8,2" };
		List<GraphNode> nodes = CreateGraph.crateGraph(strings);
		
		System.out.println(solution.shortestPath(nodes, nodes.get(0), nodes.get(3)));
	}
}
