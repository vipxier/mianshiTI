package Design;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

class LRUCache {

    private class Node
    {
        int value;
        int key;
        Node next;
        Node prev;

        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> hashMap;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        hashMap = new HashMap<Integer, Node>();
    }

    public int get(int key)
    {
        if (hashMap.containsKey(key))
        {
            Node currentNode = hashMap.get(key);
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            moveToTail(currentNode);
            return currentNode.value;
        }

        return -1;
    }

    private void moveToTail(Node node)
    {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void put(int key, int value)
    {
        if (get(key) != -1)
        {
            hashMap.get(key).value = value;
            return;
        }

        if (hashMap.size() == capacity)
        {
            hashMap.remove(head.next.key);
            head.next.next.prev = head;
            head.next = head.next.next;
        }

        Node newNode = new Node(key, value);
        moveToTail(newNode);
        hashMap.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
