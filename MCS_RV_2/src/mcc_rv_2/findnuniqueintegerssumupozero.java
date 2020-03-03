package mcc_rv_2;

public class findnuniqueintegerssumupozero {
	public static int[] solution(int n)
	{
		if(n <= 0)
		{
			return new int[0];
		}
		
		int[] result  = new int[n];
		
		for(int i = 0; i < n; i ++)
		{
			result[i] = 2 * i - n + 1;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] result = solution(10);
		
		for(int i = 0; i < result.length; i ++)
		{
			System.out.println(result[i]);
		}
	}
}
