package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
	private int[] rowAdjustment = new int[] { 1, 0, -1, 0 };
	private int[] colAdjustment = new int[] { 0, 1, 0, -1 };

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
			return;
		}

		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					queue.offer(new Coordinate(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Coordinate parent = queue.poll();
			for (int i = 0; i < 4; i++) {
				int adjustedRow = parent.x + rowAdjustment[i];
				int adjustedCol = parent.y + colAdjustment[i];

				if (inBound(adjustedRow, adjustedCol, rooms) && rooms[adjustedRow][adjustedCol] == Integer.MAX_VALUE) {
					rooms[adjustedRow][adjustedCol] = rooms[parent.x][parent.y] + 1;
					queue.offer(new Coordinate(adjustedRow, adjustedCol));
				}
			}
		}
	}

	private boolean inBound(int adjustedRow, int adjustedCol, int[][] rooms) {
		return adjustedRow >= 0 && adjustedRow < rooms.length && adjustedCol >= 0 && adjustedCol < rooms[0].length;
	}

	public static void main(String[] args) {
		WallsAndGates solution = new WallsAndGates();
		int[][] rooms = { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };
		solution.wallsAndGates(rooms);
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}
	}
}
