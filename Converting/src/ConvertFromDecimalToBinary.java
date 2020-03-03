

public class ConvertFromDecimalToBinary {
	public static String convert(int source)
	{
		StringBuilder strb = new StringBuilder();
		
		while(source > 0)
		{
			int digit  =source % 2;
			strb.append(digit);
			source  = source /2;
		}
		
		return strb.reverse().toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(convert(127));
	}
}
