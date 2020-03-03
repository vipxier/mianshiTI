package TrieRelated;

public class TrieNode {
	private boolean endOfWord;
	private TrieNode[] children;
	
	public TrieNode()
	{
		this.endOfWord = false;
		this.children = new TrieNode[26];
	}
	
	public boolean isEndofWord()
	{
		return this.endOfWord;
	}
	
	public TrieNode[] getChildren()
	{
		return this.children;
	}
	
	public void insert(String word, int index)
	{
		if(index == word.length())
		{
			this.endOfWord = true;
			return;
		}
		
		int currentCharLocation = word.charAt(index) - 'a';
		if(this.children[currentCharLocation] == null)
		{
			this.children[currentCharLocation] = new TrieNode();
		}
		
		this.children[currentCharLocation].insert(word, index + 1);	
	}
	
	public TrieNode find(String word, int index)
	{
		if(index == word.length())
		{
			return this;
		}
		
		if(this.children[word.charAt(index) - 'a'] == null)
		{
			return null;
		}
		
		return this.children[word.charAt(index) - 'a'].find(word, index + 1);
	}
}

