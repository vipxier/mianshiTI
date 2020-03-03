package BinaryManpulate;

import java.util.Stack;

public class DecimalToHexadecimal {
	public static String convertToHexacdecimal(int target) {
		Stack<Integer> stack = new Stack<Integer>();

		while (target != 0) {
			stack.push(target % 16);
			target = target / 16;
		}

		StringBuilder strBuilder = new StringBuilder();

		while (!stack.isEmpty()) {
			int digit = stack.pop();
			if (digit > 9) {
				strBuilder.append((char) ('A' + digit - 10));
			} else {
				strBuilder.append(digit);
			}
		}

		return strBuilder.toString();
	}

	public static void main(String[] args) {
		int target = 18;

		System.out.println(convertToHexacdecimal(target));
	}
}
