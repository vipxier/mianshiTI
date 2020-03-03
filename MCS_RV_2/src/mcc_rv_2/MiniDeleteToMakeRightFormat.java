package mcc_rv_2;

public class MiniDeleteToMakeRightFormat {
	public static int solution(String str)
	{
		if(str == null || str.length() == 0)
		{
			return 0;
		}
		
		int aCount = 0;
		int bCount = 0;
		int deleteCount  =0;
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'A')
			{
				aCount ++;
				if(bCount > deleteCount)
				{
					deleteCount ++;
				}
			}
			else
			{
				bCount ++;
				if(aCount == 0)
				{
					deleteCount ++;
				}
			}
		}
		
		return Math.min(aCount, Math.min(bCount, deleteCount));
	}
	
	public static int anotherSolution(String str)
	{
		if(str == null || str.length() <= 1)
		{
			return 0;
		}
		
		int[] aCounts = new int[str.length() + 1];
		int[] bCounts = new int[str.length() - 1];
		int countA = 0;
		int countB = 0;
		int deleteA = 0;
		int deleteB = 0;
		int minDel = Integer.MAX_VALUE;
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'B')
			{
				countB ++;
			}
			
			bCounts[i + 1] = countB;
		}
		
		for(int i = str.length() - 1; i >= 0; i ++)
		{
			if(str.charAt(i) == 'A')
			{
				countA ++;
				
			}
			bCounts[i + 1] = countA;
		}
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 'B')
			{
				minDel = Math.min(minDel, deleteA + bCounts[i]);
				deleteA++;
			}
		}
		
		for(int i = str.length() - 1; i >= 0; i --)
		{
			if(str.charAt(i) == 'A')
			{
				minDel = Math.min(minDel, deleteB + aCounts[i + 1]);
				deleteB++;
			}
		}
		
		return minDel;
	}
	public static void main(String[] args) {
		String s1 = "BAAABAB";
		String s2 = "BBABAA";
		String s3 = "AABBBB";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
	}
}
