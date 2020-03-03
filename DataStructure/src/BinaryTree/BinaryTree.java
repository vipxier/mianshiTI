package BinaryTree;

import java.util.Stack;

public class BinaryTree
{
    TreeNode root;
    
    /**
     * Java method to create binary tree with test data
     * 
     * @return a sample binary tree for testing
     */
    public static BinaryTree create() {
      BinaryTree tree = new BinaryTree();
      TreeNode root = new TreeNode(4);
      tree.root = root;
      tree.root.left = new TreeNode(2);
      tree.root.left.left = new TreeNode(1);

      tree.root.left.right = new TreeNode(3);
      tree.root.right = new TreeNode(5);
      tree.root.right.right = new TreeNode(6);

      return tree;
    }
    
    public static void main(String[] args)
    {
        BinaryTree tree = create();
        System.out.println("Inorder traverse with recursion: ");
        tree.inorderTraverseRecursion();
        System.out.println("Inorder traverse with iteration: ");
        tree.inorderTraverseIteration();
    }
    
    
    public void inorderTraverseRecursion()
    {
        inorderTraverseRecursion(root);
    }
    
    public void inorderTraverseRecursion(TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        
        inorderTraverseRecursion(node.left);
        System.out.printf("%s ", node.data);
        inorderTraverseRecursion(node.right);
    }
    
    
    public void inorderTraverseIteration()
    {
        inorderTraverseIteration(root);
    }
    
    public void inorderTraverseIteration(TreeNode node)
    {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode currentNode = node;
        
        while(currentNode != null || !nodeStack.isEmpty())
        {
            if(currentNode != null)
            {
                nodeStack.add(currentNode);
                currentNode = currentNode.left;
            }
            else
            {
                currentNode = nodeStack.pop();
                System.out.printf("%s ", currentNode.data);
                currentNode = currentNode.right;
            }
        }
    }
    
    public void preOrderTraverseRecursion()
    {
        preOrderTraverseRecursion(root);
    }
    
    public void preOrderTraverseRecursion(TreeNode node)
    {}
    
    public void postOrderTraverseRecursion()
    {
        preOrderTraverseRecursion(root);
    }
    
    public void postOrderTraverseRecursion(TreeNode node)
    {}
    
    
    public static void insert(int data)
    {
    	
    }
}
