package Try;

public class CanReach {

	public static boolean canReach(int[] arr, int start) {
		if (start < 0) {
			return false;
		}

		boolean[] canReach = new boolean[arr.length];

		canReach[start] = true;

		for (int i = start; i >= 0; i--) {
			if (canReach[i] && i - arr[i] >= 0 && !canReach[i - arr[i]]) {
				if(arr[i - arr[i]] == 0)
				{
					return true;
				}
				canReach[i - arr[i]] = true;
				
			}
		}

		return false;
	}
	
	public static void main(String[] args)
	{
		int[] steps = new int[] {4,2,3,0,3,1,2};
		
		System.out.println(canReach(steps , 5));
	}
}
