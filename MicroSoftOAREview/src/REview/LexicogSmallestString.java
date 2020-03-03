package REview;

public class LexicogSmallestString {
	public static String solution(String str)
	{
		if(str == null || str.length() <= 1)
		{
			return str;
		}
		boolean deleted = false;
		StringBuilder strb = new StringBuilder();
		
		for(int i = 0; i < str.length() - 1; i ++ )
		{
			if(strb.charAt(i) > strb.charAt(i + 1))
			{
				deleted = true;
			}
			else
			{
				strb.append(str.charAt(i));
			}
		}
		
		if(deleted)
		{
			strb.append(str.charAt(str.length() - 1));
		}
		
		return strb.toString();
	}
	
	public static String easierSolution(String str)
	{
		if(str == null || str.length() <= 1 )
		{
			return str;
		}
		
		StringBuilder strb = new StringBuilder(str);
		boolean deleted = false;
		int index = -1;
		for(int i = 0; i < str.length() - 1 ; i ++)
		{
			if(strb.charAt(i) > strb.charAt(i + 1))
			{
				deleted = true;
				index = i;
				break;
			}
		}
		
		if(index > -1)
		{
			return strb.deleteCharAt(index).toString();
		}
		
		return strb.deleteCharAt(str.length() - 1).toString();
	}
}
