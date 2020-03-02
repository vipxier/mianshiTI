package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxUtilization {
	public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList,
			int[][] returnRouteList) {
		List<List<Integer>> res = new ArrayList<>();
		int len1 = forwardRouteList.length, len2 = returnRouteList.length;
		if (len1 == 0 || len2 == 0)
			return res;
		Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
		Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
		int left = 0, right = len2 - 1, maxVal = -1;
		HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
		while (left < len1 && right >= 0) {
			int sum = forwardRouteList[left][1] + returnRouteList[right][1];
			if (sum > maxTravelDist) {
				--right;
				continue;
			}
			if (sum >= maxVal) {
				int r = right;
				map.putIfAbsent(sum, new ArrayList<>());
				// check the duplicates
				while (r >= 0 && returnRouteList[r][1] == returnRouteList[right][1]) {
					List<Integer> list = new ArrayList<>();
					list.add(forwardRouteList[left][0]);
					list.add(returnRouteList[r][0]);
					map.get(sum).add(list);
					--r;
				}
				maxVal = sum;
			}
			++left;
		}
		return map.get(maxVal);
	}

	public List<List<Integer>> maxPairs(int target, int[][] nums1, int[][] nums2) {
		Comparator<int[]> arrayComparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] array1, int[] array2) {
				return array1[1] - array2[1];
			}
		};

		Arrays.sort(nums1, arrayComparator);
		Arrays.sort(nums2, arrayComparator);

		int nums1Index = nums1.length - 1;
		int nums2Index = 0;
		int maxSum = Integer.MIN_VALUE;
		Map<Integer, List<List<Integer>>> hashMap = new HashMap<>();

		while (nums1Index >= 0 && nums2Index < nums2.length) {
			int sum = nums1[nums1Index][1] + nums2[nums2Index][1];
			if (sum > target) {
				nums1Index--;
				continue;
			}

			if (sum >= maxSum) {
				int rightIndex = nums1Index;
				if (!hashMap.containsKey(sum)) {
					hashMap.put(sum, new ArrayList<List<Integer>>());
				}

				while (rightIndex >= 0 && nums1[rightIndex][1] == nums1[nums1Index][1]) {
					List<Integer> solution = new ArrayList<Integer>();
					solution.add(nums1[rightIndex][0]);
					solution.add(nums2[nums2Index][0]);
					hashMap.get(sum).add(solution);
					rightIndex--;
				}
				maxSum = sum;

			}
			nums2Index++;
		}

		return hashMap.get(maxSum);
	}

	public static void main(String[] args) {
		MaxUtilization main = new MaxUtilization();
		int[] maxTravelDists = { 7000, 10000, 10000 };
		int[][][] forwardRouteLists = { { { 1, 2000 }, { 2, 4000 }, { 3, 6000 } },
				{ { 1, 2000 }, { 2, 5000 }, { 3, 7000 }, { 4, 10000 } },
				{ { 1, 3000 }, { 2, 5000 }, { 3, 7000 }, { 4, 10000 } } };
		int[][][] returnRouteLists = { { { 1, 2000 } }, { { 1, 2000 }, { 2, 3000 }, { 3, 4000 }, { 4, 5000 } },
				{ { 1, 2000 }, { 2, 2000 }, { 3, 4000 }, { 4, 4000 } } };
		for (int i = 0; i < maxTravelDists.length; ++i) {
			System.out.println(main.aircraftUtilization(maxTravelDists[i], forwardRouteLists[i], returnRouteLists[i]));
			System.out.println(main.maxPairs(maxTravelDists[i], forwardRouteLists[i], returnRouteLists[i]));
		}
	}
}
