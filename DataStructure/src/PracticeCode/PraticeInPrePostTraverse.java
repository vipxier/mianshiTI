package PracticeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTree.TreeNode;

public class PraticeInPrePostTraverse
{
    public static List<TreeNode> inorderTraverse(TreeNode root)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (root == null)
        {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty())
        {
            if (currentNode.left != null)
            {
                stack.push(currentNode.left);
                currentNode = currentNode.left;
            }
            else
            {
                result.add(stack.pop());
                currentNode = currentNode.right;
            }
        }

        return result;
    }

    public List<TreeNode> preorderTraverse(TreeNode root)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();

        if (root == null)
        {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            TreeNode currentNode = stack.pop();
            result.add(currentNode);

            if (currentNode.right != null)
            {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null)
            {
                stack.push(currentNode.left);
            }
        }

        return result;
    }

    public List<TreeNode> postorderTravese(TreeNode root)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (root == null)
        {
            return result;
        }

        TreeNode prevNode = null;
        TreeNode currentNode = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.isEmpty())
        {
            if (prevNode == null || prevNode.left == currentNode || prevNode.right == currentNode)
            {
                currentNode = stack.peek();
                if (currentNode.left != null)
                {
                    stack.push(currentNode.left);
                }
                else if (currentNode.right != null)
                {
                    stack.push(currentNode.right);
                }
                else
                {
                    result.add(stack.pop());
                }
            }
            else if(currentNode.left == prevNode)
            {
                    if(currentNode.right != null)
                    {
                        stack.push(currentNode.right);
                    }
                    else
                    {
                        result.add(stack.pop());
                    }
            }
            else if(currentNode.right == prevNode)
            {
                if(currentNode.left != null)
                {
                    stack.push(currentNode.left);
                }
                else
                {
                    result.add(stack.pop());
                }
            }
            prevNode = currentNode;
        }
        return result;
    }
}
