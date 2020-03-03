import java.util.HashSet;
import java.util.Set;

import utils.TreeNode;

public class TestMap
{
    
    
    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(4);

        Set<TreeNode> set = new HashSet<TreeNode>();
        
        set.add(node1);
        set.add(node2);
        
        System.out.println(set.size());
    }
}
