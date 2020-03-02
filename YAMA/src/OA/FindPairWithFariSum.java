package OA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairWithFariSum {
	private static int[] Find2Sum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int[] res = new int[] {-1, -1};
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				if(nums[i] > max || target - nums[i] > max) {
					res[0] = map.get(nums[i]);
					res[1] = i;
					max = Math.max(nums[i], target - nums[i]);
				}
			}
			map.put(target - nums[i], i);
		}
		return res;
	}
	
	public static int[] getFairPari(int[] nums, int target)
	{
		if(nums == null || nums.length == 0)
		{
			return new int[] {-1, -1};
		}
		int[] result = new int[] {-1, -1};
		Map<Integer, Integer> hashMap = new HashMap<>();
		int maxValue = Integer.MIN_VALUE;
		
		for(int i = 0; i < nums.length; i ++)
		{
			if(hashMap.containsKey(nums[i]))
			{
				if(nums[i] > maxValue || target - nums[i] > maxValue)
				{
					result[0] = i;
					result[1] = hashMap.get(nums[i]);
					maxValue = Math.max(nums[i], target - nums[i]);
				}
			}
			hashMap.put(target - nums[i], i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 10, 25, 35, 60};
		int target1 = 90;
		System.out.println(Arrays.toString(Find2Sum(nums1, target1-30)));
		System.out.println(Arrays.toString(getFairPari(nums1, target1-30)));
		
		int[] nums2 = {20, 50, 40, 25, 30, 10};
		int target2 = 90;
		System.out.println(Arrays.toString(Find2Sum(nums2, target2-30)));
		System.out.println(Arrays.toString(getFairPari(nums2, target1-30)));
		
		int[] nums3 = {50, 20, 10, 40, 25, 30};
		int target3 = 90;
		System.out.println(Arrays.toString(Find2Sum(nums3, target3-30)));
		System.out.println(Arrays.toString(getFairPari(nums3, target1-30)));
		
		int[] nums4 = {1, 2};
		int target4 = 90;
		System.out.println(Arrays.toString(Find2Sum(nums4, target4-30)));
		System.out.println(Arrays.toString(getFairPari(nums4, target1-30)));
	}
}
