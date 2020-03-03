package mcc_rv_2;

public class MaximumInsertTomake2A {
	public static int maxlengthInsertation(String str)
	{
		if(str == null)
		{
			return 0;
		}
		
		if(str.length() == 0)
		{
			return 2;
		}
		
		int maxLength = 0;
		int counter = 0;
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'a')
			{
				counter ++;
			}
			else 
			{
				maxLength += 2 - counter;
				counter = 0;
			}
			
			if(counter == 3)
			{
				return -1;
			}
		}
		
		if(str.charAt(str.length() - 1) != 'a')
		{
			maxLength += 2;
		}
		else
		{
			maxLength += 2 - counter;
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		String s1 = "aabab";
		String s2 = "dog";
		String s3 = "aa";
		String s4 = "baaa";
		String s5 = "aaba";
		System.out.println(maxlengthInsertation(s1));
		System.out.println(maxlengthInsertation(s2));
		System.out.println(maxlengthInsertation(s3));
		System.out.println(maxlengthInsertation(s4));
		System.out.println(maxlengthInsertation(s5));
	}
}
