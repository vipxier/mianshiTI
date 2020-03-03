package mcc_rv_2;

public class LongestSubstringWithout2ContiguousOccurrencesofLetter {
	public static String solution(String str)
	{
		if(str == null || str.length()<=2)
		{
			return str;
		}
		
		int start = 0;
		int maxLength= 0;
		int aCounter = 0;
		int bCounter = 0;
		String maxSubString = "";
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'a')
			{
				aCounter ++;
				bCounter = 0;
			}
			else
			{
				aCounter = 0;
				bCounter ++;
			}
			
			if(aCounter == 3 || bCounter == 3)
			{
				if(aCounter == 3)
				{
					aCounter = 2;
				}
				else if(bCounter == 3)
				{
					bCounter = 2;
				}
				start = i - 1;
			}
			else
			{
				if(maxLength < i - start + 1)
				{
					maxSubString = str.substring(start, i + 1);
					maxLength = i - start + 1;
				}
			}
		}
		
		return maxSubString;
	}
	
	public static String longgestSubString(String str)
	{
		if(str == null || str.length() <= 2)
		{
			return str;
		}
		
		int start = 0;
		int counter = 1;
		int end = 0;
		int maxLength = 0;
		
		for(int i = 0; i < str.length()-2; i ++)
		{
			counter = 1;
			for(int j = i + 1; j < str.length(); j ++)
			{
				if(str.charAt(j) == str.charAt(j - 1))
				{
					counter++;
				}
				else
				{
					counter = 1;
				}
				
				if(counter == 3 || j == str.length() - 1)
				{
					if(maxLength < j - i + 1)
					{
						maxLength = j - i + 1;
						end = counter == 3 ? j - 1: j;
						start = i;
					}
					
					i = j - 2;
					break;
				}
			}
			
		}
		
		return str.substring(start, end + 1);
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("aabbaaaaabbaabababaabbaabbaabbaabbabababababa"));
		System.out.println(solution("aabbaabbaabbaa"));
		
		System.out.println(longgestSubString("aabbaaaaabbaabababaabbaabbaabbaabbabababababa"));
		System.out.println(longgestSubString("aabbaabbaabbaa"));
	}
	
}
