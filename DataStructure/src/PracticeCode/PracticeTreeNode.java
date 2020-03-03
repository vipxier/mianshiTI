package PracticeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PracticeTreeNode
{
    PracticeTreeNode left;
    PracticeTreeNode right;
    int value;

    public PracticeTreeNode(int value)
    {
        this.value = value;
        this.left = this.right = null;
    }

    public void insert(PracticeTreeNode root, int value)
    {
        if (root == null)
        {
            root = new PracticeTreeNode(value);
        }
        else
        {
            if (root.value >= value)
            {
                insert(root.left, value);
            }
            else
            {
                insert(root.right, value);
            }
        }

    }

    public PracticeTreeNode delete(PracticeTreeNode root, int value)
    {
        if (root == null)
        {
            return null;
        }

        if (root.value > value)
        {
            return delete(root.left, value);
        }
        else if (root.value < value)
        {
            return delete(root.right, value);
        }
        else
        {
            if (root.left == null && root.right == null)
            {
                PracticeTreeNode temp = root;
                root.value = getMiniNode(temp.right).value;
                delete(root.right, root.value);
            }
            else if (root.left == null)
            {
                root = root.right;
            }
            else if (root.right == null)
            {
                root = root.left;
            }
            else
            {
                root = null;
            }
        }
        return root;
    }

    private PracticeTreeNode getMiniNode(PracticeTreeNode root)
    {
        if (root.left == null)
        {
            return root;
        }
        else
        {
            return getMiniNode(root.left);
        }
    }

    public List<Integer> preOrderTraverse(PracticeTreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
        {
            return result;
        }

        Stack<PracticeTreeNode> stack = new Stack<PracticeTreeNode>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            PracticeTreeNode currentNode = stack.pop();

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

    public List<Integer> inorderTraverse(PracticeTreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
        {
            return result;
        }

        Stack<PracticeTreeNode> stack = new Stack<PracticeTreeNode>();
        PracticeTreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty())
        {
            if (currentNode != null)
            {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else
            {
                currentNode = stack.pop();
                result.add(currentNode.value);
                currentNode = currentNode.right;
            }
        }
        return result;
    }

    public List<Integer> postOrderTraverse(PracticeTreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
        {
            return result;
        }

        PracticeTreeNode prevNode = null;
        PracticeTreeNode currentNode = root;
        Stack<PracticeTreeNode> stack = new Stack<PracticeTreeNode>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            currentNode = stack.peek();

            if (prevNode == null || prevNode.left == currentNode || prevNode.right == currentNode)
            {
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
                    result.add(stack.pop().value);
                }
            }
            else if (currentNode.left == prevNode)
            {
                if (currentNode.right != null)
                {
                    stack.push(currentNode.right);
                }
                else
                {
                    result.add(stack.pop().value);
                }
            }
            else if (currentNode.right == prevNode)
            {
                result.add(stack.pop().value);
            }

            prevNode = currentNode;
        }
        return result;
    }
}
