package BinaryTree;

import java.util.Stack;

public class TreeNode
{
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data)
    {
        this.data = data;
    }

    public boolean isLeaf()
    {
        return this.left == null && this.right == null;
    }

    public void insert(int value)
    {
        if (value >= data)
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

    public boolean contains(int value)
    {
        if (this.data == value)
        {
            return true;
        }

        if (this.data < value)
        {
            if (this.left == null)
            {
                return false;
            }
            else
            {
                return this.left.contains(value);
            }
        }
        else
        {
            if (this.right == null)
            {
                return false;
            }
            else
            {
                return this.right.contains(value);
            }
        }
    }

    public void printInOrder()
    {
        if (this.left != null)
        {
            this.left.printInOrder();
        }
        System.out.print(" " + this.data);
        if (this.right != null)
        {
            this.right.printInOrder();
        }
    }

    public void printPreOrder()
    {
        System.out.print(" " + this.data);
        if (this.left != null)
        {
            this.left.printPreOrder();
        }

        if (this.right != null)
        {
            this.right.printPreOrder();
        }
    }

    public void printPostOrder()
    {
        if (this.left != null)
        {
            this.left.printPreOrder();
        }

        if (this.right != null)
        {
            this.right.printPreOrder();
        }
        System.out.print(" " + this.data);
    }

    public void InOrderTraverse(TreeNode node)
    {
        if (node == null)
        {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = node;
        while (node != null || !stack.isEmpty())
        {
            if (node != null)
            {
                stack.push(currentNode);
                currentNode = node.left;
            }
            else
            {
                currentNode = stack.pop();
                System.out.print(currentNode.data);
                currentNode = currentNode.right;
            }
        }
    }

    public void preOrderTraverse(TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty())
        {
            TreeNode currentNode = stack.pop();
            System.out.print(" " + currentNode.data);
            if (currentNode.right != null)
            {
                stack.push(right);
            }

            if (currentNode.left != null)
            {
                stack.push(left);
            }
        }

    }

    public void postOrderTraverse(TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prevNode = null;
        stack.push(node);

        while (!stack.isEmpty())
        {
            TreeNode currentNode = stack.peek();

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
                    stack.pop();
                    System.out.print(" " + currentNode.data);
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
                    System.out.print(" " + currentNode.data);
                    stack.pop();
                }
            }
            else if (currentNode.right == prevNode)
            {
                if (currentNode.left != null)
                {
                    stack.push(currentNode.left);
                }
                else
                {
                    System.out.print(" " + currentNode.data);
                }
            }

            prevNode = currentNode;
        }

    }

    public TreeNode deleteNode(TreeNode root, int value)
    {
        if (root == null)
        {
            return null;
        }

        if (root.data > value)
        {
            root.left = deleteNode(root.left, value);
        }
        else if (root.data < value)
        {
            root.right = deleteNode(root.right, value);
        }
        else
        {
            if (root.left != null && root.right != null)
            {
                TreeNode temp = root;
                TreeNode minimumNode = minimumNode(temp.right);
                root.data = minimumNode.data;
                deleteNode(root.right, minimumNode.data);

            }
            else if (root.left != null)
            {
                root = root.left;
            }
            else if (root.right != null)
            {
                root = root.right;
            }
            else
            {
                root = null;
            }
        }
        return root;
    }

    public TreeNode minimumNode(TreeNode root)
    {
        if (root.left == null)
        {
            return root;
        }
        else
        {
            return minimumNode(root.left);
        }
    }

}
