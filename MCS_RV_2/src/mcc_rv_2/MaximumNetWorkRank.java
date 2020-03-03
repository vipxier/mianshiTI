package mcc_rv_2;

import java.util.HashMap;
import java.util.Map;

public class MaximumNetWorkRank {
	public static int solution(int[] A, int[] B, int N)
	{
		if(A == null || A.length == 0 || B == null || B.length == 0)
		{
			return 0;
		}
		
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < A.length; i ++)
		{
			if(!hashMap.containsKey(A[i]))
			{
				hashMap.put(A[i], 1);
			}
			else
			{
				hashMap.put(A[i], hashMap.get(A[i]) + 1);
			}
			
			if(!hashMap.containsKey(B[i]))
			{
				hashMap.put(B[i], 1);
			}
			else
			{
				hashMap.put(B[i], hashMap.get(B[i]) + 1);
			}
		}
		
		int maxSum = 0;
		for(int i = 0; i < A.length; i++)
		{
			maxSum = Math.max(maxSum, hashMap.get(A[i]) + hashMap.get(B[i]) - 1);
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
	    int[] A = {1, 2, 3, 3};
	    int[] B = {2, 3, 1, 4};
	    int N = 4;

	    System.out.println("expected " + 4 + " actual " + solution(A, B, N));
	  }
}
