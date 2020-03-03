package PracticeCode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Graph.Vertex;

public class GraphPractice {
	private Map<Vertex, List<Vertex>> map;
	
	
	public void addVertex(String label)
	{
		map.putIfAbsent(new Vertex(label), new ArrayList<Vertex>());
	}
	
	public void addEdge(String label1, String label2)
	{
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		
		map.get(v1).add(v2);
		map.get(v2).add(v1);
	}
	
	public void deleteEdge(String label1, String label2)
	{
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}
	
	public Vertex deleteVertex(String label)
	{
		Vertex v = new Vertex(label);
		
		map.values().stream().forEach(e->e.remove(v));
		map.remove(v);
		return v;
	}
	
	public Set<Vertex> depthFirstSearch(String label)
	{
		Vertex root = new Vertex(label);
		Set<Vertex> visitedVertices = new LinkedHashSet<Vertex>();
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			Vertex currentVertex = stack.pop();
			if(!visitedVertices.contains(currentVertex))
			{
				visitedVertices.add(currentVertex);
				for(Vertex v: map.get(currentVertex))
				{
					stack.push(v);
				}
			}
		}
		return visitedVertices;
	}
	
	
	public Set<Vertex> breadthFirstSearch(String label)
	{
		Vertex root = new Vertex(label);
		Queue<Vertex> queue = new LinkedList<Vertex>();
		Set<Vertex> visitedVertex = new LinkedHashSet<Vertex>();
		
		queue.add(root);
		while(!queue.isEmpty())
		{
			Vertex currentVertex = queue.poll();
			for(Vertex v: map.get(currentVertex))
			{
				if(!visitedVertex.contains(currentVertex))
				{
					visitedVertex.add(currentVertex);
					queue.add(v);
				}
				
			}
			
			
		}
		return visitedVertex;
	}
	
}
