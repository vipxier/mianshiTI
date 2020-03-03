package utils;

public class ArrayUtils {

	public static void printSingleDimentionArray(int[] array)
	{
		StringBuilder strB = new StringBuilder();
		for(int i = 0; i < array.length; i ++)
		{
			strB.append(" " + array[i]);
		}
		
		System.out.println(strB.toString());
	}
	
	public static void printDoubleDimentionArray(int[][] array)
	{
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[i].length; j++)
            {
                sb.append(" " + array[i][j]);
            }
            sb.append('\n');
        }
	    
	    System.out.println(sb.toString());
	}
	
	public static int[] initializeArrayFromParent(int[] parent, int start, int end)
	{
	    int[] result = new int[end-start+1];
	    for(int i = start; i <= end; i ++)
	    {
	        result[i-start] = parent[i]; 
	    }
	    return result;
	}
	
	
}
