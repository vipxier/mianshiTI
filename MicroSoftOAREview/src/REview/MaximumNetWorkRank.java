package REview;

import java.util.HashMap;

public class MaximumNetWorkRank {
	public static int solution(int[] A, int[] B)
	{
		if(A == null || B == null || A.length == 0 || B.length == 0)
		{
			return 0;
		}
		
		int maxValue = Integer.MIN_VALUE;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		for(int i = 0; i < A.length; i ++)
		{
			if(hashMap.containsKey(A[i]))
			{
				hashMap.put(A[i], hashMap.get(A[i]) + 1);
			}
			else
			{
				hashMap.put(A[i], 0);
			}
			
			if(hashMap.containsKey(B[i]))
			{
				hashMap.put(B[i], hashMap.get(B[i]) + 1);
			}
			else
			{
				hashMap.put(B[i], 0);
			}
		}
		
		for(int i = 0; i < A.length; i ++)
		{
			maxValue = Math.max(maxValue, hashMap.get(A[i]) + hashMap.get(B[i]) - 1);
		}
		
		return maxValue;
	}
}
