package List;

public class ReverseNodesinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prevSecondPartHead = head;
		while (k > 1 && prevSecondPartHead != null) {
			prevSecondPartHead = prevSecondPartHead.next;
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

	public static void main() {
		ListNode head = ListUtils.generateListFromArray(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		ReverseNodesinKGroup solution = new ReverseNodesinKGroup();
		System.out.println(solution.reverseKGroup(head, 2));
	}
}
