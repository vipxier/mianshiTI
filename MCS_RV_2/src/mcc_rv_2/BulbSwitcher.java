package mcc_rv_2;

import java.util.ArrayList;
import java.util.List;

public class BulbSwitcher {
	public static List<Integer> solution(int[] array)
	{
		List<Integer> result = new ArrayList<Integer>();
		
		if(array == null || array.length == 0)
		{
			return result;
		}
		
		int maxBulbIndex = 0;
		for(int i = 0; i < array.length; i ++)
		{
			maxBulbIndex = Math.max(maxBulbIndex, array[i]);
			if(maxBulbIndex == i+ 1)
			{
				result.add(array[i]);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] nums1 = {2,1,3,5,4};
		int[] nums2 = {2,3,4,1,5};
		int[] nums3 = {5,4,3,2,1};
		int[] nums4 = {3,2,4,6,5};
		printList(solution(nums1));
		printList(solution(nums2));
		printList(solution(nums3));
		printList(solution(nums4));	
	}
	
	private static void printList(List<Integer> result)
	{
		for(int num : result)
		{
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
