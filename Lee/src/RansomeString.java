import java.util.Arrays;

import javax.lang.model.util.ElementScanner6;

public class RansomeString
{
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null || ransomNote.length() == 0 || magazine.length() == 0 || ransomNote.length() > magazine.length())
        {
            return false;
        }
        
        char[] ransomeArray = ransomNote.toCharArray();
        char[] magzineArray = magazine.toCharArray();
        
        Arrays.sort(ransomeArray);
        Arrays.sort(magzineArray);
        
        int index1 = 0, index2 = 0;
        
        while(index1 < ransomeArray.length && index2 < magzineArray.length)
        {
            if(ransomeArray[index1] < magzineArray[index2])
            {
                return false;
            }
            else if(ransomeArray[index1] > magzineArray[index2])
            {
                index2 ++;
            }
            else 
            {
            index1 ++;
            index2 ++;
            } 
        }
        
        return index1 == ransomeArray.length;
    }

    public static void main(String[] args)
    {
        String a = "aaaaa";
        String b  ="aabbacdadafwfasdljaFaA";

        System.out.println(canConstruct(a, b));
    }
}