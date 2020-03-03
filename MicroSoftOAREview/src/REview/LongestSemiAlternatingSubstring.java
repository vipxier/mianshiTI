package REview;

public class LongestSemiAlternatingSubstring {
	public static int solution(String str) {
		if(str == null)
		{
			return 0;
		}
		if (str.length() < 3) {
			
			return str.length();
		}

		int start = 0;
		int end = 0;
		int length = str.length();
		int maxLength = Integer.MIN_VALUE;
		int counter = 1;

		for (int i = 0; i < str.length() - 1; i++) {
			counter = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) == str.charAt(j - 1)) {
					counter++;
				} else {
					counter = 1;
				}

				if (counter == 3 || j == str.length() - 1) {
					if (maxLength < i - j + 1) {
						start = i;
						end = (counter == 3) ? j - 1 : j;
						maxLength = j - i + 1;
					}

					i = j - 2;
					break;
				}
			}

			if (i == str.length() - 3) {
				break;
			}
		}

		return maxLength;
	}

	public static int anotherSolution(String str) {
		if (str == null) {
			return 0;
		}
		if (str.length() <= 2) {
			return str.length();
		}

		int maxLength = Integer.MIN_VALUE;
		int aCount = 0;
		int bCount = 0;
		int start = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				aCount++;
				bCount = 0;
			} else {
				bCount++;
				aCount = 0;
			}

			if (aCount == 3 || bCount == 3) {
				start = i - 1;

				if (aCount == 3) {
					aCount = 2;
				} else if (bCount == 3) {
					bCount = 2;
				}
			} else {
				maxLength = Math.max(maxLength, i - start + 1);
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s1 = "baaabbabbb";
		String s2 = "babba";
		String s3 = "abaaaa";
		String s4 = "a";
		System.out.println(anotherSolution(s1));
		System.out.println(anotherSolution(s2));
		System.out.println(anotherSolution(s3));
		System.out.println(anotherSolution(s4));
	}
}
