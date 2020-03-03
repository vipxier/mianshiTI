package Chapter4;

public class FindCommonAncestor
{
    public TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2)
    {
        if(!isCovered(root, node1) || !isCovered(root, node2))
        {
            return null;
        }
        
        return findCommonAncestor(root, node1, node2);
    }
    
    private static boolean isCovered(TreeNode root, TreeNode node)
    {
        if(root == null)
        {
            return false;
        }
        
        if(root == node)
        {
            return true;
        }
        
        return isCovered(root.left, node) || isCovered(root.right, node);
    }
    
    private static TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2)
    {
        if (root == null)
        {
            return null;
        }
        
        boolean node1_at_left = isCovered(root.left, node1);
        boolean node2_at_left = isCovered(root.left, node2);
        
        if(node1_at_left != node2_at_left)
        {
            return root;
        }
        
       TreeNode searchRoot = node1_at_left ? root.left : root.right;
       return findCommonAncestor(searchRoot, node1, node2);
        
    }
}
