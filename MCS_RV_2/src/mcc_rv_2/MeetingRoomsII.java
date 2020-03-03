package mcc_rv_2;

import java.util.Arrays;

public class MeetingRoomsII {
	public static int solution(int[][] intervals)
	{
		if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
		{
			return 0;
		}
		
		int[] startTimes = new int[intervals.length];
		int[] endTimes = new int[intervals.length];
		for(int i = 0; i < intervals.length; i ++)
		{
			startTimes[i] = intervals[i][0];
			endTimes[i] = intervals[i][1];
		}
		
		Arrays.sort(startTimes);
		Arrays.sort(endTimes);
		int roomsCount = 0;
		int endIndex = 0;
		for(int i = 0; i < intervals.length; i ++)
		{
			if(startTimes[i] < endTimes[endIndex])
			{
				roomsCount ++;
			}
			else
			{
				endIndex ++;
			}
		}
		
		return roomsCount;
	}
}
