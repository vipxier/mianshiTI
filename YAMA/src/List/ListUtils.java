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
}
