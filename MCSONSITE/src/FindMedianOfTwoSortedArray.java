
public class FindMedianOfTwoSortedArray {
	public static double findMedianSortedArrays(int A[], int B[]) {
		int combinedArrayLength = A.length + B.length;

		if (combinedArrayLength % 2 == 0) {
			return (findKth(A, 0, B, 0, combinedArrayLength / 2) + 
						findKth(A, 0, B, 0, combinedArrayLength / 2 + 1))
					/ 2.0;
		}	

		return findKth(A, 0, B, 0, combinedArrayLength / 2 + 1);
	}

	private static int findKth(int[] arrayA, int startA, int[] arrayB, int startB, int k) {
		if (startA >= arrayA.length) {
			return arrayB[startB + k - 1];
		}

		if (startB >= arrayB.length) {
			return arrayA[startA + k - 1];
		}

		if (k == 1) {
			return Math.min(arrayA[startA], arrayB[startB]);
		}

		int valueA = startA + k / 2 - 1 < arrayA.length ? arrayA[startA + k / 2 - 1] : Integer.MAX_VALUE;
		int valueB = startB + k / 2 - 1 < arrayB.length ? arrayB[startB + k / 2 - 1] : Integer.MAX_VALUE;

		if (valueA < valueB) {
			return findKth(arrayA, startA + k / 2, arrayB, startB, k - k / 2);
		} else {
			return findKth(arrayA, startA, arrayB, startB + k / 2, k - k / 2);
		}
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5, 6 };
		int[] array2 = { 1, 3, 4, 5, 7, 8, 9, 10, 11 };

		System.out.println(findMedianSortedArrays(array1, array2));
	}
}
