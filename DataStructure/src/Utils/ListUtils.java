package Utils;

import java.util.List;

import Graph.GraphNode;

public class ListUtils {
	public static void printIntegerList(List<Integer> list)
	{
		for(int num : list)
		{
			System.out.print(num + " " );
		}
	}
	
	public static void printGraphNodeList(List<GraphNode> list)
	{
		for(GraphNode node : list)
		{
			System.out.print(node.getValue() + " " );
		}
		System.out.println();
	}
}
