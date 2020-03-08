package Tree;

public class ValidateBinarySearchTree {
	 public boolean isValidBST(TreeNode root) {
	       if(root == null || (root.left == null && root.right == null))
	       {
	           return true;
	       }
	        
	        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	    }
	    
	    private boolean isBST(TreeNode root, int maxValue, int minValue)
	    {
	        if(root == null)
	        {
	            return true;
	        }
	        
	        if(root.val >= maxValue || root.val <= minValue)
	        {
	            return false;
	        }
	        
	        return isBST(root.left, root.val, minValue) && isBST(root.right, maxValue, root.val);
	    }
}
