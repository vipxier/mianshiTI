package OA;

import java.util.LinkedList;
import java.util.Queue;

public class TraserIslanTraversal {
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

	public int traversalTraserIsland(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return -1;
		}

		Queue<Coordinate> queue = new LinkedList<Coordinate>();

		Coordinate startCoord = new Coordinate(0, 0);
		queue.offer(startCoord);
		int stepCounter = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Coordinate currentCoord = queue.poll();

				if (grid[currentCoord.x][currentCoord.y] == 'X') {
					return stepCounter;
				}

				if (grid[currentCoord.x][currentCoord.y] == 'O') {
					grid[currentCoord.x][currentCoord.y] = 'D';
				}

				for (int index = 0; index < 4; index++) {
					int adjustedRow = currentCoord.x + rowAdjustment[index];
					int adjustedCol = currentCoord.y + colAdjustment[index];

					if (inbound(adjustedRow, adjustedCol, grid)
							&& grid[adjustedRow][adjustedCol] != 'D') {
						queue.offer(new Coordinate(adjustedRow, adjustedCol));
					}
				}

			}
			stepCounter++;
		}
		return -1;
	}

	private boolean inbound(int row, int col, char[][] grid) {
		return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
	}
	
	public static void main(String[] args)
	{
		char[][] grid = {{'O', 'O', 'O', 'O'},
						 {'D', 'O', 'D', 'O'},
						 {'O', 'O', 'O', 'O'},
						 {'X', 'D', 'D', 'O'}};
		TraserIslanTraversal solution = new TraserIslanTraversal();
		System.out.println(solution.traversalTraserIsland(grid));
	}
	
}
