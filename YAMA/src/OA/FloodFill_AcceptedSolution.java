package OA;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill_AcceptedSolution {
	private class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image.length == 0 || image[0].length == 0) {
			return image;
		}
		boolean[][] visited = new boolean[image.length][image[0].length];
		int[] rowAdjustment = new int[] { 0, 1, 0, -1 };
		int[] colAdjustment = new int[] { 1, 0, -1, 0 };

		Queue<Coordinate> queue = new LinkedList<>();
		queue.offer(new Coordinate(sr, sc));
		int startColor = image[sr][sc];
		if (startColor == newColor) {
			return image;
		}
		while (!queue.isEmpty()) {
			Coordinate coor = queue.poll();
			image[coor.x][coor.y] = newColor;
			visited[sr][sc] = true;

			for (int i = 0; i < 4; i++) {
				int rowAdjust = coor.x + rowAdjustment[i];
				int colAdjust = coor.y + colAdjustment[i];

				if (!inBound(new Coordinate(rowAdjust, colAdjust), image)) {
					continue;
				}

				if (!visited[rowAdjust][colAdjust] && image[rowAdjust][colAdjust] == startColor) {
					queue.offer(new Coordinate(rowAdjust, colAdjust));
				}
			}
		}

		return image;
	}

	private boolean inBound(Coordinate coor, int[][] image) {
		return (coor.x >= 0 && coor.x < image.length && coor.y >= 0 && coor.y < image[0].length);
	}

}
