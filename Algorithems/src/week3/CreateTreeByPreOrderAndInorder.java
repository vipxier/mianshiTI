package week3;

public class CreateTreeByPreOrderAndInorder {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}

		return buildTree(preorder, inorder, 0, preorder.length - 1, 0);
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, int preorderIndex) {
		if (start > end) {
			return null;
		}

		TreeNode currentNode = new TreeNode(preorder[preorderIndex]);
		if (start == end) {
			return currentNode;
		}

		preorderIndex = search(currentNode.data, inorder, start, end);

		currentNode.left = buildTree(preorder, inorder, start, preorderIndex - 1, preorderIndex);
		currentNode.right = buildTree(preorder, inorder, preorderIndex + 1, end, preorderIndex);

		return currentNode;

	}

	private static int search(int currentNodeValue, int[] inorder, int start, int end) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == currentNodeValue) {
				return i;
			}		
		}
		return -1;
	}
}
