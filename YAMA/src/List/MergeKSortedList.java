package List;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode node1, ListNode node2) {
				return node1.val - node2.val;
			}
		});
		
		for(ListNode node : lists)
		{
			if(node != null)
			{
				queue.offer(node);
			}
		}
		
		ListNode dummyNode = new ListNode(-1);
		ListNode prevNode = dummyNode;
		
		while(!queue.isEmpty())
		{
			ListNode currentNode = queue.poll();
			
			if(currentNode.next != null)
			{
				queue.offer(currentNode.next);
			}
			
			prevNode.next = new ListNode(currentNode.val);
			prevNode = prevNode.next;
		}
		return dummyNode.next;
	}
	
	public static void main(String[] args)
	{
		ListNode node1 = ListUtils.generateListFromArray(new int[] {1,5,6,8,10});
		ListNode node2 = ListUtils.generateListFromArray(new int[] {2,4,5,6,7});
		ListNode node3 = ListUtils.generateListFromArray(new int[] {8,9,11,24,46,77});
		
		ListNode[] nodes = new ListNode[] {node1, node2, node3};
		MergeKSortedList solution = new MergeKSortedList();
		ListUtils.printList(solution.mergeKLists(nodes));
	}
}
