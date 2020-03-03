
public class RemoveOneCharacterToMakeMini {
	public static String solution(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		
		StringBuilder strb  =new StringBuilder();
		boolean deleted = false;
		
		for(int i = 0; i < str.length() - 1; i ++)
		{
			if(str.charAt(i) > str.charAt(i + 1) && !deleted)
			{
				deleted = true;
				continue;
			}
			strb.append(str.charAt(i));
		}
		
		if(deleted)
		{
			strb.append(str.charAt(str.length() - 1));
		}
		
		return strb.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(solution("abcdf"));
	}
}
