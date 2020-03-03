package Try;

public class JumpGameIII {
	public static boolean solution(int[] jumps, int start)
	{
		int targetIndex = -1;
		
		for(int i = 0; i < jumps.length; i ++)
		{
			if(jumps[i] == 0)
			{
				targetIndex = i;
				break;
			}
		}
		
		if(targetIndex == -1)
		{
			return false;
		}
		
		boolean[] canJump = new boolean[jumps.length];
		canJump[start] = true;
		return helper(canJump, start, targetIndex, jumps);
				
	}
	
	private static boolean helper(boolean[] canJump, int start, int targetIndex, int[] jumps)
	{
		if(start - jumps[start] >= 0 && !canJump[start - jumps[start]])
		{
			if(start - jumps[start] == targetIndex)
			{
				return true;
			}
			else
			{
				canJump[start - jumps[start]] = true;
				return helper(canJump, start - jumps[start], targetIndex, jumps);
				
			}
		}
		
		if(start + jumps[start] < jumps.length && ! canJump[start + jumps[start]])
		{
			if(start + jumps[start] == targetIndex)
			{
				return true;
			}
			else
			{
				canJump[start + jumps[start]] = true;
				return helper(canJump, start + jumps[start], targetIndex, jumps);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		int[] jumps = new int[] {4,2,3,0,3,1,2};
		int[] jumps1 = new int[] {3,0,2,1,2};
		
		System.out.println(solution(jumps, 5));
		System.out.println(solution(jumps, 0));
		System.out.println(solution(jumps1, 2));
		
	}
}
