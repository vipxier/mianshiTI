package mcc_rv_2;

import java.util.Arrays;

public class WidestTree {
	public static int solution(int[] A, int[] B)
	{
		if(A == null || A.length == 0 || B == null || B.length == 0)
		{
			return 0;
		}
		
		Arrays.sort(A);
		if(A[0] == A[A.length - 1])
		{
			return 0;
		}
		
		int maxWidth = 0;
		for(int i = 0; i < A.length - 1; i ++)
		{
			maxWidth = Math.max(maxWidth, A[i + 1] - A[i]);
		}
		
		return maxWidth;
	}
}
