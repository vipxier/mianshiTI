package Week1;

public class SearchinRotatedSortedArray
{
    public static int findTarget(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
        {
            return -1;
        }

        int pivotPosition = -1;
        int start = 0;
        int end = nums.length - 1;

        if (nums[start] == target)
        {
            return start;
        }

        if (nums[end] == target)
        {
            return end;
        }

        while (start + 1 < end)
        {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= nums[end])
            {
                end = mid;
            }
            else
            {
                start = mid;
            }
        }

        if (nums[start] <= nums[end])
        {
            pivotPosition = start;
        }
        else
        {
            pivotPosition = end;
        }

        System.out.println("Pivot postion is " + pivotPosition);

        if (nums[pivotPosition] == target)
        {
            return pivotPosition;
        }

        if (pivotPosition == 0)
        {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (nums[nums.length - 1] > target)
        {
            return binarySearch(nums, pivotPosition, nums.length - 1, target);
        }
        else
        {
            return binarySearch(nums, 0, pivotPosition - 1, target);
        }

    }

    private static int binarySearch(int[] nums, int start, int end, int target)
    {
        System.out.println("start: " + start + " end: " + end);
        while (start + 1 < end)
        {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target)
            {
                start = mid;
            }
            else
            {
                end = mid;
            }

        }
        if (nums[start] == target)
        {
            return start;
        }

        if (nums[end] == target)
        {
            return end;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums1 = { 1, 2, 3, 4, 5, 66 };
        int[] nums2 = { 1, 3, 4, 5, 6, 7, 89 };
        int[] nums3 = { 6, 7, 89, 1, 3, 4, 5 };
        int[] nums4 = { 1, 3, 5 };
        System.out.println(findTarget(nums1, 1));
        // System.out.println(findTarget(nums2, 1));

        // System.out.println(findTarget(nums2, 7));
        // System.out.println(findTarget(nums3, 4));
        // System.out.println(findTarget(nums4, 3));
    }
}
