
public class ConvertBinaryToDecimal {
	public static int convert(String binaryString)
	{
		int result = 0;
		
		for(int i  = 0; i < binaryString.length() - 1; i ++)
		{
			if(binaryString.charAt(i) == '1')
			{
				result = (result + 1) * 2;
			}
			else if (binaryString.charAt(i) == '0')
			{
				result *= 2;
			}
		}
		
		if(binaryString.charAt(binaryString.length() -1 ) == '1')
		{
			result += 1;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		String binaryString= "1000000";
		System.out.println(convert(binaryString));
	}
}
