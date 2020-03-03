package PracticeCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class PracticeGraph
{
    Map<Node, List<Node>> map = new HashMap<Node, List<Node>>();

    public void AddNode(int value)
    {
        Node currentNode = new Node(value);
        map.putIfAbsent(currentNode, new ArrayList<Node>());
    }

    public void addEdge(int value1, int value2)
    {
        Node node1 = new Node(value1);
        Node node2 = new Node(value2);

        map.get(node1).add(node2);
        map.get(node2).add(node1);
    }

    public boolean removeEdge(int value1, int value2)
    {
        Node node1 = new Node(value1);
        Node node2 = new Node(value2);

        if (map.containsKey(node1) && map.containsKey(node2))
        {
            map.get(node1).remove(node2);
            map.get(node2).remove(node1);
            return true;
        }
        return false;
    }

    public boolean removeNode(int value)
    {
        Node node = new Node(value);

        if (map.containsKey(node))
        {
            map.values().stream().forEach(e -> e.remove(node));
            map.remove(node);
            return true;
        }

        return false;
    }

    public List<Node> depthFirstTraverse(int value)
    {
        List<Node> result = new ArrayList<Node>();
        Stack<Node> stack = new Stack<Node>();

        if (!map.containsKey(new Node(value)))
        {
            return result;
        }

        stack.push(new Node(value));

        while (!stack.isEmpty())
        {
            Node currentNode = stack.pop();
            if (!result.contains(currentNode))
            {
                result.add(currentNode);
                for (Node node : map.get(currentNode))
                {
                    stack.push(node);
                }
            }
        }
        return result;
    }

    public List<Node> breadthFirstTraverse(int value)
    {
        Queue<Node> queue = new LinkedList<Node>();
        List<Node> result = new ArrayList<Node>();

        if (map.containsKey(new Node(value)))
        {
            queue.add(new Node(value));

            while (!queue.isEmpty())
            {
                Node currentNode = queue.poll();
                for (Node node : map.get(currentNode))
                {
                    if (!result.contains(node))
                    {
                        queue.add(node);
                        result.add(node);
                    }
                }
            }
        }
        return result;
    }

    Set<Node> visitedNode = new HashSet<Node>();

    public void depthFirstTraverse_R(Node node)
    {
        if (!visitedNode.contains(node))
        {
            System.out.println(node.value);
            visitedNode.add(node);
            for (Node neighbor : map.get(node))
            {
                depthFirstTraverse_R(neighbor);
            }
        }
    }
}
