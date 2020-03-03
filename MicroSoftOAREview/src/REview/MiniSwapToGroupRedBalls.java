package REview;

public class MiniSwapToGroupRedBalls {
	public static int solution(String str)
	{
		if(str == null || str.length() == 0)
		{
			return -1;
		}
		
		int redBallCount = 0;
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'R')
			{
				redBallCount ++;
			}
		}
		
		int steps = 0;
		int start  =0;
		int end = str.length() - 1;
		
		while(start < end)
		{
			if(str.charAt(start) == 'R' && str.charAt(end) == 'R')
			{
				redBallCount -= 2;
				steps += end - start - 1 - redBallCount;
				
				start ++;
				end --;
			}
			else if(str.charAt(start) != 'R')
			{
				start ++;
			}
			else
			{
				end --;
			}
		}
		
		return steps;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(solution("RRRWRR")); // 2
		System.out.println(solution("WRRWWR")); // 2
		System.out.println(solution("WWRWWWRWR")); // 4
		System.out.println(solution("WWW")); // 0
		System.out.println(solution("RRRWWWRRW")); // 6
		System.out.println(solution("RRRRR")); // 0
		System.out.println(solution("RWWWR")); // 3
	}
	
}
