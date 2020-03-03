package Chapter4;

import utils.ArrayUtils;

public class FindSumPath
{
    private static int findDepth(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        return 1 + Math.max(findDepth(node.left), findDepth(node.right));
    }
    
    private static void findsum(TreeNode node, int sum)
    {
        int depth =  findDepth(node);
        int[] path = new int[depth];
        findPath(node, path, sum, 0);
    }
    
    private static void findPath(TreeNode root, int[] path, int sum, int level)
    {
        path[level] = root.value;
        int currentSum = 0;
        for(int i = level; i >= 0; i -- )
        {
            currentSum += path[i];
            if(currentSum == sum)
            {
                ArrayUtils.printSingleDimentionArray(path);
            }
        }
        findPath(root.left, path, sum, level + 1);
        findPath(root.right, path, sum, level + 1);
    }
    
    
}   
