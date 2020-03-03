package PracticeCode;

import java.util.Stack;

import BinaryTree.TreeNode;

public class PracticeTreeTraverse
{

    public static void inorderTraverse_iterative(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty())
        {
            if (currentNode != null)
            {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else
            {
                currentNode  =stack.pop();
                System.out.print(" " + currentNode.data);
                currentNode = currentNode.right;
            }
        }
    }
    
    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        
        inorderTraverse_iterative(node1);
    }
}
