
public class GetLonngesNoRepeatMoreThan3 {
	public static String solution(String str)
	{
		if(str == null || str.length() == 0)
		{
			return str;
		}
		
		StringBuilder strb = new StringBuilder();
		int counter = 1;
		strb.append(str.charAt(0));
		
		for(int i = 1; i < str.length(); i ++)
		{
			if(str.charAt(i) == str.charAt(i - 1))
			{
				counter ++;
			}
			else
			{
				counter = 1;
			}
			
			if(counter < 3)
			{
				strb.append(str.charAt(i));
			}
		}
		
		return strb.toString();
	}
	
	public static void main(String[] args)
	{
		String str="qqqsaaaaadddddfafaafafeqqq";
		
		System.out.println(solution(str));
	}
}
