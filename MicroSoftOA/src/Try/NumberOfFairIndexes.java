package Try;

import java.util.HashSet;

public class NumberOfFairIndexes {
	public static int soltion(int[] A, int[] B)
	{
		if(A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length)
		{
			return 0;
		}
		int sumA = 0;
		int sumB = 0;
		
		for(int i = 0; i < A.length; i ++)
		{
			sumA += A[i];
			sumB += B[i];
		}
		
		if(sumA != sumB)
		{
			return 0;
		}
		
		int counter = 0;
		int tempA = 0;
		int tempB = 0;
		for(int i = 0; i < A.length - 1; i ++)
		{
			tempA += A[i];
			tempB += B[i];
			
			if(sumA == tempA * 2 && sumB == tempB * 2 && tempA == tempB)
			{
				counter ++;
			}
		}
		
		return counter;
	}
	
	public static void main(String[] args)
	{
		int[] A1 = {4,-1,0,3}, B1 = {-2, 5, 0 ,3};
		int[] A2 = {2,-2,-3,3}, B2 = {0,0,4,-4};
		int[] A3 = {4,-1,0,3}, B3 = {-2,6,0,4};
		int[] A4 = {3,2,6}, B4 = {4,1,6};
		int[] A5 = {1,4,2,-2,5}, B5 = {7,-2,-2,2,5};
		System.out.println(soltion(A1, B1));
		System.out.println(soltion(A2, B2));
		System.out.println(soltion(A3, B3));
		System.out.println(soltion(A4, B4));
		System.out.println(soltion(A5, B5));
	}
}
