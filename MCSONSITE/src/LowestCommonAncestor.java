
public class LowestCommonAncestor {
	public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q)
	{
		if(root == null || root == p || root == q)
		{
			return root;
		}
		
		TreeNode leftParent = solution(root.left, p, q);
		TreeNode rightParent = solution(root.right, p, q);
		
		if(leftParent != null && rightParent != null)
		{
			return root;
		}
		else if(leftParent != null)
		{
			return leftParent;
		}
		else if(rightParent != null)
		{
			return rightParent;
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{	
		String str= "{1,2,3,4,5,6,7,8,9}";
		
		TreeNode head = SerilizeDeserialize.deserialize(str);
		TreeNode result1 = solution(head, head.left.left.right, head.right.left); //9, 6
		System.out.println(result1.val);
		TreeNode result2 = solution(head, head.left.left.right, head.left.right); //9, 5
		System.out.println(result2.val);
	}
}
