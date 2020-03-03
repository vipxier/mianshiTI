package Chapter2;

public class Question5AddLinkList {
	public static Node add(Node head1, Node head2)
	{
		if(head1 == null || head2 == null)
		{
			return null;
		}
		
		Node dummyNode = new Node(-1);
		Node prevNode = dummyNode;
		int passingValue = 0;
		
		while(head1 != null || head2 != null)
		{
			int result = 0;
			if(head1 != null && head2 != null)
			{
				result = head1.val + head2.val + passingValue;
				head1 = head1.next;
				head2 = head2.next;
			}
			else if(head1 == null)
			{
			    result = head2.val + passingValue;
			    head2 = head2.next;
			}
			else if(head2 == null)
			{
				result = head1.val + passingValue;
				head1 = head1.next;
			}
			
			if(result >= 10)
			{
				passingValue = 1;
				prevNode.next = new Node(result - 10);
			}
			else 
			{
				prevNode.next = new Node(result);
			}
			
			prevNode = prevNode.next;
		}
		
		if(passingValue == 1)
		{
			prevNode.next = new Node(1);
		}
		
		return dummyNode.next;
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
		Node.printList(add(head1, head2));
	}
}
