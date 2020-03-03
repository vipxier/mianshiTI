package EasyQuestions;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {

	public static int[][] merge(int[][] intervals) {
		List<int[]> list = new ArrayList<int[]>();
		if (intervals == null || intervals.length == 0) {
			return null;
		}

		if (intervals.length == 1) {
			return intervals;
		}

		for (int i = 0; i < intervals.length - 1; i++) {

			if (intervals[i][0] < intervals[i + 1][0] && intervals[i][1] < intervals[i + 1][1]) {
				int[] intervalResult = new int[2];
				intervalResult[0] = intervals[i][0];
				intervalResult[1] = intervals[i + 1][1];
				list.add(intervalResult);
			}

		}

		int[][] resultArray = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			resultArray[i][0] = list.get(i)[0];
			resultArray[i][1] = list.get(i)[1];
		}
		return resultArray;
	}

	public static void main(String[] args)
	{
		int[][] nums = {{1, 3}, {2,6}, {8,10}, {15,18}};
		int[][] result = merge(nums);
	}
}
