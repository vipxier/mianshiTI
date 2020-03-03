package Chapter4;

import java.util.Stack;

public class CheckPathInDirectedGraph
{
    public static boolean checkPathInGraph(DirectedGraph graph, String label1, String label2)
    {
        if (graph.getMap().containsKey(new Vertex(label1)))
        {
            Stack<Vertex> stack = new Stack<Vertex>();
            for (Vertex v : graph.getMap().get(new Vertex(label1)))
            {
                if (v == new Vertex(label2))
                {
                    return true;
                }
                else
                {
                    stack.push(v);
                }
            }

            while (!stack.isEmpty())
            {
                Vertex vertex = stack.pop();
                if (vertex == new Vertex(label2))
                {
                    return true;
                }
                else
                {
                    for (Vertex ve : graph.getMap().get(vertex))
                    {
                        stack.push(ve);
                    }
                }
            }
        }
        return false;
    }
}
