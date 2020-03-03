import java.util.Arrays;

public class MInimumStepsToMakePileEqualHigh {
	public static int solution(int[] array)
	{
		if(array == null || array.length <= 1)
		{
			return 0;
		}
		
		Arrays.sort(array);
		int index = 0;
		
		for(int i = 1; i < array.length; i ++)
		{
			if(array[i] != array[index])
			{
				index ++;
			}
			
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		
		if(index == 0)
		{
			index = array.length - 1;
		}
		
		int result = 0;
		for(int i = 0; i < array.length; i++)
		{
			for(int rank = 0; rank <= index; rank ++)
			{
				if(array[rank] == array[i])
				{
					result += (rank - 0);
					break;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] array = {5,2,1,1,1,1,9,12,3,54};
		System.out.println(solution(array));
	}
}
