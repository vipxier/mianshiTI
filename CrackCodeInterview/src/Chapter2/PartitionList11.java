package Chapter2;

import DataStructures.Node;

public class PartitionList11
{
    public static Node partitionTheList(Node root, int value)
    {
        Node beforeListHead = null;
        Node afterListHead = null;
        
        Node beforeCurrentNode = null;
        Node afterCurrentNode = null;
        
        Node currentNode = root;
        
        while(currentNode != null)
        {
            if(currentNode.value < value)
            {
                if(beforeListHead == null)
                {
                    beforeListHead = new Node(currentNode.value);
                    beforeCurrentNode = beforeListHead;
                }
                else
                {
                    beforeCurrentNode.next = new Node(currentNode.value);
                    beforeCurrentNode = beforeCurrentNode.next;
                }
            }
            else
            {
                if(afterListHead == null)
                {
                    afterListHead = new Node(currentNode.value);
                    afterCurrentNode = afterListHead;
                }
                else
                {
                    afterCurrentNode.next = new Node(currentNode.value);
                    afterCurrentNode = afterCurrentNode.next;
                }
            }
            currentNode = currentNode.next;
        }
        
        if(beforeListHead != null && afterListHead != null)
        {
            beforeCurrentNode.next = afterListHead;
            return beforeListHead;
        }
        else if(beforeListHead == null && afterListHead != null)
        {
            return afterListHead;
        }
        else if(beforeListHead != null)
        {
            return beforeListHead;
        }
        return null;
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
        
        System.out.println(Node.outputValues(partitionTheList(head, 3)));
    }
}
