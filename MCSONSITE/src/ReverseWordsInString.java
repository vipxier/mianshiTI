class ReverseWordsInString {
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        
        int startIndex = 0;
        int endIndex = s.length() - 1;
        
        while(startIndex <= endIndex && s.charAt(startIndex) == ' ')
        {
            startIndex ++;
        }
        
        while(endIndex >= 0 && s.charAt(endIndex) == ' ')
        {
            endIndex --;
        }
        
        if(endIndex <= 0)
        {
            return "";
        }
        StringBuilder strb = new StringBuilder();
        for(int i = startIndex; i <= endIndex; i ++)
        {
            if(s.charAt(i) == ' ' && s.charAt(i + 1) == ' ')
            {
                continue;
            }
            strb.append(s.charAt(i)); 
        }
        
        int start = 0;
        char[] array = strb.toString().toCharArray();
        for(int i = 0; i < array.length; i ++)
        {
            if(array[i] == ' ')
            {
                reverse(array, start, i - 1);
                start = i + 1;
            }
        }
        
        reverse(array, start, array.length - 1);
        reverse(array, 0, array.length - 1);
        String result = new String(array);
        return result;
    }
    
    private static void reverse(char[] array, int start, int end)
    {
        
        if(start == end)
        {
            return;
        }
        
        while(start < end)
        {
            char c = array[start];
            array[start] = array[end];
            array[end] = c;
            
            start ++;
            end --;
        }
    }
    
    public static void main(String[] args)
    {
    	System.out.println(reverseWords(" "));
    }
}