package Chapter1;

import java.util.Arrays;

public class Question1FindIfStringIsUnique {
	public static boolean isUniqueAPI(String str)
	{
		if(str == null || str.length() == 0)
		{
			return false;
		}
		
		if(str.length() == 1)
		{
			return true;
		}
		
		char[] array = str.toCharArray();
		Arrays.sort(array);
		
		for(int i = 1; i < array.length; i ++)
		{
			if(array[i] == array[i - 1])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isUniqueBruteForce(String str)
	{
		if(str == null || str.length() == 0)
		{
			return false;
		}
		
		char[] array = str.toCharArray();
		for(int i = 0; i< array.length - 1; i ++)
		{
			for(int j = i + 1; j < array.length; j ++)
			{
				if(array[i] == array[j])
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isUniqueAPI("Hanassa1209"));
		System.out.println(isUniqueBruteForce("Hannass1209"));
	}
}
