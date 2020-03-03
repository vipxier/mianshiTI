
public class MaxCommonProf
{
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
        {
            return "";
        }
        
        if(strs.length == 1)
        {
            return strs[0];
        }
        
        String commonString  = strs[0];
        StringBuilder strb = new StringBuilder();
        
        
        for(int i = 0; i < commonString.length(); i ++)
        {
            for(int j = 1; j < strs.length; j ++)
            {
                if(i >= strs[j].length() || commonString.charAt(i) != strs[j].charAt(i))
                {
                    return strb.toString();
                }
            }
            strb.append(commonString.charAt(i));
        }
        
        return strb.toString();
    }
    
    public static void main(String[] args)
    {
        String[] strings = {"a", "a"};
        String result = longestCommonPrefix(strings);
        System.out.println(result);
    }
}
