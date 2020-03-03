package Dyamic_Programming;

public class StringDiff
{
    public static String findDifference(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        boolean printPlus = false;
        boolean prevDifferent = false;

        String[][] result = new String[len1 + 1][len2 + 1];
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i <= len1; i++)
        {
            for (int j = 0; j <= len2; j++)
            {
                result[i][j] = "";
            }
        }
        
        for(int i = 1; i <= len1; i ++)
        {
            for (int j = 1; j <= len2; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1) && i == j)
                {
                    if(!printPlus) {
                        result[i][j] = result[i-1][j-1] + str1.charAt(i-1);
                        printPlus = prevDifferent;
                    }
                    else
                    {
                        result[i][j] = result[i-1][j-1] +strBuilder.toString() + str1.charAt(i-1);
                        printPlus = false;
                        strBuilder.setLength(0);
                    }
                }
                else if(i == j)
                {
                    result[i][j] = result[i-1][j-1] + "-" + str1.charAt(i-1);
                    prevDifferent = true;
                    strBuilder.append("+").append(str2.charAt(j-1));
                }
            }
        }
        
        StringBuilder resultBuilder = new StringBuilder();;
        if(len1 > len2)
        {
            resultBuilder.append(result[len2][len2]);
            for(int i = len2; i < len1; i++)
            {
                resultBuilder.append(str1.charAt(i));
            }
        }
        else
        {
            resultBuilder.append(result[len1][len1]);
            for(int i = len1; i < len2; i ++)
            {
                resultBuilder.append(str2.charAt(i));
            }
        }
        
        return resultBuilder.toString();
    }
    
    
    public static void main(String[] args)
    {
        String str1 = "XMJYAUZ", 
               str2 = "XMJAATZ";
        System.out.println("The diff string should be: " + findDifference(str1, str2));
    }
}
