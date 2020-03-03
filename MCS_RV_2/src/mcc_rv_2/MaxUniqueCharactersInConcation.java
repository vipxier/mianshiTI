package mcc_rv_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MaxUniqueCharactersInConcation {
	public static int solution(String[] strs)
	{
		if(strs == null || strs.length == 0)
		{
			return 0;
		}
		
		List<String> combinations = new ArrayList<String>();
		
		generateCombinations(strs, combinations, "", 0);
		combinations.remove("");
		
		int maxLength = 0;
		for(int i = 0; i < combinations.size(); i ++)
		{
			maxLength = Math.max(maxLength, getUniqueCharacterCount(combinations.get(i)));
		}
		
		return maxLength;
	}
	
	private static int getUniqueCharacterCount(String str)
	{
		HashSet<Character> hashSet = new HashSet<Character>();
		for(int i = 0; i < str.length(); i ++)
		{
			hashSet.add(str.charAt(i));
		}
		
		if(str.length() != hashSet.size())
		{
			return -1;
		}
		return hashSet.size();
	}
	
	private static void generateCombinations(String[] strs, List<String> combinations, String combination, int currentIndex)
	{
		combinations.add(combination);
		
		for(int i = currentIndex; i < strs.length; i ++)
		{
			generateCombinations(strs, combinations, combination + strs[currentIndex], i + 1);
			if(combination == "") {
				combinations.remove(strs[currentIndex]);
			}
		}
	}
	
	public static void main(String[] args)
	{
		String[] A1 = new String[] {"co","dil","ity"}; // , function should return 5, resulting string S could be codil , dilco, coity,ityco
		String[] A2 = {"abc","kkk","def","csv"}; // , returns 6 , resulting Strings S could be abcdef , defabc, defcsv , csvdef
		String[] A3 = {"abc","ade","akl"}; // , return 0 , impossible to concatenate as letters wont be unique.
		System.out.println(solution(A1));
		System.out.println(solution(A2));
		System.out.println(solution(A3));
	}
}
