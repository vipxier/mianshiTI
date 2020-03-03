package REview;

import java.util.Arrays;

public class MaxiumuWidth {
	public static int solution(int[] A, int[] B)
	{
		if(A == null ||A.length == 0)
		{
			return 0;
		}
		
		Arrays.parallelSort(A);
		int maxWidth = 0;
		for(int i = 1; i < A.length; i ++)
		{
			maxWidth = Math.max(maxWidth, A[i + 1] - A[i]);
		}
		
		return maxWidth;
	}
}
