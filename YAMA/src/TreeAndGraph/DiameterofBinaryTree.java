package TreeAndGraph;

public class DiameterofBinaryTree {
	private class ResultType
	{
		int singlePath;
		int maxPath;
		
		public ResultType(int singlePath, int maxPath)
		{
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null)
		{
			return 0;
		}
		
		return resultTypeHelper(root).maxPath;
	}
	
	private ResultType resultTypeHelper(TreeNode root)
	{
		if(root == null)
		{
			return new ResultType(0, Integer.MIN_VALUE);
		}
		
		ResultType leftResult = resultTypeHelper(root.left);
		ResultType rightResult = resultTypeHelper(root.right);
		
		int singlePathLength = Math.max(leftResult.singlePath, rightResult.singlePath);
		
		int maxPathLength = Math.max(leftResult.maxPath, rightResult.maxPath);
		maxPathLength = Math.max(maxPathLength, leftResult.singlePath + rightResult.singlePath + 1);
		
		return new ResultType(singlePathLength, maxPathLength);
	}
}
