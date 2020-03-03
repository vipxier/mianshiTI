import utils.ArrayUtils;

public class RemoveDuplicate1
{
    public static int removeDuplicates(int[] nums)
    {
        int p = 0, q = 1;
        while(q < nums.length)
        {
            if(nums[p] == nums[q])
            {
                q++;
                nums[p + 1] = nums[q];
            }
            else
            {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        ArrayUtils.printSingleDimentionArray(nums);
        return p + 1;
    }
    
    public static void main(String[] args)
    {
        int[] a = {1,1,1,2,2,3,3,4,4,4};
        
        System.out.println(removeDuplicates(a));
    }
}

