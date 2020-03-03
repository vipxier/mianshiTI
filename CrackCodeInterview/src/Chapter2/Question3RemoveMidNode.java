package Chapter2;

public class Question3RemoveMidNode {
	public static void removeMid(Node head)
	{
		if(head == null || head.next == null)
		{
			head = null;
			return;
		}
		
		
		Node slowNode = head;
		Node fastNode = head.next;
		
		while(fastNode != null && fastNode.next != null && fastNode.next.next != null)
		{
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		
		slowNode.next = slowNode.next.next;
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

		Node.printList(head);
		System.out.println();
		removeMid(head);
		Node.printList(head);
	}
}
