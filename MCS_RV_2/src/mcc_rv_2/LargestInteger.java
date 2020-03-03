package mcc_rv_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestInteger {
	public static int solution(int[] array)
	{
		if(array == null || array.length == 0)
		{
			return 0;
		}
		
		Arrays.sort(array);
		
		if(array[0] > 0 || array[array.length - 1] < 0)
		{
			return 0;
		}
		
		Set<Integer> hashSet = new HashSet<Integer>();
		int maxValue = 0;
		for(int i =0; i < array.length; i ++)
		{
			if(hashSet.contains(array[i]))
			{
				maxValue = Math.max(maxValue, array[i]);
			}
			else
			{
				hashSet.add(0 - array[i]);
			}
		}
		
		return maxValue;
	}
	
	public static void main(String[] args)
	{
		int[] array = new int[] {8,9,0,4,3,-9,-3};
		System.out.println(solution(array));
		int[] array1 = new int[] {9,10,10,8,7,-55,4,6,0,1,2,-220};
		System.out.println(solution(array1));
	}
}
