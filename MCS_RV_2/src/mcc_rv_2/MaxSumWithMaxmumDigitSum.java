package mcc_rv_2;

import java.util.HashMap;
import java.util.Map;

public class MaxSumWithMaxmumDigitSum {
	public static int solution(int[] array) {
		if (array == null || array.length <= 1) {
			return -1;
		}

		int maxSum = -1;
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			int digitsSum = getDigitsSum(array[i]);

			if (hashMap.containsKey(digitsSum)) {
				maxSum = Math.max(maxSum, array[i] + hashMap.get(digitsSum));
				hashMap.put(digitsSum, Math.max(array[i], hashMap.get(digitsSum)));
			} else {
				hashMap.put(digitsSum, array[i]);
			}
		}

		return maxSum;
	}

	private static int getDigitsSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 51, 71, 17, 42, 33, 44, 24, 62 };
		int[] array1 = new int[] { 51, 71, 17, 42 };
		int[] array2 = new int[] { 42, 33, 60, 92, 335 };
		int[] array3 = new int[] { 51, 32, 43 };
		
		System.out.println(solution(array));
		System.out.println(solution(array1));
		System.out.println(solution(array2));
		System.out.println(solution(array3));
	}
}
