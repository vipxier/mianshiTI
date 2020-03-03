package Try;

public class JumpGameII {
	public static int solution(int[] steps)
	{
		int[] jumps = new int[steps.length];
		
		for(int i = 0; i < jumps.length; i ++)
		{
			jumps[i] = Integer.MAX_VALUE;
		}
		
		jumps[0] = 0;
		for(int i = 1; i < steps.length; i ++)
		{
			for(int j = 0; j < i; j ++)
			{
				if(jumps[j] != Integer.MAX_VALUE && j + steps[j] >= i)
				{
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
				}
			}
		}
		
		return jumps[jumps.length - 1];
	}
}
