package REview;

public class LonggestSubStringWithNoRepeatMoreThan2 {
	public static String solution(String str)
	{
		if(str == null || str.length() <= 2)
		{
			return str;
		}
		
		String result = "";
		int counter = 1;
		int startIndex = 0;
		
		for(int i = 1; i < str.length(); i++)
		{
			if(str.charAt(i) == str.charAt(i - 1))
			{
				counter ++;
			}
			else
			{
				counter = 1;
			}
			
			if(counter == 3)
			{
				if(result.length() < i - startIndex + 1)
				{
					result = str.substring(startIndex, i);
					startIndex = i - 1;
				}
			}
		}
		
		if(result.length() < str.length() - startIndex)
		{
			result = str.substring(startIndex, str.length());
		}
		
		return result;
	}
	public static String betterSolution(String str)
	{
		if(str == null || str.length() <= 2)
		{
			return str;
		}
		
		int start = 0;
		int length = str.length();
		int end = str.length() - 1;
		int maxLength = Integer.MIN_VALUE;
		int counter = 0;
		
		for(int i = 0; i < length - 1; i ++)
		{
			counter = 1;
			for(int j = i + 1; j < length; j ++)
			{
				if(str.charAt(j) == str.charAt(j - 1))
				{
					counter ++;
				}
				else
				{
					counter = 1;
				}
				
				if(counter == 3 || j == length - 1)
				{
					if(maxLength < i - j + 1)
					{
						start = i;
						end = (counter == 3) ? j - 1: j;
						maxLength = i - j + 1;
					}
					
					i = j - 2;
					break;
				}
			}
			
			if(i == length - 3)
			{
				break;
			}
		}
		
		return str.substring(start, end + 1);
	}
	public static void main(String[] args) {
		String s1 = "baaabbabbb";
		String s2 = "babba";
		String s3 = "abaaaa";
		String s4 = "a";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}
}
