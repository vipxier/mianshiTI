
public class MinInsertMakeNoDuplicateA {
	public static int solution(String str)
	{
		int counter = 0;
		int result = 0;
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'a')
			{
				counter ++;
			}
			else
			{
				result += 2 - counter;
				counter = 0;
			}
			
			if(counter == 3)
			{
				return -1;
			}
		}
		
		if(str.charAt(str.length() - 1) == 'a')
		{
			result += 2 - counter;
		}
		else
		{
			result += 2;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		String s1 = "aabab";
		String s2 = "dog";
		String s3 = "aa";
		String s4 = "baaa";
		String s5 = "aaba";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
		System.out.println(solution(s5));
	}
}
