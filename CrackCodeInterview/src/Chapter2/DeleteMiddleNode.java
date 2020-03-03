package Chapter2;

import DataStructures.Node;

public class DeleteMiddleNode
{
    public static void deleteMiddleNode(Node root)
    {
        int sizeOfList = sizeOfList(root);
        
        int locationOfMiddleNode = (sizeOfList - 1) / 2;
        Node currentNode = root;
        Node prevNode = null;
        for(int i = 0; i < locationOfMiddleNode; i ++)
        {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        
        System.out.println(prevNode.value);
        prevNode.next = currentNode.next;
        System.out.println(prevNode.next.value);
    }
    
    
    private static int sizeOfList(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        
        Node currentNode = root;
        int count = 1;
        
        while(currentNode != null)
        {
            currentNode = currentNode.next;
            count++;
        }
        
        return count;
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
        
        deleteMiddleNode(head);
        System.out.println(Node.outputValues(head));
    }
}
