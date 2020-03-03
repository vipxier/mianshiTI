package Chapter1;

public class Questoin6RotateImage {
	public static void rotateRight(int[][] array)
	{
		if(array == null || array.length == 0 || array[0].length == 0)
		{
			return;
		}
		
		int layerCount = array.length;
		
		for(int layerIndex = 0; layerIndex < layerCount / 2; layerIndex ++)
		{
			for(int colIndex = 0; colIndex < (layerCount + 1) / 2; colIndex ++)
			{
				int temp = array[layerIndex][colIndex];
				array[layerIndex][colIndex] = array[layerCount - 1 - colIndex][layerIndex];
				array[layerCount - 1 - colIndex][layerIndex] = array[layerCount - 1 - layerIndex][layerCount - 1 - colIndex];
				array[layerCount - 1 - layerIndex][layerCount - 1 - colIndex] = array[colIndex][layerCount - 1 - layerIndex];
				array[colIndex][layerCount - 1 - layerIndex] = temp;
			}
		}
	}
	
	public static void rotateLeft(int[][] array)
	{
		if(array == null || array.length == 0 || array[0].length == 0)
		{
			return;
		}
		
		int layerCount = array.length;
		
		for(int rowIndex  =0; rowIndex < layerCount / 2; rowIndex ++)
		{
			for(int colIndex = 0; colIndex < (layerCount + 1) / 2; colIndex ++)
			{
				int temp = array[rowIndex][colIndex];
				array[rowIndex][colIndex] = array[colIndex][layerCount - 1 - rowIndex];
				array[colIndex][layerCount - 1 - rowIndex] = array[layerCount - 1 - rowIndex][layerCount - 1 - colIndex];
				array[layerCount - 1 - rowIndex][layerCount - 1 - colIndex] = array[layerCount - 1 - colIndex][rowIndex];
				array[layerCount - 1 - colIndex][rowIndex] = temp;
				
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		for(int i = 0; i < matrix.length; i ++)
		{
			for(int j = 0; j < matrix[0].length; j ++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}
		System.out.println();
		
		rotateRight(matrix);
		
		for(int i = 0; i < matrix.length; i ++)
		{
			for(int j = 0; j < matrix[0].length; j ++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		
	    int[][] matrix2 = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
	    for(int i = 0; i < matrix2.length; i ++)
		{
			for(int j = 0; j < matrix2[0].length; j ++)
			{
				System.out.print(matrix2[i][j] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println();
	    rotateLeft(matrix2);
		for(int i = 0; i < matrix2.length; i ++)
		{
			for(int j = 0; j < matrix2[0].length; j ++)
			{
				System.out.print(matrix2[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}
}
