package shuatiwang_yama_array_string;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		Arrays.sort(nums);
		int minSumBiggerThanTarget = Integer.MAX_VALUE;
		int maxSumSmallerThanTarget = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			int tempTarget = target - nums[i];
			int tempBigger = Integer.MAX_VALUE;
			int tempSmaller = Integer.MIN_VALUE;
			while (start < end) {
				int sum = nums[start] + nums[end];
				if (sum == tempTarget) {
					return target;
				} else if (sum > tempTarget) {
					if (sum < tempBigger) {
						tempBigger = sum;
						tempSmaller = tempTarget - (tempBigger - sum); 
					}
					end--;
				} else if (sum < tempTarget) {
					if (sum > tempSmaller) {
						tempSmaller = sum;
						tempBigger = tempTarget + (sum - tempSmaller);
					}
					start++;
				}
			}
			minSumBiggerThanTarget = Math.min(minSumBiggerThanTarget, tempBigger + nums[i]);
			maxSumSmallerThanTarget = Math.max(maxSumSmallerThanTarget, tempSmaller + nums[i]);
		}

		return Math.abs(minSumBiggerThanTarget - target) > Math.abs(maxSumSmallerThanTarget - target)
				? maxSumSmallerThanTarget
				: minSumBiggerThanTarget;
	}

	public static void main(String[] args) {
		int[] array = new int[] { -1, 2, 1, -4 };
		ThreeSumClosest solution = new ThreeSumClosest();

		System.out.println(solution.threeSumClosest(array, 1));
	}
}
