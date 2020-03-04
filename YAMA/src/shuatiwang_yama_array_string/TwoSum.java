package shuatiwang_yama_array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
		if(nums == null || nums.length == 0)
		{
			return result;
		}
		
		Map<Integer, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < nums.length; i ++)
		{
			if(hashMap.containsKey(nums[i]))
			{
				result[0] = i;
				result[1] = hashMap.get(nums[i]);
			}
			else
			{
				hashMap.put(target - nums[i], i);
			}
		}
		
		return result;
    }
	
	public List<List<Integer>> getAllTwoSums(int[] nums, int target)
	{
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0)
		{
			return result;
		}
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1; 
		
		while(start < end)
		{
			int sum = nums[start] + nums[end];
			if(target > sum)
			{
				start ++;
				while(start < end && nums[start] == nums[start - 1])
				{
					start ++;
				}
			}
			else if(target < sum)
			{
				end --;
				while(start < end && nums[end] == nums[end + 1])
				{
					end --;
				}
			}
			else
			{
				List<Integer> solution = new ArrayList<Integer>();
				solution.add(nums[start]);
				solution.add(nums[end]);
				result.add(solution);
				start ++;
				while(start < end && nums[start] == nums[start - 1])
				{
					start ++;
				}
				end --;
				while(start < end && nums[end] == nums[end + 1])
				{
					end --;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
//		int[] array = new int[] {1,7,8,10,9,7,4};
//		int target = 14;
		TwoSum solution = new TwoSum();
//		System.out.println(Arrays.toString(solution.twoSum(array, target)));
//		
		int[] nums = new int[] {-4, 0, 1, 2, -1, -1};
		int[] nums1 = {0,0, 0,0};
		
		for(List<Integer> list : solution.getAllTwoSums(nums, 1))
		{
			System.out.println(list);
		}
		
		for(List<Integer> list : solution.getAllTwoSums(nums1, 0))
		{
			System.out.println(list);
		}
	}
}
