import java.util.LinkedList;
import java.util.List;

public class ReverseInteger
{
    public static int reverse(int x) {
        if(Math.abs(x) < 10)
        {
            return x;
        }
        
        boolean negative = false;
        if(Math.abs(x) > x)
        {
            negative = true;
            x = Math.abs(x);
        }
        
        int result = 0;
        while(x / 10 > 0)
        {
            result  = result * 10 + x % 10;
            if(result >= Integer.MAX_VALUE / 10)
            {
                return 0;
            }
            x = (int) (x / 10);
        }
        result  = result * 10 + x;
        if(negative)
        {
            return 0 - result;
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        System.out.println(reverse(-1536643569));
    }
}
