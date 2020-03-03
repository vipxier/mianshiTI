
public class LonggestParlindrome {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		int currentParlindromeLength = 0;
		int longestLength = 0;
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			currentParlindromeLength = getLonggestParlindromeLength(s, i, i);
			if (currentParlindromeLength > longestLength) {
				longestLength = currentParlindromeLength;
				start = i - currentParlindromeLength / 2;
			}

			currentParlindromeLength = getLonggestParlindromeLength(s, i, i + 1);
			{
				if (currentParlindromeLength > longestLength) {
					longestLength = currentParlindromeLength;
					start = i - currentParlindromeLength / 2 + 1;
				}
			}
		}

		return s.substring(start, start + longestLength);
	}

	private static int getLonggestParlindromeLength(String s, int start, int end) {
		int parlindromeLength = 0;
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			parlindromeLength += (start == end ? 1 : 2);
			start--;
			end++;
		}

		return parlindromeLength;
	}
	
	
	public static void main(String[] args)
	{
		
		System.out.println(longestPalindrome("abbaa"));
	}
}

