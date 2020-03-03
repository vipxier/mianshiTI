package REview;

public class LightBulbSwitcher {
	public static int solution(int[] lights)
	{
		int max = 0;
		int counter = 0;
		
		for(int i = 0; i < lights.length; i ++)
		{
			max = Math.max(max, lights[i]);
			
			if(max == i + 1)
			{
				counter ++;
			}
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {2,1,3,5,4};
		int[] nums2 = {2,3,4,1,5};
		int[] nums3 = {5,4,3,2,1};
		int[] nums4 = {3,2,4,6,5};
		System.out.println(solution(nums1));
		System.out.println(solution(nums2));
		System.out.println(solution(nums3));
		System.out.println(solution(nums4));		
	}
}
