package OA;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_1 {
	
	private class Coordinate
	{
		int x;
		int y;
		
		public Coordinate(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	};
	
	private int[] rowAdjustment = new int[] {0, 1, 0 ,-1};
	private int[] colAdjustment = new int[] {1, 0, -1 ,0};
	
	public int getNumberOfIsland(char[][] map)
	{
		if(map == null || map.length == 0 || map[0].length == 0)
		{
			return 0;
		}
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		int islandCount = 0;
		for(int i = 0; i < map.length; i ++)
		{
			for(int j = 0; j < map[0].length; j ++)
			{
				if(map[i][j] == '1')
				{
					BFSTraversal(map, new Coordinate(i, j));
					islandCount ++;
				}
			}
		}
		return islandCount;
		
	}
	
	private void BFSTraversal(char[][] map, Coordinate islandCoord)
	{
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		queue.offer(islandCoord);
		
		while(!queue.isEmpty())
		{
			Coordinate parentCoor = queue.poll();
			
			for(int i = 0; i < 4; i ++)
			{
				int adjustedRow = parentCoor.x + rowAdjustment[i];
				int adjustedCol = parentCoor.y + colAdjustment[i];
				
				if(inbound(adjustedRow, adjustedCol, map) && map[adjustedRow][adjustedCol] == '1')
				{
					 map[adjustedRow][adjustedCol] = '0';
					 queue.offer(new Coordinate(adjustedRow, adjustedCol));
				}
			}
		}
	}
	
	private boolean inbound(int row, int col, char[][] matrix)
	{
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
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
		NumberOfIsland_1 solution = new NumberOfIsland_1();
		System.out.println(solution.getNumberOfIsland(map));
	}
	
}	
