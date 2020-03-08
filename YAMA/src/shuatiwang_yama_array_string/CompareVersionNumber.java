package shuatiwang_yama_array_string;

public class CompareVersionNumber {
	public int compareVersion(String version1, String version2) {
	       
        String[] v1_array = version1.split("\\.");
        String[] v2_array = version2.split("\\.");

        int v1_index = 0;
        int v2_index = 0;
        String v1String = "";
        String v2String = "";
        while (v1_index < v1_array.length || v2_index < v2_array.length)
        {
            v1String = "";
            v2String = "";
            if(v1_index <= v1_array.length - 1) 
            {
               v1String = v1_array[v1_index];
            }
            
            if(v2_index <= v2_array.length - 1) 
            {
               v2String = v2_array[v2_index];
            }
           
            int v1 = convertToInt(v1String);
            int v2 = convertToInt(v2String);
            if(v1 > v2)
            {
                return 1;
            }
            else if(v1 < v2)
            {
                return -1;
            }
            v1_index++;
            v2_index++;
        }

        return 0;
    }
    
    private int convertToInt(String str)
    {
        if(str.length() == 0)
        {
            return 0;
        }
        
        int result = 0;
        for(int i = 0; i < str.length(); i ++)
        {
            result += result * 10 + str.charAt(i) - '0';
        }
        
        return result;
    }
}
