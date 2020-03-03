package EasyQuestions;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = {-1, -1};
        for(int i = 0; i < nums.length; i ++)
        {
            if(map.keySet().contains(target - nums[i]))
            {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        return result;
	}
	
	
	public static void main(String[] args)
	{
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] result = twoSum(nums, target);
		for(int i : result)
		{
			System.out.println(i);
		}
	}
}
