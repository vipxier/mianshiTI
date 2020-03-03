package Chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GetTreeNeighor
{
    public static TreeNode getNeighbor(TreeNode root, int value)
    {
        if (root == null || root.value == value)
        {
            return null;
        }
        
        TreeNode node = null;
        TreeNode prevNode = null;

        Stack<TreeNode> currentLayerStack = new Stack<TreeNode>();
        Stack<TreeNode> nextLayerStack = new Stack<TreeNode>();

        currentLayerStack.push(root);
        while (!currentLayerStack.isEmpty() || !nextLayerStack.isEmpty())
        {
            node = null;
            while (!currentLayerStack.isEmpty())
            {
                if(node != null)
                {
                    prevNode = node;
                }
                node = currentLayerStack.pop();
                if(node != null && node.value != value)
                {
                    nextLayerStack.push(node.left);
                    nextLayerStack.push(node.right);
                    
                }
                else if(node != null && node.value == value)
                {
                     if(currentLayerStack.isEmpty())
                    {
                        return prevNode;
                    }
                    else
                    {
                        return currentLayerStack.pop();
                    }
                }
            }
            
            node = null;
            while(!nextLayerStack.isEmpty())
            {
                if(node != null)
                {
                    prevNode = node;
                }
                node = nextLayerStack.pop();
                if(node != null && node.value != value)
                {
                    currentLayerStack.push(node.right);
                    currentLayerStack.push(node.left);
                }
                else
                {
                    if(nextLayerStack.isEmpty())
                    {
                        return prevNode;
                    }
                    else
                    {
                        return nextLayerStack.pop();
                    }
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.insert(3);
        root.insert(7);
        root.insert(2);
        root.insert(4);
        root.insert(6);
        root.insert(10);
        
        TreeNode node = getNeighbor(root, 2);
        if(node != null) {
        System.out.println(node.value);
        }
        else
        {
            System.out.println("Not found");
        }
        
    }
}
