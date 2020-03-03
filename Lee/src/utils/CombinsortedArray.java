package utils;

public class CombinsortedArray
{
    //88
 public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int currentPointer = m + n -1;
        int index1  =m - 1;
        int index2  =n - 1;
        while(index1 >= 0 && index2 >= 0)
        {
            if(nums1[index1] > nums2[index2])
            {
                swap(nums1, index1, currentPointer);
                currentPointer--;
                index1 --;
            }
            else if(nums1[index1] <= nums2[index2])
            {
                nums1[currentPointer] = nums2[index2];
                index2--;
                currentPointer --;
            }
        }
        
        while(index1 >= 0)
        {
            swap(nums1, index1, currentPointer);
            currentPointer--;
            index1 --;
        }
        while(index2 >= 0)
        {
           nums1[currentPointer] = nums2[index2];
           currentPointer --;
           index2--;
        }
    }
    
    private static void swap(int[] nums, int index1, int index2)
    {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    public static void main(String[] args)
    {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        int m = 1;
        int n = 1;
        merge(nums1, m, nums2, n);
        ArrayUtils.printSingleDimentionArray(nums1);
    }
}
