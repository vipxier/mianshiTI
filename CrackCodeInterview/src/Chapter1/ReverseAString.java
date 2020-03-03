package Chapter1;

import java.util.Arrays;

public class ReverseAString {
	public static String reverseString(String str) {
		StringBuilder strb = new StringBuilder();
		for (int i = str.length(); i >= 1; i--) {
			strb.append(str.substring(i - 1, i));
		}
		return strb.toString();
	}

	public static String reverseString_2(String str) {
		if (str.length() % 2 == 1) {
			for (int i = 0; i < (str.length() - 1) / 2; i++) {
				str = swap(str, i, str.length() - 1 - i);
			}
		} else {
			for (int i = 0; i <= (str.length() - 1) / 2; i++) {
				str = swap(str, i, str.length() - 1 - i);
			}
		}
		return str;
	}

	private static String swap(String str, int index1, int index2) {
		StringBuilder strb = new StringBuilder();
		String[] array = str.split("");
		String temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;

		for (String string : array) {
			strb.append(string);
		}

		return strb.toString();
	}

	public static void main(String[] args) {
		String str = "abccddef";
		System.out.println(reverseString_2(str));
	}
}
