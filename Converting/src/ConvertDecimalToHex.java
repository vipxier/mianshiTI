
public class ConvertDecimalToHex {
	public static String convert(int source)
	{
		StringBuilder strb  = new StringBuilder();
		
		while(source > 0)
		{
			strb.append(hexString(source % 16));
			source /= 16;
		}
		
		return strb.reverse().toString();
	}
	
	private static String hexString(int number)
	{
		if(number < 10)
		{
			return Integer.toString(number);
		}
	    if(number >= 10)
		{
			return new StringBuilder().append((char)('A' + (number - 10))).toString();
		}
	    return null;
	}
	
	public static void main(String[] args)
	{
		System.out.println(convert(17));
		System.out.println(convert(205));
	}
}
