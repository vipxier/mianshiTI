package Chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ListForEachLayer
{
    public static Map<Integer, List<Integer>> createLists(TreeNode root)
    {
        Stack<TreeNode> currentLayerNodes = new Stack<TreeNode>();
        Stack<TreeNode> nextLayerNodes = new Stack<TreeNode>();
        Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
        currentLayerNodes.add(root);
        int layerNumber = 0;
        while (!currentLayerNodes.isEmpty() || !nextLayerNodes.isEmpty())
        {
            List<Integer> layerData = new ArrayList<Integer>();
            while (!currentLayerNodes.isEmpty())
            {
                TreeNode currentNode = currentLayerNodes.pop();
                layerData.add(currentNode.value);

                if (currentNode.left != null)
                {
                    nextLayerNodes.push(currentNode.left);
                }

                if (currentNode.right != null)
                {
                    nextLayerNodes.push(currentNode.right);
                }
            }

            if (!layerData.isEmpty())
            {
                result.put(layerNumber++, new ArrayList<Integer>(layerData));
            }

            layerData.clear();

            while (!nextLayerNodes.isEmpty())
            {
                TreeNode currentNode = nextLayerNodes.pop();
                layerData.add(currentNode.value);

                if (currentNode.left != null)
                {
                    currentLayerNodes.push(currentNode.left);
                }

                if (currentNode.right != null)
                {
                    currentLayerNodes.push(currentNode.right);
                }
            }
            if (!layerData.isEmpty())
            {
                result.put(layerNumber++, layerData);
            }

        }
        return result;
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.insert(3);
        root.insert(7);
        root.insert(2);
        root.insert(4);
        root.insert(6);
        root.insert(10);
        
        Map<Integer, List<Integer>> map = createLists(root);
        System.out.println(map);
        
    }
}
