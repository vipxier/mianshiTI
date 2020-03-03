package Chapter1;

public class Question4ReplaceSpaceWith {
	public static void replaceSpaces(char[] array, int length)
	{
		if(length == 0 || array == null || array.length == 0)
		{
			return;
		}
		
		int spaceCount = 0;
		
		for(int i = 0; i < length; i ++)
		{
			if(array[i] == ' ')
			{
				spaceCount ++;
			}
		}
		
		int arrayLength = length + 2 * spaceCount;
		
		array[arrayLength] = '\0';
		for(int i = length - 1; i >= 0; i --)
		{
			if(array[i] == ' ')
			{
				array[arrayLength - 3] = '%';
				array[arrayLength - 2] = '2';
				array[arrayLength - 1] = '0';
				arrayLength -= 3;
			}
			else
			{
				array[arrayLength] = array[i];
				arrayLength -= 1;
			}
		}
	}
}
