import java.util.ArrayList;
import java.util.List;

public class CreateSprialOrder {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return result;
        }
        
        int rowLimit = matrix.length;
        int colLimit = matrix[0].length;
        
        int rowIndex = 0;
        int colIndex = 0;
        
        while(rowLimit > 0 && colLimit > 0)
        {
            if(rowLimit == 1)
            {
                for(int i = 0; i < colLimit; i ++)
                {
                    result.add(matrix[rowIndex][colIndex ++]);
                }
                break;
            }
            else if(colLimit == 1)
            {
                for(int i = 0; i < rowLimit ; i ++)
                {
                    result.add(matrix[rowIndex ++][colIndex]);
                }
                break;
            }
            
            for(int i = 0; i < colLimit - 1; i ++)
            {
                result.add(matrix[rowIndex][colIndex ++]);
            }
            
            for(int i = 0; i < rowLimit - 1; i ++)
            {
                result.add(matrix[rowIndex ++][colIndex]);
            }
            
            for(int i = 0; i < colLimit -1; i ++)
            {
                result.add(matrix[rowIndex][colIndex --]);
            }
            
            for(int i = 0; i < rowLimit - 1; i ++)
            {
                result.add(matrix[rowIndex --][colIndex]);
            }
        
            rowIndex ++;
            colIndex ++;
            rowLimit -= 2;
            colLimit -= 2;
        }
        
        return result;
    }
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		
		System.out.println(spiralOrder(matrix));
	}
}
