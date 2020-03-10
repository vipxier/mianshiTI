package TreeAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillTengfei {
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
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor)
		{
			return image;
		}
		
		int startColor = image[sr][sc] ;
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		queue.offer(new Coordinate(sr, sc));
		
		while(!queue.isEmpty())
		{
			Coordinate currentCoord = queue.poll();
			
			if(image[currentCoord.x][currentCoord.y] != newColor)
			{
				image[currentCoord.x][currentCoord.y] = newColor;
			}
			
			for(int i = 0; i < 4; i ++)
			{
				int adjustedRow = currentCoord.x + rowAdjustment[i];
				int adjustedCol = currentCoord.y + colAdjustment[i];
				
				if(inbound(adjustedRow, adjustedCol, image) && 
						image[adjustedRow][adjustedCol] == startColor)
				{
					queue.offer(new Coordinate(adjustedRow, adjustedCol));
				}
			}
		}
		
		return image;
	}
	
	private boolean inbound(int row, int col, int[][] image)
	{
		return row >=0 && row < image.length && col >=0 && col < image[0].length;
	}
	
	public static void main(String[] args)
	{
		int[][] image = new int[][] {{1,1,1},
									 {1,1,0},
									 {1,0,1}};
		FloodFillTengfei solution = new FloodFillTengfei();
		int[][] newImage = solution.floodFill(image, 1, 1, 2);
		for(int i = 0; i < newImage.length; i ++)
		{
			System.out.println(Arrays.toString(newImage[i]));
		}
	}
}
