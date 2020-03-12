package ReviewQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
	private class Coordinate
	{
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
	
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
		{
			return 0;
		}
		
		int islandCount = 0;
		for(int i = 0; i < grid.length; i ++)
		{
			for(int j = 0; j < grid[0].length; j ++)
			{
				if(grid[i][j] == '1')
				{
					islandCount ++;
					BFSTraverse(grid, new Coordinate(i, j));
					//bruteForce(grid, i, j);
				}
			}
		}
		
		return islandCount;
	}
	
	private void bruteForce(char[][] grid, int row, int col)
	{
		if(grid[row][col] == '1')
		{
			grid[row][col] = '0';
		}
		
		if(row + 1 < grid.length && grid[row + 1][col] == '1')
		{
			bruteForce(grid, row + 1, col);
		}
		
		if(row - 1 >= 0 && grid[row - 1][col] == '1')
		{
			bruteForce(grid, row - 1, col);
		}
		
		if(col + 1 < grid.length && grid[row][col + 1] == '1')
		{
			bruteForce(grid, row , col + 1);
		}
		
		if(col - 1 >= 0 && grid[row][col - 1] == '1')
		{
			bruteForce(grid, row, col - 1);
		}
	}
	
	
	private void BFSTraverse(char[][] grid, Coordinate coord)
    {
        Queue<Coordinate> queue = new LinkedList<>();
        
        queue.offer(coord);
        
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
		return row >=0 && row < grid.length && col >=0 && col < grid[0].length;
	}
	
	
	public static void main(String[] args)
    {
    	char[][] map = {{'1','1','1','1','0'},
    					{'1','1','0','1','0'},
    					{'1','1','0','0','0'},
    					{'0','0','0','0','0'}};
    	NumberOfIsland solution = new NumberOfIsland();
    	System.out.println(solution.numIslands(map));
    	
    }
}
