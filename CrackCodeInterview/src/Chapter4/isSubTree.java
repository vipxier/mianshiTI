package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class isSubTree
{
    public static boolean isSubTreeOf(TreeNode node1, TreeNode node2)
    {
        List<TreeNode> preOrderlist1 = preOrderTraversal(node1);
        List<TreeNode> preOrderlist2 = preOrderTraversal(node2);
        List<TreeNode> inorderList1  = inorderTraversal(node1);
        List<TreeNode> inorderList2  = inorderTraversal(node2);
        
        return preOrderlist1.containsAll(preOrderlist2) && inorderList1.containsAll(inorderList2);
    }
    
    private static List<TreeNode> preOrderTraversal(TreeNode root)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode currentNode = stack.pop();
            
            result.add(new TreeNode(currentNode.value));
            if(currentNode.right != null)
            {
                stack.push(currentNode.right);
            }
            
            if(currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        
        return result;
    }
    
    private static List<TreeNode> inorderTraversal(TreeNode root)
    {
        List<TreeNode> result = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode currentNode = root;
                
        while(currentNode != null || !stack.isEmpty())
        {
           if(currentNode != null)
           {
               stack.push(currentNode);
               currentNode = currentNode.left;
           }
           else
           {
               currentNode = stack.pop();
               result.add(new TreeNode(currentNode.value));
               currentNode = currentNode.right;
               
           }
        }
        return result;
    }
}
