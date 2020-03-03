public class solution {
	
	public static int getStableVelocities(int[] array)
	{
		if(array.length < 3)
		{
			return 0;	
		}
		
		int result = 0;
		
		for(int i = 0;i < array.length - 2; i ++)
		{
			if(array[i + 1] - array[i] == array[i + 2] - array[i + 1])
			{
				result ++;
				for(int j = i + 3; j < array.length; j ++)
				{
					if(array[j + 1] - array[j] == array[j + 2] - array[j + 1])
					{
						result ++;
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(int[] array)
	{
		int[] velocities = new int[]{-1,1,3,3,3,2,3,2,1,0};
		
		System.out.println(getStableVelocities(velocities));
	}
}
