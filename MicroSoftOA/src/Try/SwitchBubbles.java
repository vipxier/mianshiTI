package Try;

import java.util.ArrayList;
import java.util.List;

public class SwitchBubbles {
	public static List<Integer> switchBubble(int[] bubbles)
	{
		List<Integer> result = new ArrayList<Integer>();
		int max = 0;
		for(int i = 0; i < bubbles.length; i ++)
		{
			int value = bubbles[i];
			max = Math.max(max, value);
			if(max == i + 1)
			{
				result.add(i);
			}
		}
		
		return result;
	}
}
