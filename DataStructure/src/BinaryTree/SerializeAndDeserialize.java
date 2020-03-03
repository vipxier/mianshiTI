package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserialize {
	public String serialize(TreeNode root)
	{
		if(root == null)
		{
			return "[]";
		}
		
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		nodeList.add(root);
		
		for(int i = 0; i < nodeList.size(); i ++)
		{
			TreeNode currentNode = nodeList.get(i);
			
			if(currentNode != null)
			{
				nodeList.add(currentNode.left);
				nodeList.add(currentNode.right);
			}
		}
		
		while(nodeList.get(nodeList.size() - 1) == null)
		{
			nodeList.remove(nodeList.size() - 1);
		}
		
		StringBuilder strb = new StringBuilder();
		strb.append("[");
		strb.append(nodeList.get(0).data);
		
		for(int i = 1; i < nodeList.size(); i ++)
		{
			TreeNode currentNode = nodeList.get(i);
			if(currentNode == null)
			{
				strb.append(",null");
			}
			else
			{
				strb.append(",").append(currentNode.data);
			}
		}
		
		strb.append("]");
		return strb.toString();
	}
	
	public TreeNode deseralize(String str)
	{
		if(str == "[]")
		{
			return null;
		}
		
		str = str.substring(1, str.length() - 1);
		String[] nodeString = str.split(",");
		
		boolean isRight = false;
		TreeNode root = new TreeNode(Integer.parseInt(nodeString[0]));
		List<TreeNode> nodeList  = new ArrayList<TreeNode>();
		nodeList.add(root);
		int currentIndex = 0;
		for(int i = 0; i < nodeString.length; i ++)
		{
			if(!nodeString[i].contentEquals("null"))
			{
				TreeNode currentNode = new TreeNode(Integer.valueOf(nodeString[i]));
				TreeNode parentNode = nodeList.get(currentIndex);
				if(!isRight)
				{
					parentNode.left = currentNode;
				}
				else
				{
					parentNode.right = currentNode;
				}
				nodeList.add(currentNode);
				if(isRight)
				{
					currentIndex ++;
				}
				
				isRight = !isRight;
			}
		}
		
		return root;
	}
}	
