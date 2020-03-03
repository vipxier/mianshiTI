package Graph;

import java.util.ArrayList;
import java.util.List;

public class FindMother {
	public int findMother(Graph graph)
	{
		boolean[] visited = new boolean[graph.getSize()];
		ArrayList<Integer>[] nodes = graph.getNodes();
		int possibleMother = -1;
		
		for(int i = 0; i < graph.getSize();  i++)
		{
			if(!visited[i])
			{
				DFS(i, visited, nodes);
				possibleMother = i;
			}
		}
		
		visited = new boolean[graph.getSize()];
		DFS(possibleMother, visited, nodes);
		for(int i = 0; i < graph.getSize();  i++)
		{
			if(!visited[i])
			{
				return -1;
			}
		}
		return possibleMother;
		
		
	}
	
	 private void DFS(int startPoint, boolean[] visited, ArrayList<Integer>[] nodes)
	 {
		 visited[startPoint] = true;
		 for(Integer neighbor : nodes[startPoint])
		 {
			 if(!visited[neighbor])
			 {
				 DFS(neighbor, visited, nodes);
			 }
		 }
	 }
	 
}
