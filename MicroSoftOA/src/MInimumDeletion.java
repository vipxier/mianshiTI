import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MInimumDeletion {
	public static int solution(String str)
	{
		if(str == null || str.length() == 0)
		{
			return 0;
		}
		
		Map<Character, Integer> hashMap = new HashMap<>();
		
		for(char c : str.toCharArray())
		{
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
		Set<Integer> set = new HashSet<Integer>();
		
		for(Integer count : hashMap.values())
		{
			if(!set.contains(count))
			{
				set.add(count);
			}
			else {
				while(set.contains(count) && count > 0)
				{
					result ++;
					count --;
				}
				
				if(count > 0)
				{
					set.add(count);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("aaaaabbbbbdbcdljadlfjweifasdghjdddsdfajieeefssdfegtsdfffddddddddddffffsssssssseeefddsfff"));
		
	}
}
