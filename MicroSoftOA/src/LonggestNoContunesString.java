
public class LonggestNoContunesString {
	public static String solution(String str)
	{
		if(str == null || str.length() < 3)
		{
			return str;
		}
		
		String result  = "";
		int aCount = 0;
		int bCount = 0;
		
		int start = 0;
		
		for(int i = 0; i< str.length(); i ++)
		{
			if(str.charAt(i)== 'a')
			{
				aCount ++;
				bCount = 0;
			}
			else if(str.charAt(i) == 'b')
			{
				aCount = 0;
				bCount ++;
			}
			
			if(aCount == 3|| bCount == 3)
			{
				if(result.length() < str.substring(start, i).length())
				{
					result = str.substring(start, i);
				}
				
				aCount = 0;
				bCount = 0;
				start = i;
			}
		}
		
		if(aCount <= 2 && bCount <= 2 && result.length() < str.substring(start, str.length()).length())
		{
			result = str.substring(start, str.length());
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(LonggestNoContunesString.solution("aabbaaaaabb"));     // expected: aabbaa
		System.out.println(LonggestNoContunesString.solution("aabbaabbaabbaa"));  // expected: aabbaabbaabbaa
		System.out.println(LonggestNoContunesString.solution("abbaabbaaabbaaa")); // expected: abbaabbaa
	}
}
