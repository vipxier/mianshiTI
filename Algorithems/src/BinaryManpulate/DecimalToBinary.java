package BinaryManpulate;

import java.util.Stack;

public class DecimalToBinary {

	public static String decimalToBinary(int number)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		while(number != 0)
		{
			stack.push(number%2);
			number = number/2;
			
		}
		
		StringBuilder strBuild = new StringBuilder();
		while(!stack.isEmpty())
		{
			strBuild.append(stack.pop().toString());
		}
		return strBuild.toString();
	}
	
	public static int binaryToDecimal(String binaryString)
	{
		int result = 0;
		for(int i = binaryString.length()-1; i >= 0; i --)
		{
			int currentPositionVaule = binaryString.charAt(i) == '1' ? (int)Math.pow(2, binaryString.length()-1 - i) : 0;
			result += currentPositionVaule;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int target = 1023;
		String binaryString = decimalToBinary(target);
		System.out.println(binaryString);
		
		System.out.println(binaryToDecimal(binaryString));
	
	}
	
}	
