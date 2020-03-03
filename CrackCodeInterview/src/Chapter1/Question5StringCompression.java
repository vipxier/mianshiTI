package Chapter1;

public class Question5StringCompression {
	public static String compression(String str)
	{
		if(str == null || str.length() <= 1)
		{
			return str;
		}
		
		int counter = 1;
		StringBuilder strb = new StringBuilder();
		char repeatedChar = str.charAt(0);
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
			repeatedChar = str.charAt(i - 1);
		}
		
		strb.append(counter).append(str.charAt(str.length() - 1));
		
		return strb.toString().length() < str.length() ? strb.toString() : str;
	}
	
	public static void main(String[] args)
	{
		System.out.println(compression("aabbbbbccddaaaaaabbcccddddccefddgffd"));
	}
}
