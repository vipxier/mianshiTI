package Chapter4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DirectedGraph
{
    Map<Vertex, LinkedList<Vertex>> adjcentMap;
    
    public DirectedGraph()
    {
        adjcentMap = new HashMap<Vertex, LinkedList<Vertex>>();
    }
    
    public void addVertex(String label)
    {
        adjcentMap.putIfAbsent(new Vertex(label), new LinkedList<Vertex>());
    }
    
    public void addEdge(String label1, String label2) {
        adjcentMap.get(new Vertex(label1)).add(new Vertex(label2));
    }
    
    public void removeVertex(String label)
    {
        adjcentMap.remove(new Vertex(label));
    }
    
    public void removeEdge(String label1, String label2)
    {
        adjcentMap.get(new Vertex(label1)).remove(new Vertex(label2));
    }
    
    public Map<Vertex, LinkedList<Vertex>> getMap()
    {
        return adjcentMap;
    }
}
