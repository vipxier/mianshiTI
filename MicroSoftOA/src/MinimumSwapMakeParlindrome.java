import java.util.HashSet;
import java.util.Set;

public class MinimumSwapMakeParlindrome {
	public static int solution(String str)
	{
		if(str == null || str.length() == 0)
		{
			return -1;
		}
		
		if(!isParnlindormeable(str))
		{
			return -1;
		}
		
		int start = 0;
		int end = str.length() - 1;
		int stepsCount = 0;
		
		while(start < end)
		{
			int pointer = end;
			while(str.charAt(start) != str.charAt(pointer) && start != pointer)
			{
				pointer --;
			}
			
			if(str.charAt(start) == str.charAt(pointer) && start != pointer)
			{
				while(pointer < end)
				{
					str = swap(str, pointer, pointer + 1);
					pointer ++;
					stepsCount ++;
				}
				start ++;
				end --;
			}
			else
			{
				str = swap(str, start, start + 1);
				stepsCount ++;
			}
		}
		
		return stepsCount;
	}
	
	private static boolean isParnlindormeable(String str)
	{
		Set<Character> set = new HashSet<Character>();
		
		for(char c : str.toCharArray())
		{
			if(set.contains(c))
			{
				set.remove(c);
			}
			else
			{
				set.add(c);
			}
		}
		
		return set.size() <= 2;
	}
	
	private static String swap(String str, int index1, int index2)
	{
		char[] charArray = str.toCharArray();
		char temp = charArray[index1];
		charArray[index1] = charArray[index2];
		charArray[index2] = temp;
		
		return new String(charArray);
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("mamab"));
	}
}
