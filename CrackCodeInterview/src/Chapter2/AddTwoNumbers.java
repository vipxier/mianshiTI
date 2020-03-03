package Chapter2;

import DataStructures.Node;

public class AddTwoNumbers
{
    public static Node addition(Node node1, Node node2)
    {
        Node result = null;
        
        if(node1 == null || node2 == null)
        {
            return result;
        }
        
        Node currentNode1 = node1;
        Node currentNode2 = node2;
        Node currentResultNode = null;
        
        int sum = 0;
        int additionValue = 0;
        
        while(currentNode1 != null && currentNode2 != null)
        {
            sum = currentNode1.value + currentNode2.value + additionValue;
            if(sum >= 10)
            {
                additionValue = 1;
                if (result == null)
                {
                    result = new Node(sum % 10);
                    currentResultNode = result;
                }
                else
                {
                    currentResultNode.next = new Node(sum % 10);
                    currentResultNode = currentResultNode.next;
                }
            }
            else
            {
                additionValue = 0;
                if (result == null)
                {
                    result = new Node(sum);
                    currentResultNode = result;
                }
                else
                {
                    currentResultNode.next = new Node(sum);
                    currentResultNode = currentResultNode.next;
                }
            }
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
            
            sum = 0;
        }
        
        if(additionValue == 1)
        {
            currentResultNode.next = new Node(1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        Node node1 = new Node(9);
        node1.appendToTail(9);
        node1.appendToTail(3);
        
        Node node2 = new Node(9);
        node2.appendToTail(4);
        node2.appendToTail(9);
        
        System.out.println(Node.outputValues(addition(node1, node2)));
        
    }
}
