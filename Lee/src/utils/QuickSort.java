package utils;

public class QuickSort {
	public static void solution(int[] array) {
		int start = 0;
		int end = array.length - 1;

		quickSort(array, start, end);
	}

	private static void quickSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int left = start;
		int right = end;
		int pivot = array[left];

		while (left <= right) {
			while (left <= right && array[left] < pivot) {
				left++;
			}

			while (left <= right && array[right] > pivot) {
				right--;
			}

			if (left <= right) {
				swap(array, left, right);

				left++;
				right--;
			}
		}

		quickSort(array, start, right);
		quickSort(array, left, end);

	}

	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 5, 1, 7, 2, 1, 9, 3, 5 };

		solution(array);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
