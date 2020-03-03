package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphClone
{
    Map<Node, List<Node>> map = new HashMap<Node, List<Node>>();

    public Node cloneGraph(Node node)
    {
        if (node == null)
        {
            return null;
        }
        Node currentNode = node;

        Stack<Node> stack = new Stack<Node>();
        stack.push(node);

        while (!stack.isEmpty())
        {
            currentNode = stack.pop();
            if(!map.containsKey(currentNode))
            {
                map.put(currentNode, new ArrayList<Node>());
            }
            
            for (Node neighbor : currentNode.neighbors)
            {
                if (map.containsKey(neighbor))
                {
                    map.get(neighbor).add(currentNode);
                }
                else
                {
                    map.put(neighbor, new ArrayList<Node>());
                    stack.push(neighbor);
                }
            }
        }
        return node;
    }
}
