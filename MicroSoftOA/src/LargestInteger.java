import java.util.HashSet;

public class LargestInteger {
	public static int solution(int[] array)
	{
		if(array == null || array.length == 0)
		{
			return 0;
		}
		
		int maxInteger = 0;
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		for(int i = 0; i < array.length; i ++)
		{
			if(hashSet.contains(array[i]))
			{
				maxInteger = Math.max(maxInteger, Math.abs(array[i]));
			}
			else
			{
				hashSet.add(0 - array[i]);
			}
		}
		
		return maxInteger;
	}
	
	public static void main(String[] args)
	{
		int[] array = new int[]{3, 2, -2, 5, -3};
		int[] array1 = new int[] {1, 2, 3, -4, 4};
		System.out.println(solution(array));
		System.out.println(solution(array1));
	}
}
