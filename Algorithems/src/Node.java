
public class Node {
	int value;
	Node next;
	
	public Node(int value)
	{
		this.value = value;
		this.next = null;
	}
	
	public void appendToTail(int value)
	{
		Node currentNode = this;
		while(currentNode.next != null)
		{
			currentNode = currentNode.next;
		}
		
		currentNode.next = new Node(value);
	}
	
	public Node deleteNode(Node head, int value)
	{
		if(head.value == value)
		{
			return head.next;
		}
		
		Node currentNode = head;
		Node prevNode = null;
		while(currentNode != null)
		{
			if(currentNode.value == value)
			{
				prevNode.next = currentNode.next;
				return head;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		return head;
	}
	
	public String printAllNodes()
	{
		Node currentNode = this;
		StringBuilder strb = new StringBuilder();
		while(currentNode != null)
		{
			strb.append(currentNode.value).append(" ");
			currentNode = currentNode.next;
		}
		return strb.toString();
	}
}
