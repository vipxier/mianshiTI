package Week1;

import utils.ArrayUtils;

public class SubArraySums {
	public static int[] subArraySum(int[] array, int sum) {
		int currentSum, i, j;
		for (i = 0; i < array.length; i++) {
			currentSum = array[i];
			for (j = i + 1; j <= array.length; j++) {
				if (currentSum == sum) {
					return ArrayUtils.initializeArrayFromParent(array, i, j-1);
				}
				if (currentSum > sum) {
					break;
				}

				currentSum = currentSum + array[j];
			}
		}
		return new int[0];
	}
	
	public static int[] SubArraySum_sol2(int[] array, int sum)
	{
		int currentSum = array[0], start = 0;
		
		for(int i = 1; i < array.length; i ++)
		{
			while(currentSum > sum && start < i-1)
			{
				currentSum -= array[start];
				start++;
			}
			
			if(currentSum == sum)
			{
				return ArrayUtils.initializeArrayFromParent(array, start, i-1 );
			}
			
			currentSum += array[i];
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int[] array = { 15, 2, 4, 8, 9, 5, 10, 23 };
		for (int i : subArraySum(array, 33)) {
			System.out.print(" " + i);
		}

	}
}
