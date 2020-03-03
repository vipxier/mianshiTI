package Chapter1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question3IfIsPermutation {
	
	
	public static boolean isPermutationSort(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.length() != str2.length())
		{
			return false;
		}
		
		if(str1.length() == 0 && str2.length() == 0)
		{
			return true;
		}
		
		char[] array = str1.toCharArray();
		Arrays.sort(array);
		return str2.contentEquals(new String(array));
	}
	
	public static boolean isPermutation(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.length() != str2.length())
		{
			return false;
		}
		
		if(str1.length() == 0 && str2.length() == 0)
		{
			return true;
		}
		
		int[] array = new int[256];
		
		for(int i = 0; i < str1.length(); i ++)
		{
			array[str1.charAt(i)] ++;
		}
		
		for(int i = 0; i < str2.length(); i ++)
		{
			array[str2.charAt(i)] --;
			
			if(array[str2.charAt(i)] < 0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isPermutation("1234566bcdef", "1ef25ab6c34d"));
	}
}
