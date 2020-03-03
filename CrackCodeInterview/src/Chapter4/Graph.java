package Chapter4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph
{
    Map<Vertex, LinkedList<Vertex>> adjVertexMap;

    public Graph(int v)
    {
        adjVertexMap = new HashMap<Vertex, LinkedList<Vertex>>();
    }

    public void addVertex(String label)
    {
        adjVertexMap.put(new Vertex(label), new LinkedList<Vertex>());
    }

    public void addEdge(String label1, String label2)
    {
        adjVertexMap.get(new Vertex(label1)).add(new Vertex(label2));
        adjVertexMap.get(new Vertex(label2)).add(new Vertex(label1));
    }

    public void removeVertex(String label)
    {
        adjVertexMap.values().stream().forEach(e -> e.remove(new Vertex(label)));
        adjVertexMap.remove(new Vertex(label));
    }
    
    public void removeEdge(String label1, String label2)
    {
        adjVertexMap.get(new Vertex(label1)).remove(new Vertex(label2));
        adjVertexMap.get(new Vertex(label2)).remove(new Vertex(label1));
    }

}
