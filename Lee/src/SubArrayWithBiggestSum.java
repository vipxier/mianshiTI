
public class SubArrayWithBiggestSum
{
 public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        
        int result = nums[0];
        int sum = 0;
        
        for(int num: nums)
        {
            if(sum > 0)
            {
                sum += num;
            }
            else
            {
                sum = num;
            }
            
            result = Math.max(result, sum);
        }
        
        return result;
    }
 
 public static void main(String[] args)
 {
     int[] array = {-1, -2, -4, 7, 9};
     
     System.out.println(maxSubArray(array));
 }
}
