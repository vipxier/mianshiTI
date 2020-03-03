package Graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Graph1 {
	private Map<Vertex, List<Vertex>> adjVertices;
	
	public void addVertex(String label)
	{
		adjVertices.putIfAbsent(new Vertex(label), new ArrayList<Vertex>());
	}
	
	public void removeVertex(String label)
	{
		Vertex v = new Vertex(label);
		adjVertices.values().stream().forEach(e -> e.remove(v));
		adjVertices.remove(new Vertex(label));
	}
	
	public void removeEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		adjVertices.get(v1).remove(v2);
		adjVertices.get(v2).remove(v1);
	}
	
	public static Set<String> depthFirstTraversal(Graph1 graph, String root)
	{
		Set<String> visited = new LinkedHashSet<String>();
		Stack<String> stack = new Stack<String>();
		
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			String vertex = stack.pop();
			
			if(!visited.contains(vertex))
			{
				visited.add(vertex);
				for(Vertex v: graph.adjVertices.get(new Vertex(vertex)))
				{
					stack.push(v.label);
				}
			}
		}
		return visited;
	}
	
	public Set<String> breadthFirstSearch(Graph1 graph, String root)
	{
		Queue<String> queue = new LinkedList<String>();
		Set<String> result = new LinkedHashSet<String>();
		
		result.add(root);
		queue.add(root);
	
		while(!queue.isEmpty())
		{
			String vertex = queue.poll();
			for(Vertex v: graph.adjVertices.get(new Vertex(vertex)))
			{
				if(!result.contains(vertex))
				{
					result.add(v.label);
					queue.add(v.label);
				}
				
			}
		}
		return result;
	}
}
