import java.util.Arrays;

public class CheckDuplicate{
    //217
    public static boolean containsDuplicate(int[] nums)
    {
        if(nums == null || nums.length <= 1)
        {
            return false;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i ++)
        {
            if(nums[i] == nums[i + 1])
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        int[] array  ={ 1,2,3,1};
        System.out.println(containsDuplicate(array));
    }
}