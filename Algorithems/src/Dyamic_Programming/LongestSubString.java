package Dyamic_Programming;

public class LongestSubString
{

    private static String longgestSubStrings(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLength = 0, xlocation = 0, ylocation = 0;

        String[][] result = new String[len1 + 1][len2 + 1];
        for(int i = 0; i < len1+1; i++)
        {
            for(int j = 0; j < len2+1; j ++)
            {
                result[i][j] = "";
            }
        }

        for (int i = 1; i <= len1; i++)
        {
            for (int j = 1; j <= len2; j++)
            {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    result[i][j] = result[i - 1][j - 1] + str1.charAt(i - 1);
                    if (result[i][j].length() > maxLength)
                    {
                        maxLength = result[i][j].length();
                        xlocation = i;
                        ylocation = j;
                    }
                }
            }
        }

        return result[xlocation][ylocation];
    }

    public static void main(String[] args)
    {
        String str1 = "xyxxxyyyxxxyyycccxxx";
        String str2 = "zzxxxyyyxxyyyxxxyyyccc";
        System.out.println(longgestSubStrings(str1, str2));
        System.out.println("longest substring length is " + longgestSubStrings(str1, str2).length());
    }
}
