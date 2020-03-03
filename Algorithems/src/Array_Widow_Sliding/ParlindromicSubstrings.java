package Array_Widow_Sliding;

public class ParlindromicSubstrings {

	public static int countSubstrings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int count = 0;
		String tempString = "";
		int windowSize = 1;
		for (int i = 0; i < s.length(); i++) {
			for (windowSize = 1; i + windowSize <= s.length(); windowSize++) {
				if (isPalindromic(tempString + s.substring(i, i + windowSize))) {
					count++;
				}
			}

			tempString = "";
		}

		return count;
	}

	public static boolean isPalindromic(String str) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			strBuilder.append(str.charAt(i));
		}

		return str.contentEquals(strBuilder.toString());
	}
	
	public static void main(String[] args)
	{
		String str = "aaa";
		System.out.println(countSubstrings(str));
	}
}
