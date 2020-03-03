import utils.ArrayUtils;

public class MergeSortPractice {
	public static void mergeSort(int[] array) {
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
		int n1 = mid - start + 1;
		int n2 = end - mid;

		int[] left = new int[n1];
		int[] right = new int[n2];

//        for(int i = 0; i < n1; i++)
//        {
//            left[i] = array[i + start];
//        }
//        
//        for(int i = 0; i < n2; i ++)
//        {
//            right[i] = array[mid + 1 + i];
//        }

		left = ArrayUtils.initializeArrayFromParent(array, start, mid);
		right = ArrayUtils.initializeArrayFromParent(array, mid + 1, end);

		int left_index = 0;
		int right_index = 0;
		int result_index = start;

		while (left_index < n1 && right_index < n2) {
			if (left[left_index] < right[right_index]) {
				array[result_index++] = left[left_index++];
			} else {
				array[result_index++] = right[right_index++];
			}
		}

		while (left_index < n1) {
			array[result_index++] = left[left_index++];
		}

		while (right_index < n2) {
			array[result_index++] = right[right_index++];
		}
	}

	public static void main(String[] args) {
		int[] array = { 2, 1, 5, 8, 2, 3, 45323, 1, 15412, 123, 4 };

		mergeSort(array);

		ArrayUtils.printSingleDimentionArray(array);
	}
}
