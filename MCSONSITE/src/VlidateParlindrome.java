
public class VlidateParlindrome {
	public static boolean isPalindrome(String s) {
		if (s.length() <= 1) {
			return true;
		}

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			while (start < end && (Character.toLowerCase(s.charAt(start)) < 'a'
					|| Character.toLowerCase(s.charAt(start)) > 'z')) {
				start ++;
			}
			
			while(start < end && (Character.toLowerCase(s.charAt(end)) < 'a'
					 || Character.toLowerCase(s.charAt(end)) > 'z'))
			{
				end --;
			}
			
			char c1 = Character.toLowerCase(s.charAt(start));
			char c2 = Character.toLowerCase(s.charAt(end));
			if (!(c1 >= 'a' && c1 <= 'z' && c1 == c2)) {
				return false;
			}

			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

		System.out.println(isPalindrome(",,,,00p000,,,,,,"));

		System.out.println(isPalindrome("race a car"));
	}
}
