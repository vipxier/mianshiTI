import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

public class SerilizeDeserialize {
	public static String serialize(TreeNode root) {
        if(root == null)
        {
            return "[]";
        }
        
        StringBuilder strb = new StringBuilder();
        strb.append('[');
        List<TreeNode> list = new ArrayList<>();
        
        list.add(root);
        for(int i = 0; i < list.size(); i ++)
        {
        	TreeNode node = list.get(i);
        	if(node == null)
        	{
        		continue;
        	}
        	list.add(node.left);
        	list.add(node.right);
        }
        
        for(int i = list.size() - 1; i >= 0; i --)
        {
            if(list.get(i) == null)
            {
                list.remove(i);
            }
            else
            {
                break;
            }
        }
        
        strb.append(list.get(0).val);
        
        for(int i = 1; i < list.size(); i ++)
        {
            TreeNode node = list.get(i);
            if(node == null)
            {
                strb.append(",null");
            }
            else
            {
                strb.append(",").append(node.val);
            }
        }
        
        strb.append("]");
        
        return strb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("[]"))
        {
            return null;
        }
        
        String[] strArray = data.substring(1, data.length() - 1).split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int index = 1;
        boolean isLeftNode = true;
        
        while(!queue.isEmpty())
        {
            TreeNode rootNode = queue.poll();
            while(index < strArray.length)
            {
                if(!strArray[index].equals("null")){
                    TreeNode childNode = new TreeNode(Integer.parseInt(strArray[index]));
                    if(isLeftNode)
                    {
                        rootNode.left = childNode;
                    }
                    else
                    {
                        rootNode.right  = childNode;
                    }
                    queue.offer(childNode);
                }
                index ++;
                if(!isLeftNode)
                {
                	isLeftNode = true;
                    break;
                }
                isLeftNode = !isLeftNode;
            }
        }
        return root;
    }
    
    public static void main(String[] args)
    {
    	String str = "[1,2,3]";
    	TreeNode root = deserialize(str);
    	System.out.println(serialize(root));
    }
    
}
