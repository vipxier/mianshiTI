package TreeAndGraph;

public class TreeMaxmumHeight {
	public int getHeight(TreeNode root)
	{
		
		if(root == null)
		{
			return 0;
		}
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	
	public static void main(String[] args)
	{
		TreeNode root = TreeSerializeAndDeserialize.deserailize("[1,2,3,4,#,5,6,#,#,7,8]");
		TreeMaxmumHeight solution = new TreeMaxmumHeight();
		System.out.println(solution.getHeight(root));
	}
	
}
