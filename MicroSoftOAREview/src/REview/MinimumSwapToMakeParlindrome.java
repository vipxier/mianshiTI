package REview;

import java.lang.reflect.Array;
import java.util.HashSet;

public class MinimumSwapToMakeParlindrome {
	public static int solution(String str)
	{
		if(!parlindrome(str))
		{
			return -1;
		}
		
		char[] charArray = str.toCharArray();
		int start = 0;
		int end = str.length() - 1;
		int pointer = end;
		int result = 0;
		
		while(start < end)
		{
			pointer = 0;
			while(charArray[pointer] != charArray[start] && pointer > start)
			{
				pointer --;
			}
			
			if(charArray[pointer] == charArray[start] && pointer != start)
			{
				while(pointer < end) {
					swap(charArray, pointer, pointer + 1);
					result ++;
				}
				start ++;
				end --;
			}
			else
			{
				swap(charArray, start, start + 1);
				result ++;
			}
			
		}
		return result;
	}
	
	private static void swap(char[] array, int index1, int index2)
	{
		char temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private static boolean parlindrome(String str)
	{
		HashSet<Character> hashSet = new HashSet<Character>();
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(hashSet.contains(str.charAt(i)))
			{
				hashSet.remove(str.charAt(i));
			}
			else
			{
				hashSet.add(str.charAt(i));
			}
		}
		
		return hashSet.size() < 2;
	}
}
