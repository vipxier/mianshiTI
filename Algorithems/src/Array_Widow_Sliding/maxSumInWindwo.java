package Array_Widow_Sliding;

import java.util.List;

public class maxSumInWindwo
{
    public static int getMaxSubArraySum(int[] array, int windowSize)
    {
        if (array == null || array.length == 0 || windowSize > array.length)
        {
            return 0;
        }
        int maxSum = 0;

        for (int i = 0; i < array.length - windowSize; i++)
        {
            int curretnWindowSum = array[i];
            for (int j = 1; j < windowSize; j++)
            {
                curretnWindowSum = curretnWindowSum + array[j + i];
            }
            maxSum = Math.max(maxSum, curretnWindowSum);
        }
        return maxSum;
    }

    public static int longestsubArrayChars_ForLoop(String str)
    {
        int loggestCount = 1;
        int currentLongestCount = 0;
        String result = "";
        
        for(int i = 0 ; i < str.length()-1; i ++)
        {
            if(str.charAt(i) == str.charAt(i+1))
            {
                currentLongestCount ++;
            }
            else
            {
                loggestCount = Math.max(loggestCount, currentLongestCount);
                currentLongestCount= 1;
            }
        }
        return loggestCount;
    }
    
    public static String longestSequenceCharsF_ForLoop(String str)
    {
        int maxLength = 0;
        String longestSequenceChars = "";
        for (int i = 0; i < str.length(); i++)
        {
            int currentCharCount = 0;
            for (int j = i + 1; j < str.length(); j++)
            {
                if (str.charAt(i) == str.charAt(j))
                {
                    currentCharCount++;
                }
            }
            if (maxLength < currentCharCount)
            {
                maxLength = currentCharCount;
                longestSequenceChars = "";
                for(int w = 1; w <= maxLength; w ++)
                {
                longestSequenceChars += str.charAt(i);
                }
            }
        }
        return longestSequenceChars;
    }

    public static void main(String[] args)
    {
        int[] array = { 1, 2, 3, 4, 5, 6, -8, 1, 2, 3 };
        System.out.println(getMaxSubArraySum(array, 5));

        String str = "abcdbddcbccssssdfdssssfgs";
        System.out.println(longestSequenceCharsF_ForLoop(str));
        
        System.out.println(longestsubArrayChars_ForLoop(str));
    }
}
