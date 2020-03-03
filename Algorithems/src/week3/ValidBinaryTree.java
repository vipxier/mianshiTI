package week3;

public class ValidBinaryTree
{
    public static boolean validBinaryTree(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        
        if(root.left.data < root.data && root.right.data > root.data)
        {
            return validBinaryTree(root.left) && validBinaryTree(root.right);
        }
        
        return false;
    }
}
