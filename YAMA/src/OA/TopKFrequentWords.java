package OA;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
	/**
	 * @param words: an array of string
	 * @param k:     An integer
	 * @return: an array of string
	 */
	public String[] topKFrequentWords(String[] words, int k) {
		// write your code here
		if (words == null || words.length == 0) {
			return new String[0];
		}

		Map<String, Integer> hashMap = new HashMap<>();
		Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(
				new Comparator<Map.Entry<String, Integer>>()
				{
					@Override
					public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2)
					{
						if(entry1.getValue() == entry2.getValue())
						{
							return entry1.getKey().compareTo(entry2.getKey());
						}
						
						return entry2.getValue() - entry1.getValue();
					}
				});

		for (String word : words) {
			if (!hashMap.containsKey(word)) {
				hashMap.put(word, 1);
			} else {
				hashMap.put(word, hashMap.get(word) + 1);
			}
		}

		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			queue.offer(entry);
		}

		String[] result = new String[k];

		for (int i = 0; i < k; i++) {
			if (!queue.isEmpty()) {
				result[i] = queue.poll().getKey();
			}
		}

		return result;
	}
}
