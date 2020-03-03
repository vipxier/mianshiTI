package week3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfOverlappingRemove
{
    public static int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        
        if(intervals.length == 0 || intervals.length == 1)
        {
            return 0;
        }
        
       // intervals = MergeSortTwoDimentionalArray.mergeSort(intervals);
        
//        Arrays.sort(intervals, new Comparator<int[]>(){
//            @Override
//            public int compare(int[] o1,int[] o2){
//                    return o1[0]-o2[0];
//            }
//        });
        
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0] != o2[0]) {
                    return o1[0]-o2[0];
                }
                return o1[1]- o2[1];  
            }
        });
        
        int end = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i ++)
        {
            if(intervals[i][0] < end)
            {
                result++;
            }
            else
            {
                end = intervals[i][1];
            }
        }
        
        return result;
    }
    public static void main(String[] args)
    {
        int[][] array = { { 8, 9 }, { 2, 3 }, { 7, 10 }, { 2, 5 }, { 7, 8 } };
        System.out.println(eraseOverlapIntervals(array));
    }
}
