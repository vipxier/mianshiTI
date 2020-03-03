package DataStructures;

public class Node
{
    public int value;
    public Node next;

    public Node(int value)
    {
        this.value = value;
        this.next = null;
    }

    public  void appendToTail(int value)
    {
        Node end = new Node(value);
        
        Node n = this;
        
        while(n.next != null)
        {
            n = n.next;
        }
        
        n.next = end;
    }

    public static String outputValues(Node root)
    {
        StringBuilder strb = new StringBuilder();
        Node currentNode = root;
        while (currentNode != null)
        {
            strb.append(currentNode.value).append(" ");
            currentNode = currentNode.next;
        }
        return strb.toString();
    }
}
