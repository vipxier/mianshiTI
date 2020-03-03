package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphwithList
{
    int size;
    LinkedList<Integer> neighbors[];
    boolean[] visited;

    @SuppressWarnings("unchecked")
    public GraphwithList(int size)
    {
        this.size = size;

        neighbors = new LinkedList[size];
        visited = new boolean[size];

        for (int i = 0; i < size; i++)
        {
            neighbors[i] = new LinkedList<Integer>();
        }
    }

    public boolean addEdge(int src, int des)
    {
        if (des < size && src < size)
        {
            neighbors[src].add(des);
            return true;
        }
        return false;
    }

    public boolean removeEdge(int src, int des)
    {
        if (src < size && des < size)
        {
            neighbors[src].remove(des);
            return true;
        }

        return false;
    }

    public List<Integer> dpt(int start)
    {
        List<Integer> result = new LinkedList<Integer>();
        if (start < 0 || start > size)
        {
            return result;
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);

        while (!stack.isEmpty())
        {
            if (!visited[start])
            {
                visited[start] = true;
                result.add(start);
            }
            
            for(int item : neighbors[start])
            {
                if (!visited[item])
                {
                    visited[item] = true;
                    stack.push(item);
                }
            }
        }
        return result;
    }

}
