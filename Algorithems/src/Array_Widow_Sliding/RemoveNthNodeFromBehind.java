package Array_Widow_Sliding;

public class RemoveNthNodeFromBehind {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null || head.next == null) {
			return null;
		}

		ListNode tail = reverseList(head);

		tail = removeNthNode(tail, n);

		return reverseList(tail);

	}

	private static ListNode reverseList(ListNode head) {
		ListNode prevNode = null, currentNode = head, nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}

		return prevNode;
	}

	public static ListNode removeNthNode(ListNode head, int n) {
		if (n == 1) {
			return head.next;

		}
		ListNode prevNode = head, currentNode = head;

		while (currentNode != null && n > 1) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			n--;
		}

		prevNode.next = currentNode.next;
		currentNode.next = null;
		currentNode = null;

		return head;
	}

}
