package utils;

import java.util.List;

public class ListUtils {
	public static void printList(List<Integer> result)
	{
		StringBuilder strb = new StringBuilder();
		for(int i : result)
		{
			strb.append(" " + i);
		}
		System.out.println(strb.toString());
	}
}
