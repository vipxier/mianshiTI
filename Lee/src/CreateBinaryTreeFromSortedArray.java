import utils.TreeNode;

public class CreateBinaryTreeFromSortedArray
{
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return null;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        return createNodeFromNums(nums, start, end);
    }
    
    private static TreeNode createNodeFromNums(int[] nums, int start, int end)
    {
        TreeNode result = null;
        if(start <= end)
        {
            int mid = start + (end - start) / 2;
            result = new TreeNode(nums[mid]);
            result.left = createNodeFromNums(nums, start, mid -1);
            result.right = createNodeFromNums(nums, mid + 1, end);
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        int[] array = {1,2,2,3,4,4,3};
        
        TreeNode tree = sortedArrayToBST(array);
    }
}
