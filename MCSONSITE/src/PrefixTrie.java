import java.util.HashMap;
import java.util.Map;

public class PrefixTrie {
	private class TrieNode{
		public char c;
		private Map<Character, TrieNode> children;
		public boolean hasWord;
		
		public TrieNode(char c)
		{
			this.c = c;
			children = new HashMap<Character, TrieNode>();
			this.hasWord = false;
		}
		
		public TrieNode() {
			this.children = new HashMap<Character, TrieNode>();
			this.hasWord = false;
		}
	}
	
	public class Trie{
		private TrieNode root;
		
		public Trie()
		{
			root = new TrieNode();
		}
		
		public void insert(String word)
		{
			TrieNode currentNode = root;
			
			for(char c : word.toCharArray())
			{
				if(currentNode.children.containsKey(c))
				{
					currentNode = currentNode.children.get(c);
				}
				else
				{
					TrieNode newNode = new TrieNode(c);
					currentNode.children.put(c, newNode);
					currentNode = newNode;
				}
			}
			currentNode.hasWord = true;
		}
		
		public boolean search(String word)
		{
			TrieNode result = searchWithWordAndPos(word);
			return (result != null && result.hasWord);
		}
		
		public boolean startsWith(String prefix)
		{
			TrieNode result = searchWithWordAndPos(prefix);
			return result != null;
		}
		
		private TrieNode searchWithWordAndPos(String word)
		{
			TrieNode currentNode = root;
			
			for(char c : word.toCharArray())
			{
				if(currentNode.children.containsKey(c))
				{
					currentNode = currentNode.children.get(c);
				}
				else
				{
					return null;
				}
			}
			
			return currentNode;
		}
		
		
	}
}
