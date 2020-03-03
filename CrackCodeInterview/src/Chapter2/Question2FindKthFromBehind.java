package Chapter2;

public class Question2FindKthFromBehind {
	public static Node findKthFromBehind(Node head, int k)
	{
		if(head == null || k < 0)
		{
			return null;
		}
		
		Node fastNode = head;
		Node targetNode = head;
		while(k > 0 && fastNode != null)
		{
			fastNode = fastNode.next;
			k --;
		}
		
		if(k > 0)
		{
			return null;
		}
		
		while(fastNode != null && fastNode.next != null)
		{
			fastNode  = fastNode.next;
			targetNode = targetNode.next;
		}
		
		return targetNode;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		Node node6 = new Node(7);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		Node.printList(head);
		System.out.println();
		System.out.println(findKthFromBehind(head, 3).val);
	}
}
