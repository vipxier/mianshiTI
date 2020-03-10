package TreeAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import Utils.ListUtils;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();

		if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0
				|| wordList == null && wordList.size() == 0) {
			return result;
		}

		Map<String, List<String>> graph = new HashMap<>();
		Map<String, Integer> distanceMap = new HashMap<>();
		Set<String> dictionarySet = new HashSet<>(wordList);
		dictionarySet.add(beginWord);
		//dictionarySet.add(endWord);

		for (String word : dictionarySet) {
			graph.put(word, new ArrayList<String>());
		}

		CreateGraphAndDistanceByBFS(graph, distanceMap, dictionarySet, endWord);

		TraverseGraphForPathes(graph, distanceMap, beginWord, endWord, result, new ArrayList<String>());
		return result;
	}

	private void TraverseGraphForPathes(Map<String, List<String>> graph, Map<String, Integer> distanceMap,
			String beginWord, String endWord, List<List<String>> result, List<String> currentPath) {
		currentPath.add(beginWord);
		if (beginWord.contentEquals(endWord)) {
			result.add(new ArrayList<String>(currentPath));
		} else {
			for (String neighbor : graph.get(beginWord)) {
				if (distanceMap.containsKey(neighbor) && distanceMap.get(beginWord) == distanceMap.get(neighbor) + 1) {
					TraverseGraphForPathes(graph, distanceMap, neighbor, endWord, result, currentPath);
				}
			}
		}
		currentPath.remove(currentPath.size() - 1);
	}

	private void CreateGraphAndDistanceByBFS(Map<String, List<String>> graph, Map<String, Integer> distanceMap,
			Set<String> dictionarySet, String currentWord) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(currentWord);
		distanceMap.put(currentWord, 0);

		while (!queue.isEmpty()) {
			String parentWord = queue.poll();
			for (String nextWord : generateNextWords(parentWord, dictionarySet)) {
				graph.get(nextWord).add(parentWord);
				if (!distanceMap.containsKey(nextWord)) {
					distanceMap.put(nextWord, distanceMap.get(parentWord) + 1);
					queue.offer(nextWord);
				}
			}
		}
	}

	private List<String> generateNextWords(String startString, Set<String> dictionarySet) {
		List<String> result = new ArrayList<>();

		for (int i = 0; i < startString.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != startString.charAt(i)) {
					String newWord = startString.substring(0, i) + ch + startString.substring(i + 1);
					if (dictionarySet.contains(newWord)) {
						result.add(newWord);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		
		List<String> wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log" });
		String beginWord = "hit";
		String endWord = "cog";

		WordLadderII solution = new WordLadderII();
		for (List<String> list : solution.findLadders(beginWord, endWord, wordList)) {
			System.out.println(list);
		}

	}
}
