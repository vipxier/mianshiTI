package mcc_rv_2;

public class FairIndexCount {
	public static int solution(int[] array1, int[] array2)
	{
		if(array1.length == 0 || array1.length == 0 || array2.length == 0 || array2.length == 0 || array1.length != array2.length)
		{
			return 0;
		}
			
		int fairIndexCount = 0;
		int sumA = 0;
		int sumB = 0;
		for(int i = 0; i < array1.length; i ++)
		{
			sumA += array1[i];
			sumB += array2[i];
		}
		
		if(sumA != sumB)
		{
			return 0;
		}
		int tempA = 0;
		int tempB = 0;
		
		for(int i = 0; i < array1.length; i ++)
		{
			tempA += array1[i];
			tempB += array2[i];
			
			if(tempA * 2 == sumA && tempB * 2 == sumA && tempA == tempB)
			{
				fairIndexCount ++;
			}
		}
		
		return fairIndexCount;
	}
	
	public static void main(String[] args) {
		int[] A1 = {4,-1,0,3}, B1 = {-2, 5, 0 ,3};
		int[] A2 = {2,-2,-3,3}, B2 = {0,0,4,-4};
		int[] A3 = {4,-1,0,3}, B3 = {-2,6,0,4};
		int[] A4 = {3,2,6}, B4 = {4,1,6};
		int[] A5 = {1,4,2,-2,5}, B5 = {7,-2,-2,2,5};
		System.out.println(solution(A1, B1));
		System.out.println(solution(A2, B2));
		System.out.println(solution(A3, B3));
		System.out.println(solution(A4, B4));
		System.out.println(solution(A5, B5));
	}
}
