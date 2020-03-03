package mcc_rv_2;

import java.util.HashMap;
import java.util.Map;

public class DayOfWeek {
	public static String solution(String day, int k)
	{
		String[] days = new String[] {"Mon", "Tue", "Wed", "Thu", "Fir", "Sat", "Sun"};
		
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		
		for(int i = 0; i < days.length; i ++)
		{
			hashMap.put(days[i], i);
		}
		
		if(!hashMap.containsKey(day))
		{
			return "Please provide a valide weekday name";
		}
		return days[(hashMap.get(day) + k) % 7];
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("Mon", 2));
		System.out.println(solution("Mon", 5));
		System.out.println(solution("Sat", 23));
	}
}
