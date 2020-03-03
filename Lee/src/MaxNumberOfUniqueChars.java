
public class MaxNumberOfUniqueChars
{
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        
        int uniqueStart = 0;
        int uniqueEnd = 0;
        int uniqueLength = 1;
        int max_unique_length = 1;
        
        char[] characters = s.toCharArray();
        
        for(int i = uniqueEnd + 1; i < characters.length ; i ++)
        {
           int index = getIndex(characters[i], characters, uniqueStart, uniqueEnd);
           if(index != -1)
           {
               uniqueStart = index;
               uniqueEnd = i;
           }
           else
           {
               uniqueEnd += 1;
               if(max_unique_length < uniqueEnd - uniqueStart + 1)
               {
                  max_unique_length = uniqueEnd - uniqueStart + 1;
               }
           }
        }
        return max_unique_length;
    }
    
    private static int getIndex(char c, char[] array, int start, int end)
    {
        for(int i = start; i <= end; i ++)
        {
            if(array[i] == c)
            {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
