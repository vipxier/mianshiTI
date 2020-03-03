package Chapter2;

public class PartitionList {
	public static Node Partition(Node head, int value)
	{
		if(head == null || head.next == null )
		{
			return head;
		}
		
		Node dummyNode_left = new Node(0);
		Node prevNode_left = dummyNode_left;
		Node dummyNode_right = new Node(0);
		Node prevNode_right = dummyNode_right;
		Node currentNode = head;
		while(currentNode != null)
		{
			if(currentNode.val < value)
			{
				prevNode_left.next = new Node(currentNode.val);
				prevNode_left = prevNode_left.next;
			}
			else
			{
				prevNode_right.next = new Node(currentNode.val);
				prevNode_right = prevNode_right.next;
			}
			currentNode = currentNode.next;
		}
		
		prevNode_left.next = dummyNode_right.next;
		return dummyNode_left.next;
	}
	
	public static void main(String[] args) {
		Node head = new Node(16);
		Node node1 = new Node(10);
		Node node2 = new Node(3);
		Node node3 = new Node(9);
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
		Node.printList(Partition(head, 8));
	}
}
