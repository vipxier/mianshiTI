
public class GetParentNode {
	
	public static TreeNode solution(TreeNode root, TreeNode targetNode)
	{
		if(root == null || targetNode.val == root.val)
		{
			return root;
		}
		
		if((root.left != null && root.left.val == targetNode.val) || (root.right != null && root.right.val == targetNode.val))
		{
			return root;
		}
		
		TreeNode leftResult = solution(root.left, targetNode);
		if(leftResult != null) {
			return leftResult;
		}
		
		TreeNode rightResult = solution(root.right, targetNode);
		if(rightResult != null)
		{
			return rightResult;
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		String str= "{1,2,3,4,5,6,7,8,9}";
		
		TreeNode head = SerilizeDeserialize.deserialize(str);
		TreeNode result1 = solution(head, head.left.right); //5
		System.out.println(result1.val);
		TreeNode result2 = solution(head, head.left.left.right); //9
		System.out.println(result2.val);
	}
}
