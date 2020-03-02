package OA;

import java.util.Arrays;

public class TwoSumUniquePairs {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        Arrays.sort(nums);
        if(nums[0] > target)
        {
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int resultCounter = 0;
        
        while(start < end)
        {
            int sum = nums[start] + nums[end];
            if(sum == target)
            {
                
                resultCounter ++;
                start ++;
                end --;
                while(start < end && nums[start] == nums[start - 1])
                {
                    start ++;
                }
                
                while(start < end && nums[end] == nums[end + 1])
                {
                    end --;
                }
            }
            else if(sum < target)
            {
                start ++;
                while(start < end && nums[start] == nums[start - 1])
                {
                    start ++;
                }
            }
            else
            {
                end --;
                while(start < end && nums[end] == nums[end + 1])
                {
                    end --;
                }
            }
        }
        return resultCounter;
    }
}
