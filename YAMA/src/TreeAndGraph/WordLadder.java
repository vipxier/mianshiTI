package TreeAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null
				|| wordList.size() == 0) {
			return -1;
		}

		if(beginWord.contentEquals(endWord))
		{
			return 0;
		}
		
		Set<String> dictionarySet = new HashSet<String>();
		dictionarySet.add(beginWord);
		dictionarySet.add(endWord);

		for (String word : wordList) {
			dictionarySet.add(word);
		}

		Set<String> visitedSet = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();

		queue.offer(beginWord);
		queue.offer(null);
		int stepCounter = 1;

		while (!queue.isEmpty()) {
			String currentWord = queue.poll();
			if (currentWord == null) {
				stepCounter++;
				if (queue.peek() != null) {
					queue.offer(null);
				}
			} else if (currentWord.contentEquals(endWord)) {
				return stepCounter;
			} else {
				for (String nextWord : generateNextWords(dictionarySet, currentWord)) {
					if (!visitedSet.contains(nextWord)) {
						queue.offer(nextWord);
					}
				}
			}
		}

		return 0;
	}

	private List<String> generateNextWords(Set<String> dictionarySet, String word) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < word.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				String newString = word.substring(0, i) + ch + word.substring(i + 1);
				if (!newString.contentEquals(word) && dictionarySet.contains(newString)) {
					result.add(newString);
				}
			}
		}

		return result;
	}
	
	public int anotherSolution(String beginWord, String endWord, List<String> wordList)
	{
		if(beginWord == null || beginWord.length() == 0 || endWord == null 
		           || endWord.length() == 0 || wordList== null || wordList.size() == 0)
		        {
		            return -1;
		        }
		        
		        if(beginWord.contentEquals(endWord))
		        {
		            return 0;
		        }
		        
		        Set<String> hashSet = new HashSet<String>();
		        Set<String> dictionarySet = new HashSet<>();
		        for(String word : wordList)
		        {
		            dictionarySet.add(word);
		        }
		        dictionarySet.add(beginWord);
		        dictionarySet.add(beginWord);
		        Queue<String> queue = new LinkedList<>();
		        
		        queue.offer(beginWord);
		        queue.offer(null);
		        int steps = 1;
		        
		        while(!queue.isEmpty())
		        {
		            String currentWord = queue.poll();
		            if(currentWord == null)
		            {
		                steps ++;
		                if(queue.peek() != null)
		                {
		                    queue.offer(null);
		                }
		            }
		            else if(currentWord.contentEquals(endWord))
		            {
		                return steps;
		            }
		            else
		            {
		                for(int i = 0; i < currentWord.length(); i ++)
		                {
		                    for(char ch = 'a'; ch <= 'z'; ch ++)
		                    {
		                        String newString = currentWord.substring(0, i) + 
		                            ch + currentWord.substring(i + 1);
		                        if(dictionarySet.contains(newString) && !hashSet.contains(newString))
		                        {
		                            hashSet.add(newString);
		                            queue.offer(newString);
		                        }
		                    }
		                }
		            }
		        }
		        
		        return 0;
	}
	
	public static void main(String[] args)
	{
		String beginWord = "hit";
		String endWord = "cog";
		List<String>wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log"});
		WordLadder solution = new WordLadder();
		System.out.println(solution.ladderLength(beginWord, endWord, wordList));
	}
}
