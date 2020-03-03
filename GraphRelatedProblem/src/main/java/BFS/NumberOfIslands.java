package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	private static int[] rowAdjustment = new int[] { 1, 0, -1, 0 };
	private static int[] colAdjustment = new int[] { 0, 1, 0, -1 };
	
	public  int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int islandCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					islandCount++;
					BFSIsland(grid, new Coordinate(i, j));
				}
			}
		}
		return islandCount;
	}

	/**
	 * @param grid
	 * @param startCoordiante
	 */
	private static void BFSIsland(char[][] grid, Coordinate startCoordiante) {
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		queue.offer(startCoordiante);

		while (!queue.isEmpty()) {
			Coordinate parent = queue.poll();
			if (grid[parent.x][parent.y] == '1') {
				grid[parent.x][parent.y] = '0';
			}

			for (int i = 0; i < 4; i++) {
				int adjustedRow = parent.x + rowAdjustment[i];
				int adjustedCol = parent.y + colAdjustment[i];

				if (inbound(adjustedRow, adjustedCol, grid) && grid[adjustedRow][adjustedCol] == '1') {
					queue.offer(new Coordinate(adjustedRow, adjustedCol));
				}
			}
		}
	}

	private static boolean inbound(int adjustedRow, int adjustedCol, char[][] grid) {
		return adjustedRow >= 0 && adjustedRow < grid.length && adjustedCol >= 0 && adjustedCol < grid[0].length;
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
		NumberOfIslands solution = new NumberOfIslands();
		System.out.println(solution.numIslands(islandMap));
	}
}
