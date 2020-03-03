package REview;

public class JumpGameIII {
	public static boolean solution(int[] jumps, int start)
	{
		if(jumps == null || jumps.length == 0)
		{
			return false;
		}
		
		if(start < jumps.length && start >= 0 && jumps[start] < jumps.length)
		{
			int jump = jumps[start];
			jumps[start] += jumps.length;
			return (jump == 0 || solution(jumps, start + jump) || solution(jumps, start - jump));
		}
		
		return false;
	}
}
