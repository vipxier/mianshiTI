package TreeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSerializeAndDeserialize {
	public String serailize(TreeNode root) {
		if (root == null) {
			return "[]";
		}
		StringBuilder strb = new StringBuilder();
		strb.append("[");
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		nodeList.add(root);
		for (int i = 0; i < nodeList.size(); i++) {
			TreeNode currentNode = nodeList.get(i);
			
			if (currentNode == null) {
				continue;
			}
			
			nodeList.add(currentNode.left);
			nodeList.add(currentNode.right);
		}
		
		while(nodeList.size() >= 0 && nodeList.get(nodeList.size() - 1) == null)
		{
			nodeList.remove(nodeList.size() - 1);
		}
		
		strb.append(root.val);
		for(int i = 1; i < nodeList.size(); i ++)
		{
			TreeNode currentNode = nodeList.get(i);
			if(currentNode == null)
			{
				strb.append(",#");
			}
			else
			{
				strb.append(",").append(currentNode.val);
			}
		}
		
		strb.append("]");
		
		return strb.toString();
	}

	public TreeNode deserailize(String str) {
		if (str == "[]") {
			return null;
		}

		str = str.substring(1, str.length() - 1);
		String[] strArray = str.split(",");

		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
		nodeList.add(root);

		int currentIndex = 0;
		boolean isRightNode = false;
		for (int i = 1; i < strArray.length; i++) {
			if (!strArray[i].contentEquals("#")) {
				TreeNode currentNode = new TreeNode(Integer.parseInt(strArray[i]));
				if (!isRightNode) {
					nodeList.get(currentIndex).left = currentNode;
				} else {
					nodeList.get(currentIndex).right = currentNode;
				}
				nodeList.add(currentNode);
			}

			if (isRightNode) {
				currentIndex++;
			}

			isRightNode = !isRightNode;
		}

		return nodeList.get(0);
	}

	public static void main(String[] args) {

		String treeString = "[1,2,3,4,#,5,6]";
		TreeSerializeAndDeserialize solution = new TreeSerializeAndDeserialize();
		TreeNode root = solution.deserailize(treeString);
		System.out.println(solution.serailize(root));
	}
}
