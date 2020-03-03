

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	public static List<List<Integer>> solution(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
		{
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			List<Integer> layerList = new ArrayList<Integer>();
			int size = queue.size();
			for(int i = 0; i < size; i ++)
			{
				TreeNode node = queue.poll();
				layerList.add(node.val);
				if(node.left != null)
				{
					queue.add(node.left);
				}
				
				if(node.right != null)
				{
					queue.add(node.right);
				}
			}
			
			result.add(layerList);
		}
		
		Collections.reverse(result);
		return result;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = SerilizeDeserialize.deserialize("[1,2,3,4,5,6,7,8]");
		List<List<Integer>> result = solution(root);
		
		for(List<Integer> list : result)
		{
			for(int i : list)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
