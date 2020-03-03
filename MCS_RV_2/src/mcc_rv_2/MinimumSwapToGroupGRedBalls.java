package mcc_rv_2;

public class MinimumSwapToGroupGRedBalls {
	public static int solution(String str)
	{
		int redBallCount = 0;
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'R')
			{
				redBallCount ++;
			}
		}
		
		int left = 0;
		int right = str.length() - 1;
		int minMoveCount = 0;
		
		while(left < right)
		{
			if(str.charAt(left) == 'R' && str.charAt(right) == 'R')
			{
				redBallCount -= 2;
				minMoveCount += right - left - 1 - redBallCount;
				
				left ++;
				right --;
			}
			else if(str.charAt(left) != 'R')
			{
				left ++;
			}
			else
			{
				right --;
			}
		}
		
		return minMoveCount;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("RRRWRR")); // 2
		System.out.println(solution("WRRWWR")); // 2
		System.out.println(solution("WWRWWWRWR")); // 4
		System.out.println(solution("WWW")) ; // 0
		System.out.println(solution("RRRWWWRRW")); // 6
		System.out.println(solution("RRRRR")); // 0
		System.out.println(solution("RWWWR")); // 3
	}
}
