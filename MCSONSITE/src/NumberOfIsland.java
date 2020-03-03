
public class NumberOfIsland {
	public int numIslands(int[][] grid) {
		if (grid == null || grid[0].length == 0) {
			return 0;
		}

		int[][] islandCounter = new int[grid.length][grid[0].length];
		islandCounter[0][0] = 1;
		int maxCount =1;
		for (int i = 1; i < grid[0].length; i++) {
			if (grid[0][i] == 1) {
				if(grid[0][i - 1] == 1)
				{
					islandCounter[0][i] = islandCounter[0][i - 1];
				}
				else
				{
					islandCounter[0][i] = islandCounter[0][i - 1] + 1;
				}
				maxCount = Math.max(maxCount, islandCounter[0][i]);
			} else {
				islandCounter[0][i] = islandCounter[0][i - 1];
			}
		}

		for (int i = 1; i < grid.length; i++) {
			if(grid[i][0] == 1)
			{
				if(grid[i - 1][0] == 1)
				{
					islandCounter[i][0] = islandCounter[i - 1][0];
				}
				else
				{
					islandCounter[i][0] = islandCounter[i - 1][0] + 1;
				}
				maxCount = Math.max(maxCount, islandCounter[i][0]);
			}
			else
			{
				islandCounter[i][0] = islandCounter[i - 1][0];
			}
		}

		for (int i = 1; i < islandCounter.length; i++) {
			for (int j = 1; j < islandCounter[0].length; j++) {
				if (grid[i][j] == 1) {
					if (grid[i - 1][j] == 1 || grid[i][j - 1] == 1) {
						islandCounter[i][j] = Math.max(islandCounter[i][j - 1], islandCounter[i - 1][j]);
					} else {
						islandCounter[i][j] = maxCount + 1;
					}
				} else {
					islandCounter[i][j] = Math.max(islandCounter[i][j - 1], islandCounter[i - 1][j]);
				}
			}
		}

		return islandCounter[islandCounter.length - 1][islandCounter[0].length - 1];
	}

	public static void main(String[] args) {
		NumberOfIsland sloution = new NumberOfIsland();
		int[][] array = new int[][] { { 1, 1, 1, 0, 1 }, 
									  { 1, 1, 0, 1, 0 },
									  { 1, 1, 0, 0, 0 },
									  { 0, 1, 0, 1, 0 } };
		System.out.println(sloution.numIslands(array));
	}
}
