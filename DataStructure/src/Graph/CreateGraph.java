package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateGraph {

	public static List<GraphNode> crateGraph(String[] nodeInfo) {
		List<GraphNode> nodeList = new ArrayList<GraphNode>();
		if (nodeInfo == null || nodeInfo.length == 0) {
			return nodeList;
		}

		Map<Integer, GraphNode> hashMap = new HashMap<Integer, GraphNode>();

		for (int i = 0; i < nodeInfo.length; i++) {
			String str = nodeInfo[i];
			String[] nodesString = str.split(",");
			if (!hashMap.containsKey(Integer.parseInt(nodesString[0]))) {
				GraphNode graphNode = new GraphNode(Integer.parseInt(nodesString[0]));
				hashMap.put(Integer.parseInt(nodesString[0]), graphNode);	
			}
			nodeList.add(hashMap.get(Integer.parseInt(nodesString[0])));
			
			if (nodesString.length > 1) {
				for (String neighbor : nodesString[1].split(" ")) {
					if (neighbor.length() > 0) {
						if (!hashMap.containsKey(Integer.parseInt(neighbor))) {
							GraphNode newNeighbor = new GraphNode(Integer.parseInt(neighbor));
							hashMap.put(Integer.parseInt(neighbor), newNeighbor);

						}
						hashMap.get(Integer.parseInt(nodesString[0])).neighbors
								.add(hashMap.get(Integer.parseInt(neighbor)));
					}
				}
			}
		}

		return nodeList;
	}

	public static void main(String[] args) {
		String[] strings = new String[] { "0,1 2 8", "1,3", "2,1 4", "3, 2 5", "4,5", "5,6", "6,7", "7,4", "8,2" };

		List<GraphNode> nodes = crateGraph(strings);

		for (GraphNode graphNode : nodes) {
			System.out.println("Node " + graphNode.value + " neighbors: ");
			for (GraphNode neighbor : graphNode.neighbors) {
				System.out.print(neighbor.value + " ");
			}

			System.out.println();
		}
	}
}
