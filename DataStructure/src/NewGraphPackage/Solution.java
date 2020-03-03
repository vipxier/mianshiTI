package NewGraphPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
	public int openLock(String[] deadends, String target) {
		if (target == null || target.length() == 0) {
			return 0;
		}

		Queue<String> queue = new LinkedList<>();
		int counter = 0;
		Set<String> visited = new HashSet<>();
		Set<String> dead = new HashSet<>(Arrays.asList(deadends));

		queue.offer("0000");
		queue.offer(null);
		while (!queue.isEmpty()) {
			String node = queue.poll();
			if(node == null)
			{
				counter++;
				if(queue.peek()!= null)
				{
					queue.offer(null);
				}
			}
			else if(node.contentEquals(target))
			{
				return counter;
			}
			else if(!dead.contains(node))
			{
				for(int i = 0; i < node.length(); i ++)
				{
					for(int d = -1; d <= 1 ; d += 2)
					{
						int y = (node.charAt(i) - '0' + d + 10) % 10;
						String nei = node.substring(0, i) + "" + y + node.substring(i + 1);
						
						if(!visited.contains(nei))
						{
							queue.offer(nei);
							visited.add(nei);
						}
					}
				}
			}
			
		}

		return -1;
	}

	private List<String> generateCombinations(String str, Set<String> visited) {
		List<String> combinations = new ArrayList<>();
		if (str == null || str.length() == 0) {
			return combinations;
		}

		int[] adjustment = new int[] { -1, 1 };
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < adjustment.length; j++) {
				char[] array = str.toCharArray();
				if (array[i] == '0' && adjustment[j] == -1) {
					array[i] = '9';
				} else if (array[i] == '9' && adjustment[j] == 1) {
					array[i] = '0';
				} else {
					array[i] = (char) (array[i] + adjustment[j]);
				}
				String combination = new String(array);
				if (visited.contains(combination)) {
					continue;
				}
				combinations.add(new String(array));
			}
		}

		return combinations;
	}

	public static void main(String[] args) {
		String[] deadend = new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
		String target = "8888";

		Solution solution = new Solution();

		System.out.println(solution.openLock(deadend, target));
	}
}
