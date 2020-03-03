package Chapter4;

public class CreateBinaryTreeFromSortedArray
{
    public static TreeNode createBinarySearchTree(int[] array)
    {
        int start = 0, end = array.length - 1;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(array[mid]);

        insertNodes(root, start, mid, array);
        insertNodes(root, mid + 1, end, array);
        
        root.insert(array[0]);
        root.insert(array[end]);

        return root;
    }

    private static void insertNodes(TreeNode root, int start, int end, int[] array)
    {
        System.out.println(start + " " + end);
        if (start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            root.insert(array[mid]);
            insertNodes(root, start, mid, array);
            insertNodes(root, mid, end, array);
        }
    }

    public static void main(String[] args)
    {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode root = createBinarySearchTree(array);
        root.inOrderTraverse();

    }
}
