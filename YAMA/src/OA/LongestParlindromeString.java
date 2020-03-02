package OA;

public class LongestParlindromeString {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() <= 1)
        {
            return s;
        }
        
        int parlindromeStart = 0;
        int longestParlindromeLength = 0;
        int currentParlindromeLength = 0;
        
        for(int i = 0; i < s.length() ; i ++)
        {
            currentParlindromeLength = getLonggestParlindrome(s, i, i);
            if(currentParlindromeLength > longestParlindromeLength)
            {
                longestParlindromeLength = currentParlindromeLength;
                parlindromeStart = i - currentParlindromeLength / 2;
            }
            
            currentParlindromeLength = getLonggestParlindrome(s, i, i + 1);
            if(currentParlindromeLength > longestParlindromeLength)
            {
                longestParlindromeLength = currentParlindromeLength;
                parlindromeStart = i - currentParlindromeLength / 2 + 1;
            }
        }
        
        return s.substring(parlindromeStart, parlindromeStart + longestParlindromeLength);
    }
    
    private int getLonggestParlindrome(String str, int left, int right)
    {
        int parlindromeLength = 0;
        while(left >= 0  && right < str.length())
        {
            if(str.charAt(left) != str.charAt(right))
            {
                break;
            }
            parlindromeLength += left == right ? 1 : 2;
            left --;
            right ++;
        }
        
        return parlindromeLength;
    }
}