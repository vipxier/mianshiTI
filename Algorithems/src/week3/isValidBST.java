package week3;

public class isValidBST {

	public static boolean isValidBST(TreeNode root)
	{
		if(root == null)
		{
			return true;
		}
		
		return is_bst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean is_bst(TreeNode root, int min, int max)
	{
		if(root == null)
		{
			return true;
		}
		
		if(root.data <= min || root.data >= max)
		{
			return false;
		}
		
		return is_bst(root.left, min, root.data) && is_bst(root.right, root.data, max);
	}
}
