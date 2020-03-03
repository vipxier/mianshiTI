package mcc_rv_2;

public class StringWithout3IdenticalConsecutiveLetters {
	public static String soilution(String str)
	{
		if(str == null || str.length() <= 2)
		{
			return str;
		}
		
		int counter = 0;
		StringBuilder strb = new StringBuilder();
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
	
	
	public static void main(String[] args) {
		String s1 = "eedaaad";
		String s2 = "xxxtxxx";
		String s3 = "uuuuxaaaaxuuu";
		System.out.println(soilution(s1));
		System.out.println(soilution(s2));
		System.out.println(soilution(s3));
	}
}
