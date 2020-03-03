package Try;

import java.util.Arrays;

public class MaximumWidth {
	public static int solution(int[] X, int[] Y)
	{
		int max =  0;
		
		Arrays.sort(X);
		
		for(int i = 0; i < X.length - 1; i ++)
		{
			max = Math.max(max, X[i + 1] - X[i]);
		}
		
		return max;
	}
	
	
}
