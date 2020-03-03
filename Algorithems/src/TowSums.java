import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.ArrayUtils;

public class TowSums {
	/*
	 * The class to hold the result with only the number
	 */
	private static class Result {
		int data1;
		int data2;

		public Result(int data1, int data2) {
			this.data1 = data1;
			this.data2 = data2;
		}
	}

	/*
	 * The class to hold the result with sum
	 */
	private static class Result_R {
		int data1;
		int data2;
		int result;

		public Result_R(int data1, int data2, int result) {
			this.data1 = data1;
			this.data2 = data2;
			this.result = result;
		}
	}

	/*
	 * Find if there are two numbers in the array can sum up to the provided sum.
	 */
	public static boolean checkSum(int[] array, int sum) {
		if (array == null || array.length == 0) {
			System.out.println("Array Issue");
			return false;
		}
		Set<Integer> map = new HashSet<Integer>();

		for (int i = 0; i < array.length; i++) {
			if (!map.contains(array[i])) {
				map.add(sum - array[i]);
			} else {
				return true;
			}
		}
		return false;
	}

	/*
	 * Find all the possible value pairs to sum up to the provided number.
	 */
	public static List<Result> getAllSumsResults(int[] array, int sum) {
		List<Result> result = new ArrayList<Result>();

		if (array == null || array.length == 0) {
			return result;
		}

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < array.length; i++) {
			if (set.contains(array[i])) {
				result.add(new Result(sum - array[i], array[i]));
			} else {
				set.add(sum - array[i]);
			}
		}
		return result;
	}

	/*
	 * Get the all the possible value pairs in the array to sum up to the value in
	 * the array.
	 * 
	 * Example: array: { 1, 3, 4, 5, 1, 1, 1, 16, 7, 8, 9 } Result : 16: 9 7 9: 5 4
	 * 9: 8 1 8: 5 3 8: 7 1 7: 4 3 5: 4 1 4: 3 1
	 */
	public static List<Result_R> getSums(int[] array) {
		mergeSort(array);
		List<Result_R> result = new ArrayList<Result_R>();
		for (int i = array.length - 1; i >= 1; i--) {
			result.addAll(getAllSumResult_R(array, 0, i - 1, array[i]));
		}

		return result;
	}

	private static List<Result_R> getAllSumResult_R(int[] array, int start, int end, int target) {
		Set<Integer> set = new HashSet<Integer>();
		List<Result_R> result = new ArrayList<Result_R>();
		for (int i = start; i <= end; i++) {
			if (set.contains(array[i])) {
				result.add(new Result_R(array[i], target - array[i], target));
			} else {
				set.add(target - array[i]);
			}
		}
		return result;
	}

	private static void mergeSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			sort(array, start, mid);
			sort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}

	private static void merge(int[] array, int start, int mid, int end) {
		int len1 = mid - start + 1;
		int len2 = end - mid;

		int[] left = ArrayUtils.initializeArrayFromParent(array, start, mid);
		int[] right = ArrayUtils.initializeArrayFromParent(array, mid + 1, end);

		int lIndex = 0, rIndex = 0, resultIndex = start;

		while (lIndex < len1 && rIndex < len2) {
			if (left[lIndex] <= right[rIndex]) {
				array[resultIndex++] = left[lIndex++];
			} else {
				array[resultIndex++] = right[rIndex++];
			}
		}

		while (lIndex < len1) {
			array[resultIndex++] = left[lIndex++];
		}

		while (rIndex < len2) {
			array[resultIndex++] = right[rIndex++];
		}
	}

	public List<List<Integer>> getAllPossibleNumbers(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Result_R> possible_solutions = getSums(array);
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (set.contains(array[i])) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(array[i]);
				list.add(target - array[i]);
				result.add(list);
				list.clear();
				list.add(target - array[i]);
				result.addAll(getFactor(possible_solutions, array[i], target - array[i],list));
				list.clear();
				list.add(array[i]);
				result.addAll(getFactor(possible_solutions, target - array[i], array[i], list));
			} else {
				set.add(target - array[i]);
			}
		}
		return result;
	}

	private List<List<Integer>> getFactor(List<Result_R> possible_solutions, int target, int compatibleCheckNumber, List<Integer> list) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < possible_solutions.size(); i++) {
			if (possible_solutions.get(i).result == target && possible_solutions.get(i).data1 != compatibleCheckNumber
					&& possible_solutions.get(i).data2 != compatibleCheckNumber) 
			{
				list.add(possible_solutions.get(i).data1);
				list.add(possible_solutions.get(i).data2);
				result.add(list);
				result.addAll(getFactor(possible_solutions, possible_solutions.get(i).data1, possible_solutions.get(i).data2,list));
				result.addAll(getFactor(possible_solutions, possible_solutions.get(i).data2, possible_solutions.get(i).data1, list));
			}
		}
		return result;

	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 2, 4, 5, 1, 1, 1, 16, 7, 8, 9 };
		System.out.println(checkSum(array, 9));

		for (Result result : getAllSumsResults(array, 15)) {
			System.out.println(result.data1 + " " + result.data2);
		}

		for (Result_R result : getSums(array)) {
			System.out.println(result.result + ": " + result.data1 + " " + result.data2);
		}
	}
}
