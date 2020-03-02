package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TopNToyCompeters {
	public List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
		List<String> result = new ArrayList<String>();
		if (toys == null || toys.length == 0 || quotes == null || quotes.length == 0 || numToys <= 0) {
			return result;
		}
		Set<String> toySet = new HashSet<String>(Arrays.asList(toys));
		Map<String, Set<Integer>> wordOccuranceInQuoteMap = new HashMap<>();
		Map<String, Integer> wordOccuranceMap = new HashMap<>();

		Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
						if (entry1.getValue() == entry2.getValue()) {
							return wordOccuranceInQuoteMap.get(entry2.getKey()).size()
									- wordOccuranceInQuoteMap.get(entry1.getKey()).size();
						}

						return entry2.getValue() - entry1.getValue();
					}
				});

		for (int lineNum = 0; lineNum < quotes.length; lineNum++) {
			String quote = quotes[lineNum];
			StringBuilder strb = new StringBuilder();
			for (char c : quote.toCharArray()) {
				if (Character.isLetterOrDigit(c)) {
					strb.append(c);
				} else {
					strb.append(' ');
				}
			}
			for (String word : strb.toString().split(" ")) {
				word = word.toLowerCase();
				if (toySet.contains(word)) {
					if (!wordOccuranceInQuoteMap.containsKey(word)) {
						wordOccuranceInQuoteMap.put(word, new HashSet<Integer>());
						wordOccuranceMap.put(word, 1);
					} else {
						wordOccuranceMap.put(word, wordOccuranceMap.get(word) + 1);
					}
					wordOccuranceInQuoteMap.get(word).add(lineNum);
				}
			}
		}

		for (Map.Entry<String, Integer> toyEntry : wordOccuranceMap.entrySet()) {
			queue.offer(toyEntry);
		}

		for (int i = 0; i < topToys; i++) {
			if (!queue.isEmpty()) {
				result.add(queue.poll().getKey());
			}
		}

		return result;
	}

	private String getToyName(String word, Set<String> toySet) {
		for (String toyName : toySet) {
			if (word.toLowerCase().contains(toyName)) {
				return toyName;
			}
		}

		return "";
	}

	public static void main(String[] args) {
		TopNToyCompeters solution = new TopNToyCompeters();
		System.out.println(
				solution.topToys(6, 2, new String[] { "elmo", "elsa", "legos", "drone", "tablet", "warcraft" }, 6,
						new String[] { "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
								"The new Elmo dolls are super high quality",
								"Expect the Elsa dolls to be very popular this year, Elsa!",
								"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
								"For parents of older kids, look into buying them a drone",
								"Warcraft is slowly rising in popularity ahead of the holiday season" }));
	}
}
