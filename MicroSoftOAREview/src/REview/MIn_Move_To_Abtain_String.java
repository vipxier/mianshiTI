package REview;

public class MIn_Move_To_Abtain_String {
	public static int solution(String str)
	{
		if(str == null || str.length() == 0)
		{
			return 0;
		}
		
		int aCounter = 0;
		int bCounter = 0;
		int result = 0;
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'a')
			{
				aCounter ++;
				bCounter = 0;
			}
			else
			{
				aCounter = 0;
				bCounter ++;
			}
			
			if(aCounter == 3 || bCounter ==3)
			{
				result ++;
				aCounter = 0;
				bCounter = 0;
			}
		}
		
		return result;
	}
}
