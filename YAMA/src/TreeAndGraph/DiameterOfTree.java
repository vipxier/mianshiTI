package TreeAndGraph;

public class DiameterOfTree {
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = 0;
		if (root.left != null) {
			leftHeight = getHeight(root.left);
		}
		int rightHeight = 0;
		if (root.right != null) {
			rightHeight = getHeight(root.right);
		}
		return leftHeight + rightHeight;
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	
int max = 0;
    
    public int diameterOfBinaryTree_solution(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
//	public int diameterOfBinaryTree_Solution(TreeNode root)
//	{
//		return sumOfHeight(root, 0);
//	}
//	
//	private int sumOfHeight(TreeNode root, int maxHeight)
//	{
//		if(root == null)
//		{
//			return 0;
//		}
//		
//		int leftHeight = sumOfHeight(root.left, maxHeight);
//		int rightHeight = sumOfHeight(root.right, maxHeight);
//		
//		maxHeight = Math.max(leftHeight + rightHeight, maxHeight);
//		
//		return Math.max(leftHeight, rightHeight) + 1;
//	}
	

	public static void main(String[] args) {
		TreeNode root = TreeSerializeAndDeserialize.deserailize("[1,2,3,4,#,5,6,#,#,7,8]");
		DiameterOfTree solution = new DiameterOfTree();
		//System.out.println(solution.diameterOfBinaryTree(root));

		TreeNode root1 = TreeSerializeAndDeserialize.deserailize("[1,2]");
		//System.out.println(solution.diameterOfBinaryTree(root1));

		TreeNode root2 = TreeSerializeAndDeserialize
				.deserailize("[4,-7,-3,#,#,-9,-3,9,-7,-4,#,6,#,-6,-6,#,#,0,6,5,#,9,#,#,-1,-4,#,#,#,-2]");
		System.out.println(solution.diameterOfBinaryTree_solution(root2));
	}
}
