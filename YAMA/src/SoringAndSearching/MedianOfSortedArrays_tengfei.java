package SoringAndSearching;

public class MedianOfSortedArrays_tengfei {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int combinedArrayLength = nums1.length + nums2.length;

		if (combinedArrayLength % 2 == 0) {
			return (findKth(nums1, 0, nums2, 0, combinedArrayLength / 2) + findKth(nums1, 0, nums2, 0, combinedArrayLength / 2 + 1))
					/ 2.0;
		}

		return findKth(nums1, 0, nums2, 0, combinedArrayLength / 2 + 1);
	}

	private int findKth(int[] nums1, int startA, int[] nums2, int startB, int k) {
		if (startA >= nums1.length) {
			return nums2[startB + k - 1];
		}

		if (startB >= nums2.length) {
			return nums1[startA + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[startA], nums2[startB]);
		}

		int halfKthOfA = startA + k / 2 - 1 < nums1.length ? nums1[startA + k / 2 - 1] : Integer.MAX_VALUE;
		int halfKthOfB = startB + k / 2 - 1 < nums2.length ? nums2[startB + k / 2 - 1] : Integer.MAX_VALUE;
		
		if (halfKthOfA < halfKthOfB) {
			return findKth(nums1, startA + k / 2, nums2, startB, k - k / 2);
		} else {
			return findKth(nums1, startA, nums2, startB + k / 2, k - k / 2);
		}
	}
}
