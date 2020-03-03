import java.util.Arrays;

public class RemoveElement
{
    public static int removeElement(int[] nums, int val)
    {
        if (nums == null)
        {
            return -1;
        }
        
        for(int i = 0; i < nums.length; i ++)
        {
            if(nums[i] == val)
            {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        
        Arrays.parallelSort(nums);
        
        for(int i = 0; i < nums.length; i ++)
        {
            if(nums[i] == Integer.MAX_VALUE)
            {
                return i;
            }
        }
        return nums.length;
    }
    
    public static void main(String[] args)
    {
        int[] array = {1,3,4,51,2,5,23,51,2,31,1,2,5,1};
        
        System.out.println(removeElement(array, 1));
    }
}
