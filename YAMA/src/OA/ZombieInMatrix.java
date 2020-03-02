package OA;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {
	/**
	 * @param grid: a 2D integer grid
	 * @return: an integer
	 */
	private class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private int[] rowAdjustment = new int[] { 0, 1, 0, -1 };
	private int[] colAdjustment = new int[] { 1, 0, -1, 0 };

	public int zombie(int[][] grid) {
		// write your code here
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}

		int humanCount = 0;
		int hourCount = 0;

		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new Coordinate(i, j));
				} else if (grid[i][j] == 0) {
					humanCount++;
				}
			}
		}

		queue.offer(null);
		while (!queue.isEmpty()) {
			Coordinate parentCoord = queue.poll();
			if (parentCoord == null) {
				hourCount++;
				if (queue.peek() != null) {
					queue.offer(null);
				}
			} else {
				for (int i = 0; i < 4; i++) {
					int adjustedRow = parentCoord.x + rowAdjustment[i];
					int adjustedCol = parentCoord.y + colAdjustment[i];

					if (inbound(adjustedRow, adjustedCol, grid) && grid[adjustedRow][adjustedCol] == 0) {
						grid[adjustedRow][adjustedCol] = 1;
						humanCount--;
						queue.offer(new Coordinate(adjustedRow, adjustedCol));
					}
				}
			}
		}

		return humanCount == 0 ? hourCount - 1 : -1;
	}

	private boolean inbound(int row, int col, int[][] matrix) {
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
	}
}
