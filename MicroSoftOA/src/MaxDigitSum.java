import java.util.HashMap;
import java.util.Map;

public class MaxDigitSum {
	public int solution(int[] array)
	{
		if(array == null || array.length == 0)
		{
			return -1;
		}
		int result = -1;
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < array.length; i ++) {
			int digitSum = getDigitSum(array[i]);
			
			if(!hashMap.containsKey(digitSum))
			{
				hashMap.put(digitSum, array[i]);
			}
			else
			{
				result = Math.max(result, hashMap.get(digitSum) + array[i]);
				hashMap.put(digitSum, Math.max(array[i], hashMap.get(digitSum)));
			}
		}
		
		return result;
	}
	
	private int getDigitSum(int number)
	{
		number = Math.abs(number);
		int result = 0;
		
		while(number > 0)
		{
			result += number % 10;
			number = number / 10;
		}
		
		return result;
	}
}
