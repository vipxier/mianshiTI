package mcc_rv_2;

public class JumpGame {
	public static boolean solution(int[] array, int start)
	{
		if(start >= 0 && start < array.length && array[start] < array.length)
		{
			int jump = array[start];
			return jump == 0 || solution(array, start - array[start]) || solution(array, start + array[start]);
		}
		
		return false;
	}
}
