
public class MinimumDeleteToMatchFormat {
	public static int solution(String str)
	{
		int aCount = 0;
		int bCount = 0;
		int removeCount = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 'A')
			{
				aCount ++;
				if(bCount > removeCount)
				{
					removeCount ++;
				}
			}
			else
			{
				bCount ++;
				if(aCount == 0)
				{
					removeCount ++;
				}
			}
		}
		
		return removeCount;
	}
	
	public static void main(String[] args) {
		String s1 = "BAAABAB";
		String s2 = "BBABAA";
		String s3 = "AABBBB";
		String s4 = "AAA";
		String s5 = "BBB";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
		System.out.println(solution(s5));
	}
}	
