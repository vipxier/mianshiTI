package SoringAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

import com.sun.javafx.collections.MappingChange.Map;

public class TopKFrequentElement {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0 || k <= 0) {
			return result;
		}

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		Queue<Entry<Integer, Integer>> queue = new PriorityQueue<Entry<Integer, Integer>>(
				new Comparator<Entry<Integer, Integer>>() {

					@Override
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						return o1.getValue() - o2.getValue();
					}

				});

		for (int num : nums) {
			if (!hashMap.containsKey(num)) {
				hashMap.put(num, 1);
			} else {
				hashMap.put(num, hashMap.get(num) + 1);
			}
		}

		for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
			queue.offer(entry);
			if (queue.size() > k) {
				queue.poll();
			}
		}

		while (!queue.isEmpty()) {
			result.add(queue.poll().getKey());
		}
		Collections.reverse(result);
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] nums = new int[] {1,1,1,2,2,3};
		TopKFrequentElement solution = new TopKFrequentElement();
		System.out.println(solution.topKFrequent(nums, 2));
	}
}
