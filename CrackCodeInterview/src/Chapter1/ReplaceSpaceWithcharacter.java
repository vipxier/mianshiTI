package Chapter1;

import java.util.ArrayList;
import java.util.List;

public class ReplaceSpaceWithcharacter {
	public static char[] replaceSpaceWith(char[] source)
	{
		for(int i = 0; i < source.length; i++)
		{
			if(source[i] == ' ')
			{
				moveArrayElement(source, i + 1, 2);
				source[i] = '%';
				source[i+1] = '2';
				source[i+2] = '0';
				i = i + 3;
			}
		}
		return source;
	}
	
	private static void moveArrayElement(char[] array, int location, int times)
	{
		for(int i = 0; i < times; i ++)
		{
			for(int j = array.length - 1; j >= location + i; j-- )
			{
				array[j] = array[j-1];
			}
		}		
	}
	
	public static String replaceWithString(String str)
	{
		char[] array = str.toCharArray();
		
		StringBuilder strb  = new StringBuilder();
		for(int i =0; i < array.length-1; i ++)
		{
			if(array[i] != ' ')
			{
				strb.append(array[i]);
			}
			else if(array[i] == ' ' && array[i + 1] != ' ')
			{
				strb.append("%20");
			}
			else if (array[i] == ' ' && array[i + 1] == ' ')
			{
				break;
			}
		}
		return strb.toString();
	}
	
	public static String replaceWithoutChar(String source)
	{
		int wordEndLocation = -1;
		for(int i = 0; i < source.length() - 1; i ++)
		{
			if(source.charAt(i) == ' '  && source.charAt(i + 1)  == ' ')
			{
				wordEndLocation = i - 1;
				break;
			}
		}
		
		return source.substring(0, wordEndLocation + 1).replace(" ", "%20");
	}
	
	
	public static void main(String[] args)
	{
		char[] source = {'M','r',' ', 'J','h','o','n',' ', 'S','m','i','t','h',' ', ' ', ' ', ' '};
		
		for(char c: replaceSpaceWith(source))
		{
			System.out.print(" " + c);
		}
		System.out.println();
		
		System.out.println(replaceWithString("Mr Jhon Smith    "));
		System.out.println(replaceWithoutChar("Mr Jhon   Smith        "));
	}
	
	
}
