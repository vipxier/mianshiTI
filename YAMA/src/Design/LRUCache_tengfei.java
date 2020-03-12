package Design;

import java.util.HashMap;

public class LRUCache_tengfei {
	private class ListNode{
		int value;
		int key;
		ListNode next;
		ListNode prev;
		
		public ListNode(int key, int value)
		{
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}
	
	private int capacity;
	private ListNode head;
	private ListNode tail;
	private HashMap<Integer, ListNode> hashMap;
	
	public LRUCache_tengfei(int capacity)
	{
		this.capacity = capacity;
		this.head = new ListNode(-1, -1);
		this.tail = new ListNode(-1, -1);
		this.head.next = tail;
		this.tail.prev = head;
		this.hashMap = new HashMap<Integer, ListNode>();
	}
	
	public int get(int key)
	{
		if(!hashMap.containsKey(key))
		{
			return -1;
		}
		
		ListNode node = hashMap.get(key);
		node.next.prev = node.prev;
		node.prev.next = node.next;
		moveToTail(node);
		return node.value;
	}
	
	private void moveToTail(ListNode node)
	{
		node.prev = tail.prev;
		node.next = tail;
		tail.prev.next = node;
		tail.prev = node;
	}
	
	public void put(int key, int value)
	{
		if(get(key) != -1)
		{
			hashMap.get(key).value = value;
		}
		
		if(hashMap.size() == capacity)
		{
			hashMap.remove(head.next.key);
			head.next.next.prev = head;
			head.next = head.next.next;
			
			ListNode newNode = new ListNode(key, value);
			moveToTail(newNode);
			hashMap.put(key, newNode);
		}
		
	}
}
