package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Topological_Sorting {
	public List<DirectedGraphNode> topologicalSort(ArrayList<DirectedGraphNode> graph)
	{
		List<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		if(graph == null || graph.size() == 0)
		{
			return result;
		}
		
		Map<DirectedGraphNode, Integer> hashMap = new HashMap<DirectedGraphNode, Integer>();
		for(DirectedGraphNode node : graph)
		{
			for(DirectedGraphNode neighbor : node.neighbors)
			{
				if(!hashMap.containsKey(neighbor))
				{
					hashMap.put(neighbor, 1);
				}
				else
				{
					hashMap.put(neighbor, hashMap.get(neighbor) + 1);
				}
			}
		}
		
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node : graph)
		{
			if(!hashMap.containsKey(node))
			{
				queue.offer(node);
				result.add(node);
			}
		}
		
		while(!queue.isEmpty())
		{
			DirectedGraphNode node = queue.poll();
			hashMap.put(node, hashMap.get(node) - 1);
			if(hashMap.get(node) == 0)
			{
				queue.offer(node);
				result.add(node);
			}
		}
		
		return result;
	}
}
