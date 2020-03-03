package Week1;

public class ContainerWIthMostWater {

	public static int mostWater(int[] height)
	{
		int maxArea = 0;
		for(int i = 0; i < height.length; i ++)
		{
			for(int j = i+1; j< height.length; j ++)
			{
				maxArea = Math.max(maxArea, Math.min(height[i], height[j])*(j-1));
			}
		}
		return maxArea;
	}
	
	public static int mostWater_DP(int[] height)
	{
		if(height == null || height.length == 0)
		{
			return 0;
		}
		int[] result = new int[height.length+1];
		result[0] = height[0];
		for(int i = 1; i < result.length; i ++)
		{
			if(height[i] == height[i-1])
			{
				result[i] = result[i-1] + height[i-1];
			}
			else
			{
				result[i] = Math.max(result[i-1], Math.min(height[i-1], height[i]) * result[i-1]);
			}
		}
		
		return result[height.length+1];
		
		
	}
	
	public static void main(String[] args)
	{
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		System.out.println(mostWater(height));
		System.out.println(mostWater_DP(height));
	}
}
