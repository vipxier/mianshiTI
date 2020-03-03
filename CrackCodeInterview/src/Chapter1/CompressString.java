package Chapter1;

public class CompressString {
	
	public static String compressString(String source)
	{
		StringBuilder strb = new StringBuilder();
		int count = 1;
		char currentChar = source.charAt(0);
		for(int i = 0; i < source.length() - 1; i ++)
		{
			if(source.charAt(i) == source.charAt(i + 1))
			{
				currentChar = source.charAt(i);
				count ++;
			}
			else
			{
				strb.append(source.charAt(i)).append(count);
				count = 1;
			}
		}
		strb.append(currentChar).append(count);
		return strb.toString().length() > source.length() ? source : strb.toString();
	}
	
	
	public static void main(String[] args)
	{
		System.out.print(compressString("aabcddeccaaaaaaaa"));
	}

}
