package AdvanceAlgorithms;

import utils.ArrayUtils;

public class GreedyAlgoritem {
	public static void coinChange(int[] coins, int charge) {
		System.out.print("change for " + charge);
		StringBuilder strb = new StringBuilder();
		while (charge > 0) {
			int coin = findMaxCoin(coins, charge);
			strb.append(" ").append(coin);
			charge -= coin;
		}
		System.out.println(" is" + strb.toString());
	}

	private static int findMaxCoin(int[] coins, int amount) {
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= amount) {
				return coins[i];
			}
		}
		return 0;
	}
	
	private static void mergeSort(int[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(int[] array, int start, int end)
	{
		if(start + 1 < end)
		{
			int mid = start + (end - start) / 2;
			sort(array, start, mid);
			sort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}
	
	private static void merge(int[] array, int start, int mid, int end)
	{
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i = 0; i < n1; i ++)
		{
			left[i] = array[start + i];
		}
		for(int i = 0; i < n2; i ++)
		{
			right[i] = array[mid + i + 1];
		}
		
		int leftIndex = 0, rightIndex = 0, resultIndex = start;
		while(leftIndex < n1 && rightIndex < n2)
		{
			if(left[leftIndex] >= right[rightIndex])
			{
				array[resultIndex ++] = left[leftIndex++];
			}
			else
			{
				array[resultIndex ++] = right[rightIndex++];
			}
		}
		
		while(leftIndex < n1)
		{
			array[resultIndex ++] = left[leftIndex ++];
		}
		
		while(rightIndex < n2)
		{
			array[resultIndex ++] = right[rightIndex ++];
		}
	}

	public static void main(String[] args) {
		int[] coins = { 10, 5, 25, 2, 1 };
		
		ArrayUtils.printSingleDimentionArray(coins);
		mergeSort(coins);
		ArrayUtils.printSingleDimentionArray(coins);
		coinChange(coins, 1097);

	}
}
