package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNodePractice
{
    int data;
    TreeNodePractice left;
    TreeNodePractice right;

    public TreeNodePractice(int data)
    {
        this.data = data;
    }

    public void insert(int value)
    {
        if (value >= data)
        {
            if (left == null)
            {
                left = new TreeNodePractice(value);
            }
            else
            {
                left.insert(data);
            }
        }
        else
        {
            if (right == null)
            {
                right = new TreeNodePractice(value);
            }
            else
            {
                right.insert(data);
            }
        }
    }

    public boolean contains(int value)
    {
        if (data == value)
        {
            return true;
        }

        if (data <= value)
        {
            if (left == null)
            {
                return false;
            }
            else
            {
                return left.contains(value);
            }
        }
        else
        {
            if (right == null)
            {
                return false;
            }
            else
            {
                return right.contains(value);
            }
        }
    }
    
    
    public List<Integer> InOrderTraverse(TreeNodePractice root)
    {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
        {
            return result;
        }
        
        Stack<TreeNodePractice> stack = new Stack<TreeNodePractice>();
        TreeNodePractice currentNode = root;
        
        while(currentNode != null || !stack.isEmpty())
        {
            if(currentNode.left != null)
            {
                stack.push(currentNode.left);
                currentNode = currentNode.left;
            }
            else
            {
                result.add(stack.pop().data);
                currentNode = currentNode.right;
            }
        }
        
        return result;
    }
    
    
    public List<Integer> PreOrderTraverse(TreeNodePractice root)
    {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null)
        {
            return result;
        }
        
        Stack<TreeNodePractice> stack = new Stack<TreeNodePractice>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNodePractice currentNode = stack.pop();
            result.add(currentNode.data);
            if(currentNode.right != null)
            {
                stack.push(right);
            }
            
            if(currentNode.left != null)
            {
                stack.push(currentNode.left);
            }
        }
        
        return result;
    }
    
    public List<Integer> postOrderTraverse(TreeNodePractice root)
    {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
        {
            return result;
        }
        Stack<TreeNodePractice> stack = new Stack<TreeNodePractice>();
        TreeNodePractice prevNode = null;
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNodePractice currentNode = stack.peek();
            if(prevNode == null || prevNode.left == currentNode || prevNode.right == currentNode)
            {
                if(currentNode.left != null)
                {
                    stack.push(currentNode.left);
                }
                else if(currentNode.right != null)
                {
                    stack.push(currentNode.right);
                }
                else
                {
                    result.add(currentNode.data);
                    stack.pop();
                }    
            }
            else if (currentNode.left == prevNode)
            {
                if(currentNode.right != null)
                {
                    stack.push(currentNode.right);
                }
                else
                {
                    result.add(currentNode.data);
                    stack.pop();
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
                    result.add(currentNode.data);
                    stack.pop();
                }
            }
            prevNode = currentNode;
        }
        
        return result;
    }
}
