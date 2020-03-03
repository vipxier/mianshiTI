import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IsRotatioin
{
    public static boolean isRotation(String str1, String str2)
    {
        if (str1 == null || str2 == null || str1.length() != str2.length())
        {
            return false;
        }
        List<Character> list = new LinkedList<Character>();
        for (int i = 0; i < str1.length(); i++)
        {
            list.add(str1.charAt(i));
        }

        for (int i = str1.length() - 1; i >= 0; i--)
        {
            if (list.get(list.size() - 1 - i) != str2.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isRotation_2(String str1, String str2)
    {
        if (str1 == null || str2 == null || str1.length() != str2.length())
        {
            return false;
        }
        for (int i = 0; i < str1.length(); i++)
        {
            if (str1.charAt(i) != str2.charAt(str2.length() - 1 - i))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        String str1 = "abcdefghijk";
        String str2 = "kjihgfedcba";

        System.out.println(isRotation_2(str1, str2));
    }
}
