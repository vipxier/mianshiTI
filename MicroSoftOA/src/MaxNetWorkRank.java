import java.util.HashMap;
import java.util.Map;

public class MaxNetWorkRank {
	public static int solution(int[] A, int[] B, int total)
	{
		if(A == null || A.length == 0 ||B == null || B.length == 0)
		{
			return -1;
		}
		
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < A.length; i ++)
		{
			if(hashMap.containsKey(A[i]))
			{
				hashMap.put(A[i], hashMap.get(A[i]) + 1);
			}
			else
			{
				hashMap.put(A[i], 1);
			}
			
			if(hashMap.containsKey(B[i]))
			{
				hashMap.put(B[i], hashMap.get(B[i]) + 1);
			}
			else
			{
				hashMap.put(B[i], 1);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i ++)
		{
			max = Math.max(max, hashMap.get(A[i]) + hashMap.get(B[i]) - 1);
		}
		
		return max;
	}
	
	public static void main(String[] args)
	{
		int[] A = {1,2,3,3};
		int[] B = {2,3,1,4};
		
		System.out.println(solution(A, B, 4));
	}
}
