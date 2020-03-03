
public class SetZeroInMatrix {
	 public void setZeroes(int[][] matrix) {
	        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
	        {
	            return;
	        }
	        
	        boolean zeroInCol0 = false;
	        boolean zeroInRow0 = false;
	        
	        for(int i = 0; i < matrix[0].length; i ++)
	        {
	            if(matrix[0][i] == 0)
	            {
	                zeroInRow0 = true;
	                break;
	            }
	        }
	        
	        for(int i = 0; i < matrix.length; i ++)
	        {
	            if(matrix[i][0] == 0)
	            {
	                zeroInCol0 = true;
	                break;
	            }
	        }
	        
	        for(int i = 1; i < matrix.length; i ++)
	        {
	            for(int j = 1; j < matrix[0].length; i ++)
	            {
	                if(matrix[i][j] == 0)
	                {
	                    matrix[i][0] = 0;
	                    matrix[0][j] = 0;
	                }
	            }
	        }
	        
	        for(int i = 1; i < matrix.length; i++)
	        {
	            for(int j = 1; j < matrix[0].length; j ++)
	            {
	                if(matrix[i][0] == 0 || matrix[0][j] == 0)
	                {
	                    matrix[i][j] =0;
	                }
	            }
	        }
	        
	        if(zeroInCol0)
	        {
	            for(int i = 0; i < matrix.length; i ++)
	            {
	                matrix[i][0] = 0;
	            }
	        }
	        
	        if(zeroInRow0)
	        {
	            for(int i =0 ; i < matrix[0].length; i ++)
	            {
	                matrix[0][i] = 0;
	            }
	        }
	    }
}
