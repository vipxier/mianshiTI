import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import utils.TreeNode;

public class CheckTreeBalanceDP
{
    public boolean isBalanced(TreeNode root) { 
        
        if(root == null || (root.left == null && root.right == null))
        {
            return true;
        }
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        Map<TreeNode, Integer> heightMap = new HashMap<TreeNode, Integer>();
        
        nodeQueue.add(root);
        
        while(!nodeQueue.isEmpty())
        {
            TreeNode currentNode = nodeQueue.poll();
            
            nodeList.add(currentNode);
            
            if(currentNode.left != null)
            {
                nodeQueue.add(currentNode.left);
            }
            
            if(currentNode.right != null)
            {
                nodeQueue.add(currentNode.right);
            }
        }
        
        Collections.reverse(nodeList);
        
        for(TreeNode node: nodeList)
        {
            int heightLeft = getTreeHeight(heightMap, node.left);
            int heightRight = getTreeHeight(heightMap, node.right);
            
            if(Math.abs(heightLeft - heightRight) <= 1)
            {
                heightMap.put(node, Math.max(heightLeft, heightRight) + 1);
            }
            else
            {
                return false;
            }
            
        }
        return true;
    }
    
    
    private int getTreeHeight(Map<TreeNode, Integer> map, TreeNode node)
    {
        if(map.containsKey(node))
        {
            return map.get(node);
        }
        else
        {
            return 0;
        }

    }
}
