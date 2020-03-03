package BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLocks {
	public int openLock(String[] deadends, String target) {
		if(target == null || target.length() == 0 || target.length() > 4)
		{
			return -1;
		}
		if (target == "0000") {
			return 0;
		}
		int steps = 0;
		Set<String> deadendSet = new HashSet<String>(Arrays.asList(deadends));
		Set<String> combinationSeen = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();

		queue.offer("0000");
		queue.offer(null);

		while (!queue.isEmpty()) {
			if (queue.poll() == null) {
				steps++;
				if (queue.peek() != null) {
					queue.offer(null);
				}
			}

			String orginalString = queue.poll();
			if (orginalString.contentEquals(target)) {
				return steps;
			}
			
			if(deadendSet.contains(orginalString))
			{
				continue;
			}
			
			if(!combinationSeen.contains(orginalString))
			{
				combinationSeen.add(orginalString);
			}
			
			for (int index = 0; index < 4; index++) {
				for (int change = -1; change <= 1; change += 2) {
					String changedString = orginalString.substring(0, index)
							+ (orginalString.charAt(index - '0') + change + 10) % 10
							+ orginalString.substring(index + 1);
					if (!combinationSeen.contains(changedString)) {
						queue.offer(changedString);
					}

				}
			}
		}
		return steps;
	}
}
