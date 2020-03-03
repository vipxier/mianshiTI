
public class SortColors {
	public static void countintSort(int[] nums)
	{
		if(nums == null || nums.length == 0)
		{
			return;
		}
		
		int[] counters = new int[nums.length];
		
		for(int i = 0; i < nums.length; i ++)
		{
			counters[nums[i]] ++;
		}
		
		int index = 0;
		for(int i = 0; i < counters.length; i ++)
		{
			for(int j = 0; j < counters[i]; j ++) {
				nums[index] = i;
				index ++;
			}
		}
	}
	
	public static void fuckingSort(int[] nums)
	{
		if(nums == null || nums.length == 0)
		{
			return;
		}
		
		int lowNumberIndex = 0;
		int highNumberIndex = nums.length - 1;
		int currentPointer = lowNumberIndex;
		
		while(currentPointer < highNumberIndex)
		{
			if(nums[currentPointer] == 0)
			{
				swap(nums, currentPointer, lowNumberIndex);
				lowNumberIndex ++;
				currentPointer ++;
			}
			else if(nums[currentPointer] == 2)
			{
				swap(nums, currentPointer, highNumberIndex);
				highNumberIndex --;
			}
			else {
				currentPointer ++;
			}
		}
	}
	
	public static void swap(int[] nums, int index1, int index2)
	{
		if(index1 == index2)
		{
			return;
		}
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {1,2,0,1,2,1,1,2,2,0,0};
		
		fuckingSort(nums);
		//countintSort(nums);
		for(int i = 0; i < nums.length; i ++)
		{
			System.out.print(nums[i] + " ");
		}
	}
}
