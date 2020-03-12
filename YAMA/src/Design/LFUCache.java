package Design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class LFUCache {

	private class DataElement {
		int key;
		int value;
		int occurance;

		public DataElement(int key, int value) {
			this.key = key;
			this.value = value;
			this.occurance = 1;
		}
	}

	private int capacity;
	private Queue<DataElement> queue;
	private HashMap<Integer, DataElement> hashMap;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.queue = new PriorityQueue<DataElement>(new Comparator<DataElement>() {
			@Override
			public int compare(DataElement element1, DataElement element2) {
				return element1.occurance - element2.occurance;
			}
		});
		this.hashMap = new HashMap<Integer, DataElement>();
	}

	public int get(int key) {
		if (!hashMap.containsKey(key)) {
			return -1;
		}

		DataElement element = hashMap.get(key);
		queue.remove(element);
		element.occurance += 1;
		queue.offer(element);
		return element.value;

	}

	public void put(int key, int value) {
		if (get(key) != -1) {
			hashMap.get(key).value = value;
		}

		if (capacity == hashMap.size()) {
			DataElement elementToRemove = queue.poll();
			hashMap.remove(elementToRemove.key);
		}
		
		DataElement newElement = new DataElement(key, value);
		hashMap.put(key, newElement);
		queue.offer(newElement);
	}
}
