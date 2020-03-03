package Array_Widow_Sliding;

public class FindIsland {
	public int numIslands(char[][] grid) {

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					traverseIslands(grid, i, j);
					count++;
				}
 
			}
		}
		return count;
	}

	private void traverseIslands(char[][] grid, int i, int j) {
		// Set the visited land to '0' as it is already included as a part of the island
		grid[i][j] = '0';

		// Check recursively for all four neighbours for a given land.
		if (i + 1 < grid.length && grid[i + 1][j] == '1') {
			traverseIslands(grid, i + 1, j);
		}
		if (i - 1 >= 0 && grid[i - 1][j] == '1') {
			traverseIslands(grid, i - 1, j);
		}

		if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
			traverseIslands(grid, i, j + 1);
		}
		if (j - 1 >= 0 && grid[i][j - 1] == '1') {
			traverseIslands(grid, i, j - 1);
		}
	}

}
