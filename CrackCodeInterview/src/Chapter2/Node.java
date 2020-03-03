package Chapter2;

public class Node {
	public Node next;
	public int val;
	
	public Node(int val)
	{
		this.val = val;
	}
	
	public static void printList(Node head)
	{
		while(head != null)
		{
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
