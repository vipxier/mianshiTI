package Chapter1;

public class CheckIfIsParlindorme {
	public static boolean isPermutationAPI(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.length() != str2.length())
		{
			return false;
		}
		
		if(str1.length() == 0 && str2.length() == 0)
		{
			return true;
		}
		
		StringBuilder strb = new StringBuilder(str1);
		str1 = strb.reverse().toString();
		return str1.contentEquals(str2);
	}
	
	public static boolean isPermutationLoop(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.length() != str2.length())
		{
			return false;
		}
		
		if(str1.length() == 0 && str2.length() == 0)
		{
			return true;
		}
		
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		
		for(int i = 0; i < array1.length; i ++)
		{
			if(array1[i] != array2[array2.length - 1 - i])
			{
				return false;
			}
		}
		
		return true;
	}
}
