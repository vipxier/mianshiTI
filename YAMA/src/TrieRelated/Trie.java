package TrieRelated;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	private TrieNode node;

	public Trie() {
		this.node = new TrieNode();
	}

	public void insert(String word) {
		node.insert(word, 0);
	}

	public boolean serach(String word) {
		TrieNode result = node.find(word, 0);
		return result != null && result.isEndofWord();
	}

	public boolean startWith(String word) {
		TrieNode result = node.find(word, 0);
		return result != null;
	}

	public TrieNode getRoot(String word, int index) {
		TrieNode result = node.find(word, 0);
		return result;
	}

	public List<String> findAllPosibleWords(String word) {
		List<String> result = new ArrayList<String>();
		TrieNode startNode = getRoot(word, 0);
		if (startNode == null || startNode.isEndofWord()) {
			return result;
		}

		findAllCombination(result, startNode, word);
		return result;
	}

	private void findAllCombination(List<String> result, TrieNode startNode, String currentCombination) {
		if(startNode.isEndofWord())
		{
			result.add(currentCombination);
			for(int i = 0; i < 26; i ++) {
				if(startNode.getChildren()[i] != null) {
					findAllCombination(result, startNode.getChildren()[i], currentCombination);
				}
			}
			return;

		}

		for (int i = 0; i < 26; i++) {
			if (startNode.getChildren()[i] != null) {
				currentCombination += (char) ('a' + i);
				findAllCombination(result, startNode.getChildren()[i], currentCombination);
				currentCombination = currentCombination.substring(0, currentCombination.length() - 1);
			}

		}
	}

	private boolean noChild(TrieNode[] children) {
		// TODO Auto-generated method stub
		for(TrieNode node : children)
		{
			if(node != null)
			{
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		String[] words = new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" };

		for (String word : words) {
			trie.insert(word);
		}

		System.out.println(trie.findAllPosibleWords(""));
	}
}
