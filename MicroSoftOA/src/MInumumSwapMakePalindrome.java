import java.util.Arrays;

public class MInumumSwapMakePalindrome
{
	public static int solution(String str1, String str2)
	{
		if(str1.length()!= str2.length())
		{
			return -1;
		}
		
		if(!isPardromeAble(str1, str2))
		{
			return -1;
		}
		
		int i = 0;
		int j  =0;
		int changeCount = 0;
		
		int size = str1.length();
		
		while(i < size)
		{
			j = i;
			while(str1.charAt(i) != str2.charAt(j))
			{
				j ++;
			}
			
			while(i < j)
			{
				str2 = swapString(str2, j, j -1);
				j --;
				changeCount ++;
			}
			i++;
		}
		
		return changeCount;
	}
	
	private static String swapString(String str, int index1, int index2)
	{
		char[] charArray = str.toCharArray();
		
		char temp = charArray[index1];
		charArray[index1] = charArray[index2];
		charArray[index2] = temp;
		
		return new String(charArray);
	}
	
	private static boolean isPardromeAble(String str1, String str2)
	{
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		return new String(charArray1).contentEquals(new String(charArray2));
	}
	
	public static void main(String[] args)
	{
		String s1 = "abcd"; 
	    String s2 = "cdab";
	    
	    System.out.println(solution(s1, s2));
	}
}
