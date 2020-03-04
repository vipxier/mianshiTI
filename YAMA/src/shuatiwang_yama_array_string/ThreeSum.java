package shuatiwang_yama_array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			hashMap.clear();
			int start = i + 1;
			int end = nums.length - 1;
			int target = 0 - nums[i];
			while (start < end) {
				int sum = nums[start] + nums[end];
				if (sum < target) {
					start++;
					while (start < end && nums[start] == nums[start - 1]) {
						start++;
					}
				} else if (sum > target) {
					end--;
					while (start < end && nums[end] == nums[end + 1]) {
						end--;
					}
				} else {
					List<Integer> solution = new ArrayList<Integer>();
					solution.add(nums[i]);
					solution.add(nums[start]);
					solution.add(nums[end]);
					result.add(solution);

					start++;
					while (start < end && nums[start] == nums[start - 1]) {
						start++;
					}

					end--;
					while (start < end && nums[end] == nums[end + 1]) {
						end--;
					}
				}
			}
			while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i ++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] array = new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
		int[] array1 = new int[] { 0, 0, 0 };
		ThreeSum solution = new ThreeSum();
		for (List<Integer> subResult : solution.threeSum(array)) {
			System.out.println(subResult);
		}

		System.out.println();
		for (List<Integer> subResult : solution.threeSum(array1)) {
			System.out.println(subResult);
		}
	}
}
