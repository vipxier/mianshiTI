import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import utils.DirectedGraphNode;

public class TopLogicalSort {
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		if(graph == null && graph.size() == 0)
		{
			return result;
		}
		
		Map<DirectedGraphNode, Integer> hashMap = new HashMap<DirectedGraphNode, Integer>();
		
		for(DirectedGraphNode node : graph)
		{
			if(hashMap.containsKey(node))
			{
				hashMap.put(node, hashMap.get(node) + 1);
			}
			else
			{
				hashMap.put(node, 1);
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
			DirectedGraphNode currentNode = queue.poll();
			
			for(DirectedGraphNode neighbor : currentNode.neighbors)
			{
				hashMap.put(neighbor, hashMap.get(neighbor) - 1);
				if(hashMap.get(neighbor) == 0)
				{
					queue.offer(neighbor);
					result.add(neighbor);
				}
			}
		}
		
		return result;
	}
}
