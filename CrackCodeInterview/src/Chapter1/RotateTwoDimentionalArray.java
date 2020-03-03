package Chapter1;
import utils.ArrayUtils;
public class RotateTwoDimentionalArray {

	public static void rotateNinetyDegree(int[][] array)
	{
		int layer = array.length / 2;
		
		for(int i = 0 ; i < layer; i ++)
		{
			rotate(array, i);
		}
	}
	
	private static void rotate(int[][] array, int layer)
	{
		int position1_x = layer;
		int position1_y = layer;
		
		int position2_x = layer;
		int position2_y = array.length - 1 - layer;
		
		int position3_x = array.length - 1 - layer;
		int position3_y = layer;
		
		int position4_x = array.length - 1 - layer;
		int position4_y = array.length - 1 - layer;
		
		
		int temp = array[position1_x][position1_y];
		array[position1_x][position1_y] = array[position2_x][position2_y];
		array[position2_x][position2_y] = array[position4_x][position4_y];
		array[position4_x][position4_y] = array[position3_x][position3_y];
		array[position3_x][position3_y] = temp;
		
		for(int i = layer + 1; i < position2_y; i ++)
		{
			temp = array[position1_x][i];
			array[position1_x][i] = array[i][position2_y];
			array[i][position2_y] = array[position4_x][position4_y - i];
			array[position4_x][position4_y - i] = array[position3_x - i][position3_y];
			array[position3_x - i][position3_y] = temp;
		}
	}
	
	public static void main(String[] args)
	{
		int[][] array = {{1,1,1,1,1}, {2,2,2,2,2}, {3,3,3,3,3}, {4,4,4,4,4}, {5,5,5,5,5}};
		ArrayUtils.printDoubleDimentionArray(array);
		rotateNinetyDegree(array);
		ArrayUtils.printDoubleDimentionArray(array);
		
		
		int[][] array1 = {{1,1,1,1}, {2,2,2,2}, {3,3,3,3}, {4,4,4,4}};
		ArrayUtils.printDoubleDimentionArray(array1);
		rotateNinetyDegree(array1);
		ArrayUtils.printDoubleDimentionArray(array1);
	}
}
