package OA;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumZumbies {
	private class Coordinate {
		int x;
		int y;
		public Coordinate(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	};
	
	private int[] rowAjdustment = new int[] {0, 1, 0, -1};
	private int[] colAdjustment = new int[] {1, 0, -1, 0};
	public int minimumZonbieInfection(int[][] grid)
	{
		if(grid == null || grid.length == 0 || grid[0].length == 0)
		{
			return -1;
		}
		int humanCount = 0;
		int minHours = -1;
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		
		for(int i = 0; i< grid.length; i ++)
		{
			for(int j = 0; j < grid[0].length; j ++)
			{
				if(grid[i][j] == 1) {
					queue.offer(new Coordinate(i, j));
				}
				else
				{
					humanCount ++;
				}
			}
		}
		
		queue.offer(null);
		while(!queue.isEmpty())
		{
			Coordinate parentCoord = queue.poll();
			if(parentCoord == null)
			{
				minHours ++;
				if(queue.peek() != null)
				{
					queue.offer(null);
				}
			}
			else
			{
				for(int i = 0; i < 4; i ++)
				{
					int adjustedRow = parentCoord.x + rowAjdustment[i];
					int adjustedCol = parentCoord.y + colAdjustment[i];
					
					if(inbound(adjustedRow, adjustedCol, grid) && grid[adjustedRow][adjustedCol] == 0)
					{
						grid[adjustedRow][adjustedCol] = 1;
						humanCount --;
						queue.offer(new Coordinate(adjustedRow, adjustedCol));
					}
				}
			}
		}
		
		return humanCount == 0 ? minHours: -1;
	}
	private boolean inbound(int adjustedRow, int adjustedCol, int[][] grid) {
		return adjustedRow >= 0 && adjustedRow < grid.length && adjustedCol >=0 && adjustedCol < grid[0].length;
	}
	
	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1, 0, 1 }, 
						 { 0, 1, 0, 1, 0 }, 
						 { 0, 0, 0, 0, 1 }, 
						 { 0, 1, 0, 0, 0 } 
					   };
		MinimumZumbies solution  = new MinimumZumbies();
		System.out.println(solution.minimumZonbieInfection(grid));
	}
}
