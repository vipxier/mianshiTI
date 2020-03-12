package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstKElementInArray {
	public List<Integer> firstKthInList(int[] list, int k)
	{
		Queue<Integer> queue = new PriorityQueue<Integer>(k);
		
		for(int num : list)
		{
			if(queue.size() == k) {
				queue.poll();
			}
			queue.offer(num);
		}
		
		return new ArrayList<Integer>(queue);
	}
	
	public static void main(String[] args)
	{
		FirstKElementInArray solution = new FirstKElementInArray();
		int[] nums = new int[] {1,9,3,7,1,7,3,2,9};
		
		System.out.println(solution.firstKthInList(nums,3));
	}
}

