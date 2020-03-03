package Chapter2;

import java.util.HashSet;

public class Question1RemoveDuplicate {
	public static void removeDupliate(Node head) {
		if (head == null || head.next == null) {
			return;
		}

		HashSet<Integer> hashSet = new HashSet<Integer>();
		Node currentNode = head;
		Node prevNode = null;
		while (currentNode != null) {
			if (hashSet.contains(currentNode.val)) {
				prevNode.next = currentNode.next;
			} else {
				hashSet.add(currentNode.val);
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
	}

	public static void removeDuplicate_inplace(Node head) {
		if (head == null || head.next == null) {
			return;
		}

		Node currentNode = head;
		Node prevNode = currentNode;

		while (currentNode != null) {
			Node nextNode = currentNode.next;
			prevNode = currentNode;
			while (nextNode != null) {
				if (nextNode.val == currentNode.val) {
					prevNode.next = nextNode.next;
				} else {
					prevNode = nextNode;

				}
				nextNode = nextNode.next;
			}
			currentNode = currentNode.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(3);
		Node node4 = new Node(5);
		Node node5 = new Node(5);
		Node node6 = new Node(7);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		Node.printList(head);
		System.out.println();
		// removeDupliate(head);
		removeDuplicate_inplace(head);
		Node.printList(head);
	}
}
