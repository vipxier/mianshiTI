import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConcateStringforUniqueChars {
	public static int solution(String[] strs) {
		if (strs == null || strs.length == 0) {
			return 0;
		}

		List<String> stringList = new ArrayList<String>();

		helper(strs, stringList, "", 0);

		int maxLength = 0;

		for (String str : stringList) {
			if (maxLength < str.length() && containsUniqueChars(str)) {
				maxLength = str.length();
			}
		}

		return maxLength;
	}

	private static boolean containsUniqueChars(String str) {
		HashSet<Character> hashSet = new HashSet<Character>();

		for (char c : str.toCharArray()) {
			hashSet.add(c);
		}

		return hashSet.size() == str.length();
	}

	private static void helper(String[] strs, List<String> result, String currentCombination, int currentIndex) {
		if(currentIndex == strs.length) {
			result.add(currentCombination);
		return;
		}

		for (int i = currentIndex; i < strs.length; i++) {
			helper(strs, result, currentCombination + strs[i], i + 1);
		}
	}

	public static void main(String[] args) {
		String[] strArray = new String[] { "Un", "i", "que" };
		String[] A = { "co", "dil", "ity" }; // function should return 5, resulting string S could be codil , dilco,
												// coity,ityco
		String[] B = { "abc", "kkk", "def", "csv" }; // , returns 6 , resulting Strings S could be abcdef , defabc,
														// defcsv , csvdef
		String[] C = { "abc", "ade", "akl" }; // , return 0 , impossible to concatenate as letters wont be unique.
		System.out.println(solution(strArray));
		System.out.println(solution(A));
		System.out.println(solution(B));
		System.out.println(solution(C));
	}
}
