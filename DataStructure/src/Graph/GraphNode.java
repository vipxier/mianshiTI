package Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	int value;
	List<GraphNode> neighbors;
	
	public GraphNode(int value)
	{
		this.value = value;
		this.neighbors = new ArrayList<GraphNode>();
	}
	
	public int getValue()
	{
		return this.value;
	}
}
