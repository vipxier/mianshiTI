package Chapter2;

import DataStructures.Node;

public class CheckPalindrom
{
    public static boolean arePalindrom(Node node1, Node node2)
    {
        if(node1 == null || node2 == null)
        {
            return false;
        }
        
        Node currentNode1 = reverse(node1);
        Node currentNode2 = node2;
        
        while(currentNode1 != null && currentNode2 != null)
        {
            if(currentNode1.value != currentNode2.value)
            {
                return false;
            }
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }
        
        if(currentNode1 != null || currentNode2 != null)
        {
            return false;
        }
        
        return true;         
    }
    
    private static Node reverse(Node root)
    {
        if(root.next  == null)
        {
            return root;
        }
        
        Node currentNode = root;
        Node prevNode = null;
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
    
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        node1.appendToTail(2);
        node1.appendToTail(3);
        node1.appendToTail(4);
        node1.appendToTail(5);
        
        Node node2 = new Node(5);
        node2.appendToTail(4);
        node2.appendToTail(3);
        node2.appendToTail(2);
        node2.appendToTail(1);
        
        Node node3 = new Node(5);
        node3.appendToTail(4);
        node3.appendToTail(3);
        node3.appendToTail(2);
        
        
        Node node4 = new Node(5);
        node4.appendToTail(4);
        node4.appendToTail(4);
        node4.appendToTail(2);
        node4.appendToTail(1);
        
        Node node5 = null;
        
        System.out.println(arePalindrom(node1, node2));
        
        System.out.println(arePalindrom(node1, node3));
        System.out.println(arePalindrom(node1, node4));
        System.out.println(arePalindrom(node1, node5));
    }
}
