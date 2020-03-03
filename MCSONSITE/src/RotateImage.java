
public class RotateImage {
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return;
        }
        
        int length = matrix.length;
            
        for(int row = 0; row < length / 2; row ++)
        {
            for(int col = 0; col < (length + 1) / 2; col ++)
            {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[length - 1 - col][row];
                matrix[length - 1 - col][row] = matrix[length - 1 - row][length - 1 - col];
                matrix[length - 1 - row][length - 1 - col] = matrix[row][length - 1- col];
            }
        }
    }
}
