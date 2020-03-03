package BinaryTree;

public class BinarySearchTree
{
    TreeNode root;
    
    public BinarySearchTree(TreeNode root)
    {
        this.root = root;
    }
    
    public void insert(TreeNode node)
    {
        this.root.insert(node.data);
    }
    
    
}
