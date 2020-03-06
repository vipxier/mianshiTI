package datastructure;

import java.util.Arrays;

public class HeapSort {
	public void sort(int[] nums)
	{
		int length = nums.length;
		
		for(int i = length / 2 - 1; i >= 0; i --)
		{
			heapify(nums, length, i);
		}	
		
		for(int i = length - 1 ; i >=0; i--)
		{
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;
			heapify(nums, i, 0);
		}
	}
	
	private void heapify(int[] nums, int length, int index)
	{
		int leftChild = 2 * index + 1;
		int rightChild = 2 * index + 2;
		int larggest = index;
		
		if(leftChild < length && nums[leftChild] > nums[larggest])
		{
			larggest = leftChild;
		}
		
		if(rightChild < length && nums[rightChild] > nums[larggest])
		{
			larggest = rightChild;
		}
		
		if(larggest != index)
		{
			int temp = nums[larggest];
			nums[larggest] = nums[index];
			nums[index] = temp;
			heapify(nums, length, larggest);
		}
	}
	
	public static void main(String[] args)
	{
		int[] nums = new int[] {8,9,1,2,5,1,6,21,32};
		
		HeapSort solution = new HeapSort();
		solution.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
