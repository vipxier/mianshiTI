package Chapter1;

public class QuestionSetZero {

	public static void setZero(int[][] array)
	{
		if(array == null || array.length == 0)
		{
			return;
		}
		
		boolean zeroInFirstRow = false;
		boolean zeroInFirstCol = false;
		
		for(int i = 0; i < array.length; i ++)
		{
			if(array[i][0] == 0)
			{
				zeroInFirstCol = true;
				break;
			}
		}
		
		for(int i = 0; i < array[0].length; i ++)
		{
			if(array[0][i] == 0)
			{
				zeroInFirstRow = true;
				break;
			}
		}
		
		for(int i = 1; i < array.length; i ++)
		{
			for(int j = 1; j < array[0].length; j ++)
			{
				if(array[i][j] == 0)
				{
					array[i][0]=  0;
					array[0][j]= 0;
				}
			}
		}
		
		for(int i = 1; i < array.length; i ++)
		{
			for(int j = 1; j < array[0].length; j ++)
			{
				if(array[i][0] == 0)
				{
					array[i][j] = 0;
				}
				
				if(array[0][j] == 0)
				{
					array[i][j] = 0;
				}
			}
		}
		
		if(zeroInFirstCol)
		{
			for(int i = 0; i < array.length; i ++)
			{
				array[i][0] = 0;
			}
		}
		
		if(zeroInFirstRow)
		{
			for(int i = 0; i < array[0].length; i ++)
			{
				array[0][i] = 0;
			}
		}
	}
}
