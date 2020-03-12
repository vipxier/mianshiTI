package SoringAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class MergeArrays {
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 0) {
			return intervals;
		}

		Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] array1, int[] array2) {
				return array1[0] - array2[0];
			}
		});

		for (int i = 0; i < intervals.length; i++) {
			queue.offer(intervals[i]);
		}

		List<int[]> resultList = new ArrayList<>();
		resultList.add(queue.poll());

		while (!queue.isEmpty()) {
			int[] arrayFromQueue = queue.poll();
			int[] arrayFromList = resultList.get(resultList.size() - 1);
			if (overLap(arrayFromList, arrayFromQueue)) {
				int[] combination = combineArrays(arrayFromList, arrayFromQueue);
				resultList.remove(resultList.size() - 1);
				resultList.add(combination);
			} else {
				resultList.add(arrayFromQueue);
			}
		}

		return resultList.toArray(new int[0][0]);
	}

	private int[] combineArrays(int[] array1, int[] array2) {
		int[] newArray = new int[2];
		newArray[0] = Math.min(array1[0], array2[0]);
		newArray[1] = Math.max(array1[1], array2[1]);
		return newArray;
	}

	private boolean overLap(int[] array1, int[] array2) {
		return array1[0] >= array2[0] || array1[1] >= array2[0];
	}
	
	public static void main(String[] args)
	{
		int[][] array = new int[][] {{1,3},{2,6},{8,10},{15,18}};
		MergeArrays solution = new MergeArrays();
		for(int[] array1 : solution.merge(array))
		{
			System.out.println(Arrays.toString(array1));
		}
		
	}
}
