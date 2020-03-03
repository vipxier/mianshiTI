package Chapter2;

public class Question7CheckListParlindrome {
	public static boolean isParlindrome(Node head)
	{
		if(head == null || head.next == null)
		{
			return true;
		}
		Node currentNode = head;
		Node dummyNode = new Node(-1);
		Node prevNode = dummyNode;
		
		while(currentNode != null)
		{
			prevNode.next = new Node(currentNode.val);
			prevNode = prevNode.next;
			currentNode = currentNode.next;
		}
		
		Node tail = Question6AddForwardOrder.reverse(dummyNode.next);
		
		while(tail != null && head != null)
		{
			if(tail.val != head.val)
			{
				return false;
			}
			tail = tail.next;
			head = head.next;
		}
		
		if(tail != null || head != null)
		{
			return false;
		}
		
		return true;
	}
	
	public static boolean isParlindrome_midPoint(Node head)
	{
		if(head == null || head.next == null)
		{
			return true;
		}
		
		Node slowNode = head;
		Node fastNode  = head;
		Node prevSlow = null;
		Node rightHead = null;
		while(fastNode != null && fastNode.next != null)
		{
			fastNode = fastNode.next.next;
			prevSlow = slowNode;
			slowNode = slowNode.next;
		}
		
		if(fastNode == null)
		{
			prevSlow.next = null;
			rightHead = slowNode;
		}
		else
		{
			rightHead = slowNode.next;
			prevSlow.next = null;
		}
		
		Node leftHead = Question6AddForwardOrder.reverse(head);
		
		while(leftHead != null && rightHead != null)
		{
			if(leftHead.val != rightHead.val)
			{
				return false;
			}
			leftHead = leftHead.next;
			rightHead = rightHead.next;
		}
		
		if(leftHead != null || rightHead != null)
		{
			return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args)
	{
		Node head1 = new Node(9);
		Node node1 = new Node(1);
		Node node2 = new Node(7);
		//Node nodea = new Node(0);
		Node node3 = new Node(7);
		Node node4 = new Node(1);
		Node node5 = new Node(9);
		head1.next = node1;
		node1.next = node2;
		//node2.next = nodea;
		//nodea.next = node3;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		System.out.println(isParlindrome_midPoint(head1));
	}
}
