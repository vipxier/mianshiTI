package Array_Widow_Sliding;

public class LonggestSubArrayWithoutRepeat
{
    public static int lengthOfLongestSubstring(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        int windowSize = 1;
        int startPosition = 0;
        int maxWindowSize = 1;

        for (int i = 1; i < s.length() && startPosition < s.length(); i++)
        {
            if (!s.substring(startPosition, startPosition + windowSize)
                    .contains(new StringBuilder().append(s.charAt(i)).toString()))
            {
                windowSize++;
            }
            else
            {
                maxWindowSize = Math.max(maxWindowSize, windowSize);
                startPosition = s.substring(startPosition, startPosition + windowSize)
                        .lastIndexOf(new StringBuilder().append(s.charAt(i)).toString());
                windowSize = 1;
            }
        }
        //maxWindowSize = Math.max(maxWindowSize, windowSize);
        return maxWindowSize;

    }

    public static int longestDifferentSubString(String str)
    {
        if (str == null || str.length() == 0)
        {
            return 0;
        }
        int biggestWindowSize = 1;
        for (int i = 0; i < str.length(); i++)
        {

        }
        return 0;
    }

    public static void main(String[] args)
    {
        String str = "dvdf";

        System.out.println(lengthOfLongestSubstring(str));
    }
}
