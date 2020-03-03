import java.util.Arrays;

public class CheckDuplicateII
{
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k <= 1)
        {
            return false;
        }
        
        for(int i = 0; i <= nums.length - 1 - k; i ++ )
        {
            if(checkDuplicate(nums, i, i + k))
            {
                return true;
            }
        }
        return false;
    }
    
    private static boolean checkDuplicate(int[] nums, int start, int end)
    {
        int[] nums_temp = Arrays.copyOfRange(nums, start, end + 1);
        Arrays.sort(nums_temp);
        
        for(int i = start; i < end - 1; i ++)
        {
            if(nums_temp[i] == nums_temp[i + 1])
            {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args)
    {
        int[] array = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(array, 2));
    }
}