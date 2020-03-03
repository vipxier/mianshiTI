package week3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import utils.StackUtils;

public class ConstructTreeFromPreorderAndInorder
{
    
    public static int preorderIndex = 0;
    public static TreeNode createTree(int[] preorder, int[] inorder)
    {
        if(preorder == null || inorder == null || inorder.length == 0 || preorder.length == 0 || preorder.length != inorder.length)
        {
            return null;
        }
        
        return constructNode(preorder, inorder, 0, inorder.length-1);
    }
    
    private static TreeNode constructNode(int[] preorder, int[] inorder, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        
        TreeNode currentNode = new TreeNode(preorder[preorderIndex++]);
        if (start == end)
        {
            return currentNode;
        }
        
        int inorderIndex = search(inorder, start, end, currentNode.data);
        if(inorderIndex == -1)
        {
            return null;
        }
        
        currentNode.left = constructNode(preorder, inorder, start, inorderIndex - 1);
        currentNode.right = constructNode(preorder, inorder, inorderIndex + 1, end);
        return currentNode;
    }
    
    private static int search(int[] array, int start, int end, int target)
    {
        for(int i = start; i <= end; i ++)
        {
            if(array[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    
    
    private static void inorderTraverseTree(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode currentNode = stack.peek();
            System.out.print(" " + stack.pop().data);
            
            if(currentNode.right != null)
            {
                stack.push(currentNode.right);
            }
            if(currentNode.left != null)
            {
                stack.push(currentNode.left);
            }
        }
        StackUtils.printStack(stack);
    }
    
    public static void main(String[] args)
    {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        
        TreeNode root = createTree(preorder, inorder);
        
        inorderTraverseTree(root);
    }
    public static int pIndex = 0;
    public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static TreeNode buildTree(int[] po, int[] io)
    {
        if(po == null || io == null || po.length != io.length || po.length == 0)
        {
            return null;
        }
        
        for(int i = 0; i < io.length; i ++)
        {
            map.put(io[i], i);
        }
        
        return createTree(po, io, 0, po.length - 1);
    }
    
    public static TreeNode createTree(int[] po, int[] io, int start, int end)
    {
        if(start > end)
        {
            return null;
        }
        int inorderIndex = map.get(po[pIndex]);
        TreeNode currentNode = new TreeNode(io[map.get(po[pIndex])]);
        pIndex++;
        if(start == end)
        {
            return currentNode;
        }
        
        currentNode.left = createTree(po, io, start, inorderIndex-1);
        currentNode.right = createTree(po, io, inorderIndex + 1, end);
        return currentNode;
    }
}



