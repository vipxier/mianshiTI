package OA;

/**
 * Definition for ListNode public class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

public class MergeTwoSortedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	};

	/**
	 * @param l1: ListNode l1 is the head of the linked list
	 * @param l2: ListNode l2 is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// write your code here

		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		ListNode dummyNode = new ListNode(-1);
		ListNode prevNode = dummyNode;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prevNode.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				prevNode.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			prevNode = prevNode.next;
		}

		while (l1 != null) {
			prevNode.next = new ListNode(l1.val);
			l1 = l1.next;
			prevNode = prevNode.next;
		}

		while (l2 != null) {
			prevNode.next = new ListNode(l2.val);
			l2 = l2.next;
			prevNode = prevNode.next;
		}

		return dummyNode.next;
	}
}
