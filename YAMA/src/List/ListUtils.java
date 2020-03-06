package List;

public class ListUtils {
	public static ListNode generateListFromArray(int[] nums)
	{
		ListNode dummyNode = new ListNode(-1);
		ListNode prevNode = dummyNode;
		for(int num : nums)
		{
			prevNode.next = new ListNode(num);
			prevNode = prevNode.next;
		}
		
		return dummyNode.next;
	}
	
	public static void printList(ListNode head)
	{
		System.out.println();
		while(head != null)
		{
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
