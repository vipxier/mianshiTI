package mcc_rv_2;

import java.util.Arrays;
import java.util.HashMap;

public class MinStepstoMakePilesEqualHeight {
	public static int solution(int[] array)
	{
		if(array == null || array.length == 0)
		{
			return 0;
		}
		
		Arrays.sort(array);
		
		if(array[0] == array[array.length - 1])
		{
			return 0;
		}
		
		int index = 0;
		for(int i = 1; i < array.length; i ++)
		{
			if(array[i] != array[index])
			{
				index ++;
			}
			
			swap(array, index, i);
		}
		
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i = 0; i <= index; i ++)
		{
			hashMap.put(array[i], i);
		}
		
		int result = 0;
		for(int i = 0; i < array.length; i++)
		{
			result += hashMap.get(array[i]);
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution(new int[] {5,2,1}));
		System.out.println(solution(new int[] {1,1,1,1,1}));
		System.out.println(solution(new int[] {1,2,3,4,5,6,7}));
	}
	
	private static void swap(int[] array, int index_1, int index_2)
	{
		if(index_1 == index_2)
		{
			return;
		}
		
		int temp = array[index_1];
		array[index_1] = array[index_2];
		array[index_2] = temp;
	}
}
