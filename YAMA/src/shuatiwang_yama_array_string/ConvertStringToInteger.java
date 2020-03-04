package shuatiwang_yama_array_string;

public class ConvertStringToInteger {
	public int myAtoi(String str) {
		if(str == null || str.length() == 0)
        {
            return 0;
        }
        
        int start = 0;
        int end = str.length() - 1;
        
        while(start < str.length() && (str.charAt(start) == ' '))
        {
            start ++;
        }
        
        while(end >= 0 && !Character.isDigit(str.charAt(end)))
        {
            end --;
        }
        
        if(end < start)
        {
            return 0;
        }
        
        int sign = 1;
        if(str.charAt(start) == '-')
        {
            sign = -1;
            start += 1;
        }
        else if(str.charAt(start) == '+')
        {
            start ++;
        }
        
        double value = 0;
        for(int i = start; i <= end ; i ++)
        {
            if(str.charAt(i) >='0' && str.charAt(i) <= '9'){
                value = value * 10 + str.charAt(i) - '0';
            }
            else
            {
               break;
            }
        }
    
        value *= sign;
        if(value > Integer.MAX_VALUE)
        {
            value = Integer.MAX_VALUE;
        }
        else if(value <  Integer.MIN_VALUE)
        {
            value = Integer.MIN_VALUE;
        }
        
        return (int) (value);
    }
	
	public static void main(String[] args)
	{
		String str = "42";
		ConvertStringToInteger solution = new ConvertStringToInteger();
		System.out.println(solution.myAtoi(str));
		System.out.println(solution.myAtoi("    -42"));
		System.out.println(solution.myAtoi("    -42 abcd  aa"));

		System.out.println(solution.myAtoi("    -42.1315 ab12cd aa"));
		
	}
}
