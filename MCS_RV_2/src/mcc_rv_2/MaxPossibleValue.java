package mcc_rv_2;

import java.util.ArrayList;

public class MaxPossibleValue {
	public static int solution(int num)
	{
		int flag = num >= 0 ? 1 : -1;
		int absValue = Math.abs(num);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(absValue > 10)
		{
			list.add(0, absValue % 10);
			absValue /= 10;
		}
		list.add(0, absValue);
		
		boolean numberAdded = false;
		for(int i = 0; i < list.size(); i ++)
		{
			if(flag == 1)
			{
				if(list.get(i) < 5)
				{
					list.add(i , 5);
					numberAdded = true;
					break;
				}
			}
			else
			{
				if(list.get(i) > 5)
				{
					list.add(0, 5);
					numberAdded = true;
					break;
				}
				else if(i + 1 < list.size() && list.get(i) <= 5 && list.get(i + 1) > 5)
				{
					list.add(i + 1, 5);
					numberAdded = true;
					break;
				}
			}
		}
		
		if(!numberAdded)
		{
			list.add(5);
		}
		
		int result = 0;
		for(int i = 0 ; i < list.size(); i ++)
		{
			result = result * 10 + list.get(i);
		}
		
		return result * flag;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution(945));
		System.out.println(solution(439));
		System.out.println(solution(-945));
		System.out.println(solution(-435));
		System.out.println(solution(0));
		System.out.println(solution(999));
		System.out.println(solution(2));
		System.out.println(solution(-999));
		
	}
}
