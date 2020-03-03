import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.ListUtils;
import utils.TreeNode;

public class TreeSymmetric_Traverse
{
    public static boolean isTreeSystemmetric(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        else
        {
            return listSame(inorderTraverse(root.left), RInorderTraverse(root.right))
                    && listSame(preOrderTraverse(root.left), RPreOrderTraverse(root.right));
        }
    }

    private static List<Integer> inorderTraverse(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
        {
            result.add(Integer.MIN_VALUE);
            return result;
        }

        result.addAll(inorderTraverse(root.left));
        result.add(root.val);
        result.addAll(inorderTraverse(root.right));

        return result;
    }

    private static List<Integer> RInorderTraverse(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
        {
            result.add(Integer.MIN_VALUE);
            return result;
        }

        result.addAll(RInorderTraverse(root.right));
        result.add(root.val);
        result.addAll(RInorderTraverse(root.left));

        return result;
    }

    private static List<Integer> preOrderTraverse(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
        {
            result.add(Integer.MIN_VALUE);
            return result;
        }

        result.add(root.val);
        result.addAll(preOrderTraverse(root.left));
        result.addAll(preOrderTraverse(root.right));

        return result;
    }

    private static List<Integer> RPreOrderTraverse(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
        {
            result.add(Integer.MIN_VALUE);
            return result;
        }

        result.add(root.val);
        result.addAll(RPreOrderTraverse(root.right));
        result.addAll(RPreOrderTraverse(root.left));

        return result;
    }

    private static boolean listSame(List<Integer> list1, List<Integer> list2)
    {
        if (list1.size() != list2.size())
        {
            return false;
        }

        for (int i = 0; i < list1.size(); i++)
        {
            if (list1.get(i) - list2.get(i) != 0)
            {
                return false;
            }
        }
        return true;
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

        List<Integer> inorderList = inorderTraverse(node2);
        List<Integer> RinorderList = RInorderTraverse(node3);
        List<Integer> preorderiList = preOrderTraverse(node2);
        List<Integer> RPreOrderList = RPreOrderTraverse(node3);

        ListUtils.printList(inorderList);
        ListUtils.printList(RinorderList);

        ListUtils.printList(preorderiList);
        ListUtils.printList(RPreOrderList);

        System.out.println(isTreeSystemmetric(node1));
    }
}
