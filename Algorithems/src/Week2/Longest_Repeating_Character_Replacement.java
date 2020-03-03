package Week2;

public class Longest_Repeating_Character_Replacement
{
    public static int characterReplacement(String s, int k)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        int windowSize = 1 + k;
        if (windowSize >= s.length())
        {
            return s.length();
        }

        for (int i = 0; i + windowSize-1 < s.length(); i++)
        {
            windowSize = Math.max(windowSize, k + longestRepeatedChars(s.substring(i, i + windowSize)));
        }

        return windowSize;
    }

    private static int longestRepeatedChars(String str)
    {
        int biggestSum = 1;

        for (int i = 0; i < str.length() - 1; i++)
        {
            int currentSum = 1;
            for (int j = i + 1; j < str.length(); j++)
            {
                if (str.charAt(i) == str.charAt(j))
                {
                    currentSum++;
                    biggestSum = Math.max(biggestSum, currentSum);
                }
            }
        }
        return biggestSum;
    }

    public static void main(String[] args)
    {
        String s = "ABDCDSDSFSADFDCSFDDDFSSSDDD";
        String s1 ="AABABBA";
                
        //System.out.println(characterReplacement(s, 2));
        System.out.println(characterReplacement(s1, 1));
    }
}
