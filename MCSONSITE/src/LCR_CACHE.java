import java.util.HashMap;

public class LCR_CACHE {
	
	private class DoubleLinkedListNode
	{
		DoubleLinkedListNode next;
		DoubleLinkedListNode prev;
		int val;
		int key;
		
		public DoubleLinkedListNode(int key, int value)
		{
			this.key = key;
			this.val = value;
			this.next = null;
			this.prev = null;
		}
	}
	
	private int capacity;
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;
	private HashMap<Integer, DoubleLinkedListNode> hashMap;
	
	public LCR_CACHE(int capacity)
	{
		this.capacity = capacity;
		hashMap = new HashMap<Integer, DoubleLinkedListNode>();
		this.head = new DoubleLinkedListNode(-1, -1);
		this.tail = new DoubleLinkedListNode(-1, -1);
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int value)
	{
		if(!hashMap.containsKey(value))
		{
			return -1;
		}
		else
		{
			DoubleLinkedListNode currentNode = hashMap.get(value);
			currentNode.prev.next = currentNode.next;
			currentNode.next.prev  = currentNode.prev;
			
			moveToTail(currentNode);
			return currentNode.val;
		}
	}
	
	private void moveToTail(DoubleLinkedListNode node)
	{
		node.next = tail;
		tail.prev.next = node;
		node.prev = node.prev;
		tail.prev = node;
	}
	
	private void put(int key, int value)
	{
		if(get(key) != -1)
		{
			hashMap.get(key).val = value;
			return;
		}
		else
		{
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(value, value);
			if(hashMap.size() == capacity)
			{
				hashMap.remove(head.next.val);
				head.next = head.next.next;
				head.next.prev = head;
				hashMap.put(value, newNode);
			}
			newNode.next = tail;
			tail.prev.next = newNode;
			newNode.prev = tail.prev;
			tail.prev = newNode;
		}
		
	}
}
