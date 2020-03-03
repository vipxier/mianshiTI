package REview;
import java.util.HashMap;
import java.util.Map;

public class SumOfSameDigitsSum {
	public static int solution(int[] A)
	{
		if(A == null || A.length == 0)
		{
			return 0;
		}
		
		Map<Integer, Integer> hashMap = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i ++)
		{
			int digitSum = 0;
			int value = A[i];
			while(value > 0)
			{
				digitSum += value % 10;
				value /= 10;
			}
			
			if(hashMap.containsKey(digitSum))
			{
				max = Math.max(max, hashMap.get(digitSum) + A[i]);
				hashMap.put(digitSum, max);
			}
			else 
			{
				hashMap.put(digitSum, A[i]);
			}
		}
		
		return max;
	}
}
