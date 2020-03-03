import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

public class CheckSymmetricTree_CheckList
{
    public boolean isTreeSymmetric(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        else
        {
            List<TreeNode> currentLayerNodes = new ArrayList<TreeNode>();
            Stack<TreeNode> currentLayerStack = new Stack<TreeNode>();
            Stack<TreeNode> nextLayerStack = new Stack<TreeNode>();

            currentLayerStack.push(root);

            while (!currentLayerStack.isEmpty() || !nextLayerStack.isEmpty())
            {
                if (checkListSymmetric(currentLayerNodes))
                {
                    currentLayerNodes.clear();
                    while (!currentLayerStack.isEmpty())
                    {
                        TreeNode currentNode = currentLayerStack.pop();
                        currentLayerNodes.add(currentNode);
                        if (currentNode != null)
                        {
                            nextLayerStack.push(currentNode.left);
                            nextLayerStack.push(currentNode.right);
                        }
                    }
                }
                else
                {
                    return false;
                }

                if (checkListSymmetric(currentLayerNodes))
                {
                    currentLayerNodes.clear();
                    while (!nextLayerStack.isEmpty())
                    {
                        TreeNode currentNode = nextLayerStack.pop();
                        currentLayerNodes.add(currentNode);
                        if (currentNode != null)
                        {
                            currentLayerStack.push(currentNode.left);
                            currentLayerStack.push(currentNode.right);
                        }
                    }
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean checkListSymmetric(List<TreeNode> list)
    {
        if (list.isEmpty() || list.size() == 1)
        {
            return true;
        }
        else if (list.size() > 1 && list.size() % 2 == 1)
        {
            return false;
        }

        int start = 0;
        int end = list.size() - 1;
        int mid = start + (end - start) / 2;

        for (int i = 0; i <= mid; i++)
        {
            if ((list.get(i) != null && list.get(end - i) == null)
                    || (list.get(i) == null && list.get(end - i) != null)
                    || (list.get(i) != null && list.get(end - i) != null
                            && list.get(i).val != list.get(end - i).val))
            {
                return false;
            }

        }
        return true;
    }
}
