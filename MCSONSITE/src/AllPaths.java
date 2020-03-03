import java.util.ArrayList;
import java.util.List;

public class AllPaths {
	public static List<List<Integer>> solution(int[][] matrix)
	{
		List<List<Integer>> result = new ArrayList<>();
		
		if(matrix == null || matrix.length ==0  || matrix[0].length == 0)
		{
			return result;
		}
		
		generatePaths(matrix, result, new ArrayList<Integer>(), 0, 0);
		
		return result;
	}
	
	private static void generatePaths(int[][] matrix, List<List<Integer>> result, List<Integer> currentPath, int currentRow , int currentCol)
	{
		if(currentRow == matrix.length && currentCol == matrix[0].length)
		{
			result.add(currentPath);
			return;
		}
		
		currentPath.add(matrix[currentRow][currentCol]);
		for(int i = currentRow, j = currentCol; i < matrix.length && j < matrix[0].length; i ++, j ++)
		{
			generatePaths(matrix, result, currentPath, currentRow + 1, currentCol);
			currentPath.remove(currentPath.size() - 1);
			generatePaths(matrix, result, currentPath, currentRow, currentCol + 1);
		}

	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3},
						{4,5,6}, 
						{7,8,9}};
		
		System.out.println(solution(matrix));
		
	}
}
