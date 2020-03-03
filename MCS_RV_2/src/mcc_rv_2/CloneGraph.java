package mcc_rv_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
	public static UndirectedGraphNode solution(UndirectedGraphNode node)
	{
		List<UndirectedGraphNode> nodes = getNodes(node);
		
		HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();
		
		for(UndirectedGraphNode currentNode : nodes)
		{
			hashMap.put(currentNode, new UndirectedGraphNode(currentNode.label));
		}
		
		for(UndirectedGraphNode currentNode : nodes)
		{
			UndirectedGraphNode newNode = hashMap.get(currentNode);
			for(UndirectedGraphNode neighbor : currentNode.neighbors)
			{
				newNode.neighbors.add(hashMap.get(neighbor));
			}
		}
		
		return hashMap.get(node);
			
	}
	
	private static ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node)
	{
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		
		queue.offer(node);
		visited.add(node);
		
		while(!queue.isEmpty())
		{
			UndirectedGraphNode currentNode  =queue.poll();
			
			for(UndirectedGraphNode neighbor : currentNode.neighbors)
			{
				if(!visited.contains(neighbor));
				{
					queue.offer(neighbor);
					visited.add(neighbor);
				}
			}
			
		}
		return new ArrayList<UnidrectedGraphNode>(visited);
	}
}
