package mcc_rv_2;

public class ParticleVelocity {
	public static int solution(int[] velocities)
	{
		if(velocities == null || velocities.length <= 2)
		{
			return 0;
		}
		
		int maxStableSectionCount = 0;
		for(int i = 0; i < velocities.length - 2; i ++)
		{
			if(velocities[i + 1]  - velocities[i] == velocities[i + 2] - velocities[i + 1])
			{
				maxStableSectionCount ++;
				
				for(int j = i + 3; j < velocities.length; j ++)
				{
					if(velocities[j] - velocities[j - 1] == velocities[i + 2] - velocities[i + 1])
					{
						maxStableSectionCount ++;
					}
				}
			}
		}
		
		return maxStableSectionCount;
	}
	
	public static void main(String[] args) {
        int[] input = {-1,1,3,3,3,2,3,2,1,0};
        int result = solution(input);
        System.out.println(result);
	}
}
