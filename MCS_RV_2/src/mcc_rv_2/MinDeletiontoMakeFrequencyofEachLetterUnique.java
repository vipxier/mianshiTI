package mcc_rv_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinDeletiontoMakeFrequencyofEachLetterUnique {
	public static int solution(String str)
	{
		if(str == null || str.length()<= 1)
		{
			return 0;
		}
		
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(!hashMap.containsKey(str.charAt(i)))
			{
				hashMap.put(str.charAt(i), 1);
			}
			else
			{
				hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
			}
		}
		
		Set<Integer> hashSet = new HashSet<Integer>();
		int counter = 0;
		for(Integer num : hashMap.values())
		{
			if(hashSet.contains(num))
			{
				while(hashSet.contains(num) && num > 0)
				{
					num --;
					counter ++;
				}
				
				if(num > 0)
				{
					hashSet.add(num);
				}
			}
			else
			{
				hashSet.add(num);
			}
		}
		return counter;
	}
	
	public static void main(String[] args)
	{
		String str ="aabbffddeaee";
		System.out.println(solution(str));
		System.out.println(solution("example"));
		System.out.println(solution("eeeeffff"));
		
	}
}
