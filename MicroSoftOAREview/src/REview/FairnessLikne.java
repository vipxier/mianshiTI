package REview;

public class FairnessLikne {
	public static int solution(int[] A, int[] B) {
		if (A == null || B == null || A.length == 0 || B.length == 0) {
			return 0;
		}

		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
			sumB += B[i];
		}

		int counter = 0;
		int subSumA = 0;
		int subSumB = 0;
		for (int i = 0; i < A.length; i++) {
			subSumA += A[i];
			subSumB += B[i];

			if (subSumA == subSumB && subSumA * 2 == sumA && subSumB * 2 == sumB) {
				counter++;
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		int[] A1 = { 4, -1, 0, 3 }, B1 = { -2, 5, 0, 3 };
		int[] A2 = { 2, -2, -3, 3 }, B2 = { 0, 0, 4, -4 };
		int[] A3 = { 4, -1, 0, 3 }, B3 = { -2, 6, 0, 4 };
		int[] A4 = { 3, 2, 6 }, B4 = { 4, 1, 6 };
		int[] A5 = { 1, 4, 2, -2, 5 }, B5 = { 7, -2, -2, 2, 5 };
		int[] A6 = { 0, 0, 0 }, B6 = { 0, 0, 0 };
		System.out.println(solution(A1, B1));
		System.out.println(solution(A2, B2));
		System.out.println(solution(A3, B3));
		System.out.println(solution(A4, B4));
		System.out.println(solution(A5, B5));
		System.out.println(solution(A6, B6));
	}
}
