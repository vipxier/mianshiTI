package REview;

public class MIniMumDeleteToMakeRightFormat {
	public static int solution(String str)
	{
		if(str== null || str.length() == 0)
		{
			return -1;
		}
		
		int aCount = 0;
		int bCount = 0;
		int removeCount = 0;
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i)== 'A')
			{
				aCount ++;
				if(bCount > removeCount)
				{
					removeCount ++;
				}
			}
			else
			{
				bCount ++;
				if(aCount == 0)
				{
					removeCount ++;
				}
			}
			
		}
		
		return Math.min(aCount, Math.min(bCount, removeCount));
	}
}
