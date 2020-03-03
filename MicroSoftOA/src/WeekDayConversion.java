import java.util.HashMap;
import java.util.Map;

public class WeekDayConversion {
	public static String solution(String str, int k)
	{
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(1, "MON");
		hashMap.put(2, "TUE");
		hashMap.put(3, "WEN");
		hashMap.put(4, "THRU");
		hashMap.put(5, "FRI");
		hashMap.put(6, "SAT");
		hashMap.put(7, "SUN");
		
		int daysAfter = k % 7;
		int currentDayIndex = 0;
		for(Map.Entry<Integer, String> entry : hashMap.entrySet())
		{
			if(entry.getValue().contentEquals(str))
			{
				currentDayIndex = entry.getKey();
				break;
			}
		}
		
		return (hashMap.get(currentDayIndex + daysAfter));
	}
	
	public static String betterSolution(String str, int k)
	{
		String[] weekStrs = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fir", "Sat", "Sun"};
		
		Map<String, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < weekStrs.length; i ++)
		{
			hashMap.put(weekStrs[i], i);
		}
		
		return weekStrs[(hashMap.get(str) + k) % 7];
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("MON", 30));
	}
}
