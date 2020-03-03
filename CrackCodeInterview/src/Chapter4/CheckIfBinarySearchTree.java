package Chapter4;

public class CheckIfBinarySearchTree
{
    public static boolean isBinarySearchTree(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        
        else if(root.left != null && root.right != null && (root.left.value > root.value || root.right.value < root.value))
        {
            return false;
        }
            
        else  if(root.left != null && root.right == null && root.left.value > root.value)
        {
            return false;
        }
        
        else if(root.right != null && root.left == null && root.right.value < root.value)
        {
            return false;
        }
        
        return (isBinarySearchTree(root.left) && isBinarySearchTree(root.right));
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.insert(3);
        root.insert(3);
        root.insert(2);
        root.insert(10);
        root.insert(12);
        root.insert(1);
        root.insert(20);
        
        System.out.println(isBinarySearchTree(root));
    }
}
