package Dyamic_Programming;

public class Shortest_Common_Supersequence
{
    private static String getSupresequence(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        
        String[][] result = new String[len1+1][len2+1];
        
        result[0][0] = "";
        for(int i = 1; i < len1; i ++)
        {
            result[i][0] = str1.substring(0, i-1);
        }
        
        for(int j = 1; j < len2; j++)
        {
            result[0][j] = str2.substring(0, j-1);
        }
        
        for(int i = 1; i <= len1; i ++)
        {
            for(int j = 1; j <= len2; j ++)
            {
                if(str1.charAt(i-1) != str2.charAt(j-1))
                {
                    result[i][j] = result[i-1][j-1] + str1.charAt(i-1) + str2.charAt(j-1);
                }
                else
                {
                    if(result[i-1][j].length() < result[i][j-1].length())
                    {
                        result[i][j] = result[i-1][j] + str1.charAt(i-1);
                    }
                    else
                    {
                        result[i][j] = result[i][j-1] + str1.charAt(i-1);
                    }
                }
            }
        }
        return result[len1][len2];
    }
    
    public static void main(String[] args)
    {
        System.out.println("SHorted: " + getSupresequence("ABCBDAB", "BDCABA"));
    }
}
