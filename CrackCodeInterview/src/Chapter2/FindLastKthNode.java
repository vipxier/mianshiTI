package Chapter2;

import java.util.ArrayList;
import java.util.List;

import DataStructures.Node;

public class FindLastKthNode
{
    public static Node findLastKth(Node root, int index)
    {
        if (root == null || index < 0)
        {
            return null;
        }
        Node currentNode = root;
        List<Integer> list = new ArrayList<Integer>();
        while (currentNode != null)
        {
            list.add(currentNode.value);
            currentNode = currentNode.next;
        }

        if (list.size() < index)
        {
            return null;
        }

        return new Node(list.get(list.size() - 1 - index));
    }
    
    
    public static Node reverseLinkedList(Node root)
    {
        if(root == null)
        {
            return null;
        }
        
        if(root.next == null)
        {
            return root;
        }
        
        Node prevNode = null;
        Node currentNode = root;
        Node nextNode = root;
        
        while(currentNode != null)
        {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        
        return prevNode;
    }
    
    
    public static Node RemoveKthFromBehind(Node root, int kth)
    {
        if(root == null)
        {
            return null;
        }
        
       Node currentNode = reverseLinkedList(root);
       for(int i = 1; i < kth; i ++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    
    
    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(12);
        head.appendToTail(3);
        head.appendToTail(1);
        head.appendToTail(12);
        head.appendToTail(2);
        
        System.out.println(Node.outputValues(head));
        //System.out.println(Node.outputValues(reverseLinkedList(head)));
        System.out.println(RemoveKthFromBehind(head, 5).value);
        
    }
}
