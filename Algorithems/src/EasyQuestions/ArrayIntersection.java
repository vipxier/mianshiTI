package EasyQuestions;

import java.util.ArrayList;
import java.util.List;
import utils.ListUtils;

public class ArrayIntersection {
	public static List<Integer> findIntersection (int[] array1, int[] array2)
	{
		if(array1 == null || array2 == null || array1.length ==0 || array2.length == 0)
		{
			return null;
		}
		
		int len1 = array1.length;
		int len2 = array2.length;
		List<Integer> result = new ArrayList<Integer>();
		
		int i = 0, j = 0;
		
		while(i < len1 && j < len2)
		{
			if(array1[i] == array2[j])
			{
				result.add(array1[i]);
				i++; j ++;
			}
			else if( array1[i] < array2[j])
			{
				i++;
			}
			else
			{
				j++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] array1 = {1,2,3,4,5,7,7};
		int[] array2 = {0,3,4,7};
		
		ListUtils.printList(findIntersection(array1, array2));
	}
}
