package Recursion;

import java.util.ArrayList;
import java.util.List;

public class TelephoneWordCombination {
	private String[] digitStrings = { "", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		generateCombinations(digitStrings, result, digits, "", 0);
		return result;
	}

	private void generateCombinations(String[] digitStrings, List<String> result, String digits, String currentCombination, int index)
	 {
		 if(index == digits.length())
		 {
			 result.add(currentCombination);
			 return;
		 }
		 
		 for(int i = 0; i < digitStrings[digits.charAt(index) - '0'].length(); i++)
		 {
			 currentCombination += digitStrings[digits.charAt(index) - '0'].charAt(i);
			 generateCombinations(digitStrings, result, digits, currentCombination, index + 1);
			 currentCombination = currentCombination.substring(0, currentCombination.length() - 1);
		 }
	 }
	
	public static void main(String[] args)
	{
		String digits = "234";
		TelephoneWordCombination solution = new TelephoneWordCombination();
		System.out.println(solution.letterCombinations(digits));
	}
}
