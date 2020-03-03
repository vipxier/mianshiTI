import utils.ArrayUtils;

public class RemoveDuplicate
{
    public static int removeDuplicates(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != nums[nums.length - 1])
            {
                ArrayUtils.printSingleDimentionArray(nums);
                int repeatedTimes = findRepeatedTimes(nums, i, nums[i]);

                if (repeatedTimes > 0)
                {
                    moveItemForward(nums, i + 1, repeatedTimes);
                    ArrayUtils.printSingleDimentionArray(nums);
                }
            }
            else
            {
                return i + 1;
            }
        }
        return nums.length;
    }

    private static void moveItemForward(int[] nums, int startPosition, int moveCount)
    {
        for (int i = startPosition; i < nums.length - moveCount; i++)
        {
            nums[i] = nums[i + moveCount];
        }
    }

    private static int findRepeatedTimes(int[] nums, int startPosition, int target)
    {
        int repeateTimes = 0;
        for (int i = startPosition; i < nums.length - 1; i++)
        {
            if (nums[i] == nums[i + 1])
            {
                repeateTimes++;
            }
            else
            {
                break;
            }
        }
        return repeateTimes;
    }

    public static void main(String[] args)
    {
        int[] array = { 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 6, 6, 7 };
        int[] a = {1,1,1,2,2,3,3,4,4,4};
        System.out.println(removeDuplicates(a));
    }
}
