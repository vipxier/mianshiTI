
public class LonggestStringWithNoRepeatedMoreThan2Times {
	public static String solution(String str)
	{
		if(str == null || str.length() < 3)
		{
			return str;
		}
		
		String result = "";
		int counter = 1;
		int start = 0;
		
		for(int i = 1; i < str.length(); i ++)
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
				if(result.length() < str.substring(start, i).length())
				{
					result = str.substring(start, i);
				}
				counter = 1;
				start = i;
			}
		}
		
		if(counter < 3)
		{
			if(result.length() < str.substring(start, str.length()).length())
			{
				result = str.substring(start, str.length());
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(LonggestStringWithNoRepeatedMoreThan2Times.solution("aaccbbddaaaaabb"));     // expected: aabbaa
		System.out.println(LonggestStringWithNoRepeatedMoreThan2Times.solution("aabbaabbaabbaa"));  // expected: aabbaabbaabbaa
		System.out.println(LonggestStringWithNoRepeatedMoreThan2Times.solution("abbaabbaaabbaaa")); // expected: abbaabbaa
	}
}
