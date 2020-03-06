package shuatiwang_yama_array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		
        if(strs == null || strs.length == 0)
        {
        	return result;
        }
        
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        
        for(int i = 0; i < strs.length; i ++)
        {
        	char[] charArray = strs[i].toCharArray();
        	Arrays.sort(charArray);
        	String sortedString = new String(charArray);
        	
        	if(hashMap.containsKey(sortedString))
        	{
        		hashMap.get(sortedString).add(strs[i]);
        	}
        	else
        	{
        		List<String> newList = new ArrayList<String>();
        		newList.add(strs[i]);
        		hashMap.put(sortedString, newList);
        	}
        }
        
        return new ArrayList<List<String>>(hashMap.values());
        
    }
	
	public static void main(String[] args)
	{
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		GroupAnagrams solution = new GroupAnagrams();
		for(List<String> list : solution.groupAnagrams(strs))
		{
			System.out.println(list);
		}
	}
}
