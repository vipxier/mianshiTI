package datastructure;

public class inserationSort {
	public void sort(int[] nums)
	{
		if(nums == null || nums.length == 0)
		{
			return;
		}
		
		for(int i = 1; i < nums.length; i ++)
		{
			int key = nums[i];
			int j = i - 1;
			while(key < nums[j] && j >= 0)
			{
				nums[j + 1] = nums[j];
			j--;
			}
			nums[j + 1] = key;
		}
	}
}
