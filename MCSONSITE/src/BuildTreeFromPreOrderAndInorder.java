
public class BuildTreeFromPreOrderAndInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0
				|| preorder.length != inorder.length) {
			return null;
		}

		return buildTreeFromPreOrderInorder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTreeFromPreOrderInorder(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart,
			int iEnd) {
		if(iStart > iEnd)
        {
            return null;
        }
		int rootIndex = findIndex(inorder, iStart, iEnd, preorder[pStart]);
		TreeNode root = new TreeNode(preorder[rootIndex]);

		root.left = buildTreeFromPreOrderInorder(preorder, pStart + 1, pStart + rootIndex - iStart, inorder, iStart,
				rootIndex - 1);
		root.right = buildTreeFromPreOrderInorder(preorder, pStart + rootIndex - iStart + 1, pEnd, inorder,
				rootIndex + 1, iEnd);
		return root;
	}

	private int findIndex(int[] array, int startIndex, int endIndex, int value) {
		for (int i = startIndex; i <= endIndex; i++) {
			if (array[i] == value) {
				return i;
			}
		}

		return -1;
	}
}
