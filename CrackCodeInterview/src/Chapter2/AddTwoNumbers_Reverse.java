package Chapter2;

import DataStructures.Node;

public class AddTwoNumbers_Reverse
{
    public static Node addTwoNumbers_R(Node node1, Node node2)
    {
        if (node1 == null || node2 == null)
        {
            return null;
        }

        node1 = reverse(node1);
        node2 = reverse(node2);
        
        return reverse(addition(node1, node2));

    }

    private static Node addition(Node node1, Node node2)
    {
        Node currentNode1 = node1, currentNode2 = node2, currentResultNode = null, result = null;
        int sum = 0;
        int passingValue = 0;

        while (currentNode1 != null && currentNode2 != null)
        {
            sum = currentNode1.value + currentNode2.value + passingValue;

            if (sum >= 10)
            {
                passingValue = 1;
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
                passingValue = 0;
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
            sum = 0;
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        while (currentNode1 != null)
        {
            sum = currentNode1.value + passingValue;

            if (sum >= 10)
            {
                passingValue = 1;
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
                passingValue = 0;
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
            sum = 0;
            currentNode1 = currentNode1.next;
        }

        while (currentNode2 != null)
        {
            sum = currentNode2.value + passingValue;

            if (sum >= 10)
            {
                passingValue = 1;
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
                passingValue = 0;
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
            sum = 0;
            currentNode2 = currentNode2.next;
        }

        if (passingValue == 1)
        {
            currentResultNode.next = new Node(1);
        }

        return result;
    }

    private static Node reverse(Node root)
    {
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
    
    public static void main(String[] args)
    {
        Node node1 = new Node(9);
        node1.appendToTail(9);
        node1.appendToTail(2);
        
        Node node2 = new Node(1);
        node2.appendToTail(9);
        
        System.out.println(Node.outputValues(addTwoNumbers_R(node1, node2)));
    }
}
