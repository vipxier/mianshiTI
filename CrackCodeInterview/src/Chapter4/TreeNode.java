package Chapter4;

import java.util.Stack;

public class TreeNode
{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value)
    {
        this.value = value;
        this.left = this.right = null;
    }

    public void insert(int value)
    {
        if (value <= this.value)
        {
            if (this.left == null)
            {
                this.left = new TreeNode(value);
            }
            else
            {
                this.left.insert(value);
            }
        }
        else
        {
            if (this.right == null)
            {
                this.right = new TreeNode(value);
            }
            else
            {
                this.right.insert(value);
            }
        }
    }

    public void inOrderTraverse()
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = this;

        while (currentNode != null ||!stack.isEmpty())
        {
            if (currentNode != null)
            {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else
            {
                currentNode = stack.pop();
                System.out.print(" " + currentNode.value);
                currentNode = currentNode.right;
            }
        }
    }

    public int getHeight()
    {
        if (this == null)
        {
            return 0;
        }
        else
        {
            return Math.max(left.getHeight(), right.getHeight()) + 1;
        }
    }
}
