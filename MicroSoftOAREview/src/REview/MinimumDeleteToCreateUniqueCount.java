package REview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDeleteToCreateUniqueCount {
	public static int solution(String str)
	{
		if(str.length() <= 1)
		{
			return str.length();
		}
		
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		
		for(int i = 0; i < str.length(); i ++)
		{
			char c = str.charAt(i);
			if(hashMap.containsKey(c))
			{
				hashMap.put(c, hashMap.get(c) + 1);
			}
			else
			{
				hashMap.put(c, 1);
			}
		}
		int result = 0;
		Set<Integer> hashSet = new HashSet<Integer>();
		
		for(int count : hashMap.values())
		{
			if(!hashSet.contains(count))
			{
				hashSet.add(count);
			}
			else
			{
				while(hashSet.contains(count) && count > 0)
				{
					result ++;
					count --;
				}
				
				if(count > 0)
				{
					hashSet.add(count);
				}
			}
		}
		
		return result;
	}
}
