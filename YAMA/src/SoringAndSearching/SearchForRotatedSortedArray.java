package SoringAndSearching;

public class SearchForRotatedSortedArray {
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
		{
			return -1;
		}
		if(nums[0] == target)
		{
			return 0;
		}
		if(nums[nums.length - 1] == target)
		{
			return nums.length - 1;
		}
		
		int start = 0;
		int end = nums.length - 1;
		
		while(start < end)
		{
			int mid = start + (end - start) / 2;
			
			if(target >= nums[start])
			{
				if(nums[start] <= nums[mid])
				{
					if(nums[mid] >= target)
					{
						end = mid;
					}
					else
					{
						start = mid;
					}
				}
				else
				{
					end = mid;
				}
			}
			else
			{
				if(nums[mid] <= nums[end])
				{
					if(nums[mid] >= target)
					{
						end = mid;
					}
					else
					{
						start = mid;
					}
				}
				else
				{
					start = mid;
				}
			}
		}
		
		if(nums[start] == target)
		{
			return start;
		}
		
		if(nums[end] == target)
		{
			return end;
		}
		
		return -1;
	}
}
