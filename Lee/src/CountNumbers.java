
public class CountNumbers
{

    public static String countAndSay(int n)
    {
        String start = "1";

        for (int i = 1; i < n; i++)
        {
            start = createCount(start);
        }
        return start;
    }

    private static String createCount(String source)
    {
        if (source.length() == 1)
        {
            return "1" + source;

        }
        StringBuilder strb = new StringBuilder();
        int counter = 1;
        int pointer = 0;
        for (pointer = 0; pointer < source.length() - 1; pointer++)
        {
            if (source.charAt(pointer) != source.charAt(pointer + 1))
            {
                strb.append(counter).append(source.charAt(pointer));
                counter = 1;

            }
            else
            {
                counter++;
            }
        }

        if (pointer < source.length())
        {
            strb.append(counter).append(source.charAt(source.length() - 1));
        }
        return strb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(countAndSay(0));
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
