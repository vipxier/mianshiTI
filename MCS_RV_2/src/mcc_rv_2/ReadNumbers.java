package mcc_rv_2;

public class ReadNumbers {
	public static String solution(String str)
	{
		if(str == null || str.length() == 0)
		{
			return "";
		}
		
		int counter = 1;
		StringBuilder strb = new StringBuilder();
		for(int i = 1; i < str.length(); i ++)
		{
			if(str.charAt(i) == str.charAt(i - 1))
			{
				counter ++;
			}
			else
			{
				strb.append(counter).append(str.charAt(i - 1));
				counter = 1;
			}
		}
		
		strb.append(counter).append(str.charAt(str.length() - 1));
		return strb.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("22211131112"));
		System.out.println(solution("0"));
	}
}
