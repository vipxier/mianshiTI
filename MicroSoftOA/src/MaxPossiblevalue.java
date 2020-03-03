import java.util.ArrayList;

public class MaxPossiblevalue {
	public static int maxPossibleValue(int num)
	{
		int flag = 0;
		int index = 0;
		boolean added = false;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		flag = num > 0 ? 1 : -1;
		
		num = Math.abs(num);
		
		while(num > 0)
		{
			list.add(0, num % 10);
			num /= 10;
		}
		
		for(int i = 0; i < list.size(); i ++)
		{
			if(flag == 1 && list.get(i) < 5)
			{
				list.add(i, 5);
				added = true;
				break;
			}
			else if(flag == -1)
			{
				if(i == 0 && list.get(i) > 5) {
					list.add(0, 5);
					added = true;
					break;
				}
				else if(i + 1 < list.size() && list.get(i) <= 5 && list.get(i + 1) > 5)
				{
					list.add(i, 5);
					added = true;
					break;
				}
				
			}
		}
		
		if(!added)
		{
			list.add(5);
		}
		
		int result = 0;
		index = 0;
		while(index < list.size())
		{
			result += list.get(index) * Math.pow(10, list.size() - index - 1);
			index ++;
		}
		return result * flag;
	}
	
	public static void main(String[] args)
	{
		System.out.println(maxPossibleValue(1234));
		System.out.println(maxPossibleValue(67899));
		System.out.println(maxPossibleValue(-11111));
		System.out.println(maxPossibleValue(-999));
		System.out.println(maxPossibleValue(-945));
	}
}
