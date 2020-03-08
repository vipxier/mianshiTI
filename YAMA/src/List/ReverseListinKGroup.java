package List;

public class ReverseListinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) 
	{
		if(head == null || head.next == null)
		{
			return null;
		}
		
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode prevNode = dummyNode;
		ListNode tailNode = prevNode.next;
		ListNode currentNode = head;
		
		while(currentNode != null && currentNode.next != null)
		{
			int counter = k;
			while(counter > 1 && currentNode != null && currentNode.next != null)
			{
				currentNode = currentNode.next;
				counter--;
			}
			
			if(counter > 1)
			{
				return dummyNode.next;
			}
			
			ListNode nextNode = currentNode.next;
			currentNode.next = null;
			prevNode.next = reverse(tailNode);
			tailNode.next = nextNode;
			prevNode = tailNode; 
			currentNode = prevNode.next;
			tailNode  = currentNode;
		}
		
		return dummyNode.next;
	}
	
	private ListNode reverse(ListNode head)
	{
		ListNode prevNode = null;
		ListNode currentNode = head;
		ListNode nextNode = head;
		
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
		ReverseListinKGroup solution = new ReverseListinKGroup();
		ListUtils.printList(solution.reverseKGroup(ListUtils.generateListFromArray(new int[] {1,2,3,4,5,6,7,8,9}), 3));
	}
}
