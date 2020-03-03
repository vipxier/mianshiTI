package Chapter1;

import java.util.HashSet;
import java.util.Set;

public class FindIfCharacterUnique {
	public static boolean isUnique(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		Set<String> set = new HashSet<String>();

		String[] array = str.split("");
		for(String string: array)
		{
			if(set.contains(string))
			{
				return false;
			}
			else
			{
				set.add(string);
			}
		}
		return true;
	}
	
	public static boolean isUnique_Sort(String str)
	{
		if(str == null) return true;
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.indexOf(str.substring(i, i+1), i+1) > i)
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		String str = null;
		
		System.out.println(isUnique(str));
		System.out.println(isUnique_Sort(str));
	}
}
