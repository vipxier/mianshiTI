package List;

public class ReverseNodesFromKthNode
{
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prevSecondPartHead = head;
		while (k > 1 && prevSecondPartHead != null) {
			prevSecondPartHead = prevSecondPartHead.next;
			k--;
		}

		if (k > 1) {
			return null;
		}

		if (prevSecondPartHead.next == null) {
			return reverse(head);
		}

		ListNode firstPartHead = head;
		ListNode secondPartHead = prevSecondPartHead.next;
		prevSecondPartHead.next = null;
		
		firstPartHead = reverse(head);
		head.next = reverse(secondPartHead);

		return firstPartHead;
	}
	
	public ListNode reverseKGroup_secondSolution(ListNode head, int k) {
		if(head == null || head.next == null)
		{
			return head;
		}
		
		ListNode prevSecondPartHead = head;
		
		while(k > 1 && prevSecondPartHead != null)
		{
			prevSecondPartHead = prevSecondPartHead.next;
			k --;
		}
		
		ListNode secondPartHead = prevSecondPartHead.next;
		ListNode currentNode = secondPartHead;
		
		while(currentNode != null && currentNode.next != null)
		{
			currentNode = currentNode.next;
		}
		
		currentNode.next = head;
		prevSecondPartHead.next = null;
		
		return reverse(secondPartHead);
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prevNode = null;
		ListNode currentNode = head;
		ListNode nextNode = head;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}

		return prevNode;
	}

	public static void main(String[] args) {
		ListNode head = ListUtils.generateListFromArray(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		ReverseNodesFromKthNode solution = new ReverseNodesFromKthNode();
		ListNode reversedHead = solution.reverseKGroup(head, 2);
		ListUtils.printList(reversedHead);
		
		head = ListUtils.generateListFromArray(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		ListNode reverseResult = solution.reverseKGroup_secondSolution(head, 2);
		ListUtils.printList(reverseResult);
		
	}
}
