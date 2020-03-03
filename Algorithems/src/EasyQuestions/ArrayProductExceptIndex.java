package EasyQuestions;

import java.util.ArrayList;
import java.util.List;
import utils.ArrayUtils;

public class ArrayProductExceptIndex {

	public static int[] arrayProduct(int[] array, int index)
	{
		if(array == null || array.length == 0 || index < 0)
		{
			return null;
		}
		

		int[] resultArray = new int[array.length-1];
		List<Integer> result = new ArrayList<Integer>();
		
		if (index >= 0 && index < array.length)
		{
			int[] left = new int[array.length];
			left[0] = 1;
			int[] right = new int[array.length];
			right[right.length-1] = 1;
			
			for(int i = 1; i < array.length; i ++)
			{
				left[i]  = array[i-1] * left[i-1];
			}
			
			for(int j = array.length-2; j >= 0; j --)
			{
				right[j] = array[j+1] * right[j+1];
			}
			
			for(int i = 0; i < array.length; i ++)
			{
				if(i != index) {
				result.add(left[i]* right[i]);
				}
			}
		}
		
		for(int i  = 0; i < result.size(); i ++)
		{
			resultArray[i] = result.get(i);
		}
		return resultArray;
	}
	
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4};
		ArrayUtils.printSingleDimentionArray(arrayProduct(array, 3));
	}
}
