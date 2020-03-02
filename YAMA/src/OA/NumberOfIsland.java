package OA;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
	private class Coordinate{
		int x;
		int y;
		
		public Coordinate(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	private int[] rowAdjustment = new int[] {0, 1, 0, -1};
	private int[] colAdjustment = new int[] {1, 0, -1, 0};
	
	public int getNumberOfIsland(char[][] grid)
	{
		if(grid == null || grid.length == 0 || grid[0].length == 0)
		{
			return 0;
		}
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		int islandCount = 0;
		
		for(int i = 0; i < grid.length; i ++)
		{
			for(int j = 0; j < grid[0].length; j ++)
			{
				if(grid[i][j] == '1')
				{
					BFSTraversal(grid, new Coordinate(i, j));
					islandCount ++;
				}
			}
		}
		
		return islandCount;
	}
	
	private void BFSTraversal(char[][] grid, Coordinate islandCoor)
	{
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		grid[islandCoor.x][islandCoor.y] = '0';
		queue.offer(islandCoor);
		
		while(!queue.isEmpty())
		{
			Coordinate currentCoord = queue.poll();
			if(grid[currentCoord.x][currentCoord.y] == '1')
			{
				grid[currentCoord.x][currentCoord.y] = '0';
			}
			
			for(int i = 0; i < 4; i ++)
			{
				int adjustedRow = currentCoord.x + rowAdjustment[i];
				int adjustedCol = currentCoord.y + colAdjustment[i];
				
				if(inbound(adjustedRow, adjustedCol, grid) && grid[adjustedRow][adjustedCol] == '1')
				{
					queue.offer(new Coordinate(adjustedRow, adjustedCol));
				}
			}
		}
	}
	
	private boolean inbound(int row, int col, char[][] grid)
	{
		return row >=0 && row < grid.length && col >= 0 && col < grid[0].length;
	}
	
	public static void main(String[] args) {
		char[][] islandMap = new char[][] { 
			{ '1', '1', '1', '1', '0' }, 
			{ '0', '0', '0', '1', '0' },
			{ '0', '0', '1', '0', '0' }, 
			{ '0', '0', '0', '1', '0' }, 
			{ '0', '0', '1', '0', '0' },
			{ '1', '1', '1', '1', '1' } 
			};
		char[][] map = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};	
		NumberOfIsland solution = new NumberOfIsland();
		System.out.println(solution.getNumberOfIsland(map));
		System.out.println(solution.getNumberOfIsland(islandMap));
	}
}
