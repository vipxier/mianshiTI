package shuatiwang_yama_array_string;

public class implementStStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
            return -1;
        }
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // finished loop, needle found
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
	}
	
	public int strStr_my(String haystack, String needle) {
		if (haystack == null || needle == null ||haystack.length() < needle.length()) {
            return -1;
        }
        
        for(int i = 0; i < haystack.length() - needle.length(); i++)
        {
        	if(haystack.charAt(i) == needle.charAt(0))
        	{
        		for(int j = 0; j < needle.length(); j ++)
        		{
        			if(haystack.charAt(i + j) != needle.charAt(j))
        			{
        				break;
        			}
        		}
        		
        		return i;
        	}
        }
        return -1;
	}
	
	public static void main(String[] args)
	{
		String str = "hello";
		String needle = "ll";
		
		implementStStr solution = new implementStStr();
		System.out.println(solution.strStr(str, needle));
	}
}
