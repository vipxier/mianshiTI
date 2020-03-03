package REview;

public class PartileVelocity {
	public static int solution(int[] velocity)
	{
		if(velocity == null || velocity.length == 0)
		{
			return 0;
		}
		
		int result = 0;
		
		for(int i = 0; i < velocity.length - 2; i ++)
		{
			if(velocity[i + 1] - velocity[i] == velocity[i + 2] - velocity[i + 1])
			{
				result ++;
				for(int j = i + 3; j < velocity.length; j ++)
				{
					if(velocity[j] - velocity[j - 1] == velocity[i + 2] - velocity[i + 1])
					{
						result ++;
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
        int[] input = {-1,1,3,3,3,2,3,2,1,0};
        int result = solution(input);
        System.out.println(result);
    }
}
