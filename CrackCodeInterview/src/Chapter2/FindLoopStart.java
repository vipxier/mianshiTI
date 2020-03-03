package Chapter2;

import java.util.HashSet;
import java.util.Set;

import DataStructures.Node;

public class FindLoopStart
{
    public static Node findLoopStart(Node root)
    {
        if(root == null)
        {
            return null;
        }
        
        
        Node currentNode = root;
        
        Set<Integer> set = new  HashSet<Integer>();
        
        while(currentNode != null)
        {
            if(set.contains(currentNode.value))
            {
                return currentNode;
            }
            else
            {
                set.add(currentNode.value);
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    
    
    public static void main(String[] args)
    {
        Node node = new Node(1);
        Node node1 = new Node(2);
        node.next = node1;
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(5);
        node2.next = node3;
        Node node4 = new Node(7);
        node3.next = node4;
        Node node5 = new Node(8);
        node4.next = node5;
        Node node6 = new Node(3);
        node5.next = node6;
        Node node7 = new Node(4);
        node6.next = node7;
        Node node8 = new Node(10);
        node7.next = node8;
       node8.next = node7;
        
        System.out.println(findLoopStart(node).value);
        
        
    }
}   
