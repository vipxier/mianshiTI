package mcc_rv_2;

import java.util.HashSet;
import java.util.Set;

public class MInimumSwapToMakeParlindrome {
	public static int solution(String str)
	{
		if(str == null || str.length() == 0 || !canBeChangedToParlindrome(str))
		{
			return -1;
		}
		
		int start = 0;
		int end = str.length() - 1;
		int currentPointer = end;
		int swapCounter = 0;
		
		char[] charArray = str.toCharArray();
		
		while(start < end)
		{
			currentPointer = end;
			while(charArray[start] != charArray[currentPointer] && currentPointer != start)
			{
				currentPointer --;
			}
			if(charArray[start] == charArray[currentPointer] && currentPointer != start)
			{
				while(currentPointer < end)
				{
					swap(charArray, currentPointer, currentPointer + 1);
					swapCounter ++;
					currentPointer++;
				}
				start ++;
				end --;
			}
			else 
			{
				swap(charArray, start, start + 1);
				swapCounter ++;
			}
		}
		
		return swapCounter;
	}
	
	private static void swap(char[] array, int index1, int index2)
	{
		if(index1 == index2)
		{
			return;
		}
		
		char temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private static boolean canBeChangedToParlindrome(String str)
	{
		Set<Character> set = new HashSet<Character>();
		for(char c : str.toCharArray())
		{
			if(!set.contains(c))
			{
				set.add(c);
			}
			else
			{
				set.remove(c);
			}
		}
		
		return set.size() < 2;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("mamad"));
		System.out.println(solution("asflkj"));
		System.out.println(solution("aabb"));
		System.out.println(solution("ntiin"));
	}
}
