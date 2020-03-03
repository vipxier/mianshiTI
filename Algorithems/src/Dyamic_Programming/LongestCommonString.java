package Dyamic_Programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LT028861
 *
 */
/**
 * @author LT028861
 *
 */
public class LongestCommonString
{
    /**
     * Recurrsion Solution
     */
    private static int LSC(String str1, String str2, int len1, int len2)
    {
        if (len1 == 0 || len2 == 0)
        {
            return 0;
        }

        if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1))
        {
            return LSC(str1, str2, len1 - 1, len2 - 1) + 1;
        }

        return Math.max(LSC(str1, str2, len1 - 1, len2), LSC(str1, str2, len1, len2 - 1));
    }

    /**
     * DP solution
     */
    private static int LSC_DP(String str1, String str2)
    {
        int[][] record = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++)
        {
            for (int j = 1; j <= str2.length(); j++)
            {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    record[i][j] = record[i - 1][j - 1] + 1;
                }
                else
                {
                    record[i][j] = Math.max(record[i - 1][j], record[i][j - 1]);
                }
            }
        }
        return record[str1.length()][str2.length()];
    }

    /**
     * Return the result string array for latter processing.
     */
    public static int[][] LSCResult(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] result = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++)
        {
            for (int j = 1; j <= len2; j++)
            {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    result[i][j] = result[i - 1][j - 1] + 1;
                }
                else
                {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result;
    }

    /**
     * Get The longest Common string iteself;
     */
    public static String getLCSString(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();

        String[][] result = new String[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
        {
            for (int j = 0; j <= len2; j++)
            {
                result[i][j] = "";
            }
        }

        for (int i = 1; i <= len1; i++)
        {
            for (int j = 1; j <= len2; j++)
            {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    result[i][j] = result[i - 1][j - 1] + str1.charAt(i - 1);
                else
                {
                    if (result[i - 1][j].length() >= result[i][j - 1].length())
                    {
                        result[i][j] = result[i - 1][j];
                    }
                    else
                    {
                        result[i][j] = result[i][j - 1];
                    }
                }
            }
        }
        return result[len1][len2];
    }

    /**
     * Get all the common strings.
     */
    public static Set<String> getAllLCSStrings(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();

        String[][] result = new String[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
        {
            for (int j = 0; j <= len2; j++)
            {
                result[i][j] = "";
            }
        }

        for (int i = 1; i <= len1; i++)
        {
            for (int j = 1; j <= len2; j++)
            {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    result[i][j] = result[i - 1][j - 1] + str1.charAt(i - 1);
                else
                {
                    if (result[i - 1][j].length() >= result[i][j - 1].length())
                    {
                        result[i][j] = result[i - 1][j];
                    }
                    else
                    {
                        result[i][j] = result[i][j - 1];
                    }
                }
            }
        }

        Set<String> resultSet = new HashSet<String>();
        int lscLength = result[len1][len2].length();

        for (int i = len1; i >= 1; i--)
        {
            for (int j = len2; j >= 1; j--)
            {
                if (lscLength <= result[i][j].length())
                    resultSet.add(result[i][j]);
            }
        }
        return resultSet;
    }

    public static void main(String[] args)
    {
        String X = "ABCBDABCCAASCCASDA", Y = "BDCABACCSSCCAASDASD";
        System.out.println(LSC_DP(X, Y));
        System.out.println(LSC(X, Y, X.length(), Y.length()));
        for (String str : getAllLCSStrings(X, Y))
        {
            System.out.print(" " + str);
        }
    }
}
