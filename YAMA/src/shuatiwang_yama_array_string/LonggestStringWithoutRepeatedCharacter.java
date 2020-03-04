package shuatiwang_yama_array_string;

public class LonggestStringWithoutRepeatedCharacter {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        
        if(s.length() == 1)
        {
            return 1;
        }
        
        int startLocation = 0;
        int maxLength = 1;
        
        for(int i = 1; i < s.length() ; i++)
        {
            String currentString = s.substring(startLocation, i);
            if(currentString.indexOf(s.charAt(i)) != -1)
            {
                maxLength = Math.max(maxLength, i - startLocation);
                startLocation = startLocation + currentString.indexOf(s.charAt(i)) + 1;
            }
        }
        
        if(startLocation < s.length())
        {
            maxLength = Math.max(maxLength, s.length() - startLocation);
        }
        
        return maxLength;
    }
}
