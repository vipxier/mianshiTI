package Try;

public class JumGameI {
	public static boolean solution(int[] arr)
	{
		if(arr == null || arr.length == 0)
		{
			return false;
		}
		
		boolean[] canJump = new boolean[arr.length];
		
		canJump[0] = true;
		
		for(int i = 1; i < arr.length; i ++)
		{
			for(int j = 0;  j < i; i ++)
			{
				if(canJump[j] && j + arr[j] >= i)
				{
					canJump[i] = true;
				}
			}
		}
		
		return canJump[arr.length - 1];
	}
}
