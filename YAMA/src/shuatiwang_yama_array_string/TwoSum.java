package shuatiwang_yama_array_string;

import java.util.Arrays;
import java.util.HashMap;
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
	
	public static void main(String[] args)
	{
		int[] array = new int[] {1,7,8,10,9,7,4};
		int target = 14;
		TwoSum solution = new TwoSum();
		System.out.println(Arrays.toString(solution.twoSum(array, target)));
	}
}
