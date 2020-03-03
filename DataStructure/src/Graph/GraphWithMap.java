package Graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphWithMap
{
    Map<Vertex, List<Vertex>> adjVertices;

    public GraphWithMap(String label)
    {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void addVertex(String label)
    {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public Vertex removeVertex(String label)
    {
        Vertex temp = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(temp));
        adjVertices.remove(new Vertex(label));
        return temp;
    }
    
    public void addEdge(String label1, String label2)
    {
        adjVertices.get(new Vertex(label1)).add(new Vertex(label2));
        adjVertices.get(new Vertex(label2)).add(new Vertex(label1));
    }
    
    public void removeEdge(String label1, String label2)
    {
        adjVertices.get(new Vertex(label1)).remove(new Vertex(label2));
        adjVertices.get(new Vertex(label2)).remove(new Vertex(label1));
    }
    
    public List<Vertex> getAdjVertices(String label)
    {
        return adjVertices.get(new Vertex(label));
    }

    public Set<String> depthFirstTraverse(GraphWithMap graph, String label)
    {
        Set<String> visitedVertices = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(label);

        while (!stack.isEmpty())
        {
            String v = stack.pop();
            if (!visitedVertices.contains(v))
            {
                visitedVertices.add(v);
                for (Vertex temp : graph.getAdjVertices(label))
                {
                    stack.push(temp.label);
                }
            }
        }
        return visitedVertices;
    }
}
