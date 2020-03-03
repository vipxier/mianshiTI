import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import utils.UndirectedGraphNode;

public class SearchInGraph {
	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
            Map<UndirectedGraphNode, Integer> values,
            UndirectedGraphNode node,
            int target) {
	
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		
		Map<UndirectedGraphNode, List<UndirectedGraphNode>> hashMap = new HashMap<>();
		
		for(UndirectedGraphNode graphNode : graph)
		{
			hashMap.put(graphNode, graphNode.neighbors);
		}
		
		queue.offer(node);
		visited.add(node);
		
		while(!queue.isEmpty())
		{
			UndirectedGraphNode graphNode = queue.poll();
			if(values.get(graphNode) == target)
			{
				return graphNode;
			}
			
			for(UndirectedGraphNode neighbor : graphNode.neighbors)
			{
				if(!visited.contains(neighbor))
				{
					queue.offer(neighbor);
					visited.add(neighbor);
				}
			}
		}
		
		return null;
	}
}
