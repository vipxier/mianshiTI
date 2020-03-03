package Chapter2;

public class Question6AddForwardOrder {
	public static Node reverse(Node head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		Node prevNode = null;
		Node currentNode = head;
		Node nextNode = head.next;
		
		while(currentNode != null)
		{
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		
		return prevNode;
	}
	
	public static Node addForward(Node head1, Node head2)
	{
		if(head1 == null || head2 == null)
		{
			return null;
		}
		
		head1 = reverse(head1);
		head2 = reverse(head2);
		
		Node result = Question5AddLinkList.add(head1, head2);
		return reverse(result);
	}
	
	public static void main(String[] args)
	{
		Node head1 = new Node(9);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		head1.next = node1;
		node1.next = node2;
		
		Node head2 = new Node(2);
		Node node3 = new Node(1);
		Node node4 = new Node(7);
		head2.next = node3;
		node3.next = node4;
		Node.printList(head1);
		System.out.println();
		Node.printList(head2);
		System.out.println();
		Node.printList(addForward(head1, head2));
	}
}
