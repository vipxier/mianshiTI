
public class AddBinaryStrings
{
    // 67
    
    public static String addBinary(String a, String b) {
        if(a == null || b == null || (a.contentEquals("") && b.contentEquals("")))
        {
            return "";
        }
        
        if(a.length() == 0)
        {
            return b;
        }
        
        if(b.length() ==  0)
        {
            return a;
        }
        
        StringBuilder strb = new StringBuilder();
        
        int index1 = a.length();
        int index2 = b.length();
        String passingString = "0";
        while(index1 > 0 && index2 > 0)
        {
            String sum  = a.substring(index1 - 1, index1) + b.substring(index2 - 1, index2) + passingString;
            if(sum.contentEquals( "110") || sum.contentEquals("011") || sum.contentEquals( "101"))
            {
                passingString = "1";
                strb.append("0");
            }
            else if(sum.contentEquals( "001") || sum.contentEquals( "100")|| sum.contentEquals("010"))
            {
                passingString = "0";
                strb.append("1");
            }
            else if(sum.contentEquals( "000"))
            {
                passingString = "0";
                strb.append("0");
            }
            else if(sum.contentEquals( "111"))
            {
                passingString = "1";
                strb.append("1");
            }
            
            index1 --;
            index2 --;
        }
        
        while(index1 > 0)
        {
            String sum = a.substring(index1 - 1, index1) + passingString;
            
            if(sum.contentEquals( "00"))
            {
                passingString ="0";
                strb.append("0");
            }
            else if (sum.contentEquals( "01" )|| sum.contentEquals( "10"))
            {
                passingString  ="0";
                strb.append("1");
            }
            else if(sum.contentEquals( "11"))
            {
                passingString  ="1";
                strb.append("0");
            }
            index1 --;
        }
        
        while(index2 > 0)
        {
            String sum = b.substring(index2 - 1 , index2) + passingString;
            
            if(sum.contentEquals("00"))
            {
                passingString ="0";
                strb.append("0");
            }
            else if (sum.contentEquals( "01") || sum.contentEquals( "10"))
            {
                passingString = "0";
                strb.append("1");
            }
            else if(sum.contentEquals("11"))
            {
                passingString = "1";
                strb.append("0");
            }
            index2 --;
        }
              
        if(passingString.contentEquals("1"))
        {
            strb.append("1");
        }
                  
        return strb.reverse().toString();
    }
    
    public static void main(String[] args)
    {
        String str1 = "1";
        String str2  ="111";
        
        System.out.println(addBinary(str1, str2));
    }
}
