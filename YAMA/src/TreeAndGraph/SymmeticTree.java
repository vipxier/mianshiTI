package TreeAndGraph;

public class SymmeticTree {

	 public boolean isSymmetric(TreeNode root) {  
		 if(root == null)
		 {
			 return true;
		 }
		 
		 return checkSymmetric(root.left, root.right);
	 }

	private boolean checkSymmetric(TreeNode left, TreeNode right) {
		if(left == null || right == null)
		{
			return left == null;
		}
		
		return checkSymmetric(left.right, right.left) && checkSymmetric(left.left, right.right);
	}
}
