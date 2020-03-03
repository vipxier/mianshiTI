package mcc_rv_2;

public class MInimumMoveToMakeNoRepeated3 {
	public static int solution(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}

		int aCount = 0;
		int bCount = 0;
		int changeCount = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				aCount++;
				bCount = 0;
			} else {
				aCount = 0;
				bCount++;
			}

			if (aCount == 3 || bCount == 3) {
				aCount = 0;
				bCount = 0;
				changeCount++;
			}
		}
		return changeCount;

	}

	public static void main(String[] args) {
		String S = "baaaaa";
		System.out.println(solution(S));

		String S1 = "baaabbaabbba";
		System.out.println(solution(S1));

		String S2 = "baabab";
		System.out.println(solution(S2));
	}
}
