package Graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode {
	int value;
	List<DirectedGraphNode> neighbors;
	
	public DirectedGraphNode(int value)
	{
		this.value = value;
		this.neighbors = new ArrayList<DirectedGraphNode>();
	}
}
