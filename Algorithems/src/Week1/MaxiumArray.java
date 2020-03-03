package Week1;

public class MaxiumArray
{
    public static int maximumOfArray(int[] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }
        
        int maxEndingHere = nums[0];
        int maxSumSoFar = nums[0];
        int index = 1;
        while (index < nums.length)
        {
            maxEndingHere = Math.max(maxEndingHere+nums[index], nums[index]);
            maxSumSoFar = Math.max(maxEndingHere, maxSumSoFar);
            index++;
        }
        return maxSumSoFar;
    }
}
