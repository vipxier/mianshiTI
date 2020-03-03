import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.ListUtils;
import utils.TreeNode;

public class CheckForTreeBalance
{
    public static boolean isBalanced(TreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return true;
        }
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty())
        {
           TreeNode currenNode = nodeQueue.poll();
            if(checkBalanceTree(currenNode.left, currenNode.right))
            {
                if(currenNode.left != null)
                {
                    nodeQueue.add(currenNode.left);
                }
                
                if(currenNode.right != null)
                {
                    nodeQueue.add(currenNode.right);
                }
            }
            else
            {
                return false;
            }
        }
        return true;
        
    }

    private static boolean checkBalanceTree(TreeNode node1, TreeNode node2)
    {
        if ((node1 == null && node2 == null))
        {
            return true;
        }
        else if (Math.abs(heightOfTree(node1) - heightOfTree(node2)) <= 1)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    private static int heightOfTree(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.left == null && root.right == null)
        {
            return 1;
        }

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
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
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
        
        System.out.println(isBalanced(node1));
    }
}
