
public class LastWordLength
{
    public static int lengthOfLastWord(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        int lastSpaceLocation = -1;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
            {
                lastSpaceLocation = i;
            }
        }

        if (s.length() - lastSpaceLocation - 1 == 0)
        {
            return lengthOfLastWord(s.substring(0, lastSpaceLocation));
        }

        return s.length() - lastSpaceLocation - 1;
    }

    public static int lastWordLength_2(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        int lastSpaceIndex = s.lastIndexOf(' ');

        if (lastSpaceIndex + 1 == s.length())
        {
            return lastWordLength_2(s.substring(0, lastSpaceIndex));
        }
        else
        {
            return s.length() - lastSpaceIndex - 1;
        }
    }

    public static void main(String[] args)
    {
        String s = "     ";
        String s1 = "Hell";
        String s2 = "Hello w";
        String s3 = "Hello World";
        String s4 = "H  ";

        String s5 = "Hello World  ";

        System.out.println(lengthOfLastWord(s));

        System.out.println(lengthOfLastWord(s1));

        System.out.println(lengthOfLastWord(s2));

        System.out.println(lengthOfLastWord(s3));

        System.out.println(lengthOfLastWord(s4));
        System.out.println(lengthOfLastWord(s5));
        
        
        System.out.println(lastWordLength_2(s));

        System.out.println(lastWordLength_2(s1));

        System.out.println(lastWordLength_2(s2));

        System.out.println(lastWordLength_2(s3));

        System.out.println(lastWordLength_2(s4));
        System.out.println(lastWordLength_2(s5));
        
        
        
        
    }
}
