
public class LonggestSemiAltterringString {
	public static int solution(String str)
	{
		if(str == null)
		{
			return 0;
		}
		
		if(str.length() < 3)
		{
			return str.length();
		}
		
		int aCount = 0;
		int bCount = 0;
		int deleteTimes = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 'a')
			{
				 aCount ++;
				 bCount = 0;
			}
			else if(str.charAt(i) == 'b')
			{
				aCount = 0;
				bCount ++;
			}
			
			if(aCount >= 3 || bCount >= 3)
			{
				deleteTimes ++;
			}
			
		}
		
		
		return str.length() - deleteTimes;
	}
	
	public static void main(String[] args)
	{
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
