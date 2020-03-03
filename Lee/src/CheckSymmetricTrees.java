import utils.TreeNode;

public class CheckSymmetricTrees
{
    public boolean isSymmetric(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        else
        {
            return areSymmetric(root.left, root.right);
        }
    }

    private  boolean areSymmetric(TreeNode node1, TreeNode node2)
    {
        if (node1 == null && node2 == null)
        {
            return true;
        }
        else if ((node1 == null && node2 != null) || (node1 != null && node2 == null))
        {
            return false;
        }
        else if (node1 != null && node2 != null && node1.val == node2.val)
        {
            return areSymmetric(node1.left, node2.right) && areSymmetric(node1.right, node2.left);
        }
        else
        {
            return false;
        }
    }
    
}
