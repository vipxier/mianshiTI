package Week1;

public class MaximunProductOfSubArray
{
    public static int maxProductOfSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        int minValue = nums[0];
        int maxValue = nums[0];
        
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i]< 0)
            {
                int temp = minValue;
                minValue = maxValue;
                maxValue = temp;
            }
            
            maxValue = Math.max(nums[i], maxValue*nums[i]);
            minValue = Math.min(nums[i], minValue*nums[i]);
            maxProduct = Math.max(maxValue, maxProduct);
            
        }
        return maxProduct;
    }
    
    public static void main(String[] args)
    {
        int[] nums = {-2,3,-4};
        System.out.println(maxProductOfSubArray(nums));
    }
}
