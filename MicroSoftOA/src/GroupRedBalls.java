import java.util.ArrayList;
import java.util.List;

public class GroupRedBalls {
	public static int solution(String s)
	{
		if(s == null || s.length() == 0)
		{
			return 0;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < s.length(); i ++)
		{
			if(s.charAt(i) == 'R')
			{
				list.add(i);
			}
		}
		
		int mid = 0 + (list.size() - 1 ) / 2;
		
		int result = 0;
		
		if(list.isEmpty())
		{
			return 0;
		}
		
		for(int i = 0; i < list.size(); i ++)
		{
			if(i == mid)
			{
				continue;
			}
			
			result += (Math.abs(list.get(i) - list.get(mid)) - 1);
		}
		
		return result;
	}
	
	public static int min_swap(String str)
	{
		int redCount = 0;
		
		for(char c : str.toCharArray())
		{
			if(c == 'R')
			{
				redCount ++;
			}
		}
		
		int leftPointer = 0;
		int rightPointer = str.length() - 1;
		int result = 0;
		
		while(leftPointer < rightPointer)
		{
			if(str.charAt(leftPointer) == 'R' && str.charAt(rightPointer) == 'R')
			{
				redCount -= 2;
				result += rightPointer - leftPointer - 1 - redCount;
				leftPointer ++;
				rightPointer --;
			}
			else if(str.charAt(leftPointer) != 'R')
			{
				leftPointer ++;
			}
			else
			{
				rightPointer --;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		String str ="WRRWWR";
		String str1 = "WWRWWWRWR";
		String str3 = "RRRRWRWWWRWWRW";
		//System.out.println(solution(str));
		//System.out.println(solution(str1));
		//System.out.println(solution(str3));
		
		
//		System.out.println(solution("RRRWRR")); // 2
//		System.out.println(solution("WRRWWR")); // 2
//		System.out.println(solution("WWRWWWRWR")); // 4
//		System.out.println(solution("WWW")); // 0
//		System.out.println(solution("RRRWWWRRW")); // 6
//		System.out.println(solution("RRRRR")); // 0
//		System.out.println(solution("RWWWR")); // 3
		
		System.out.println(min_swap("RRRWRR")); // 2
		System.out.println(min_swap("WRRWWR")); // 2
		System.out.println(min_swap("WWRWWWRWR")); // 4
		System.out.println(min_swap("WWW")); // 0
		System.out.println(min_swap("RRRWWWRRW")); // 6
		System.out.println(min_swap("RRRRR")); // 0
		System.out.println(min_swap("RWWWR")); // 3
	}
}
