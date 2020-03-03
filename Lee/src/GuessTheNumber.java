import javax.lang.model.util.ElementScanner6;

public class GuessTheNumber
{
    public static int guessNumber(int n) {
        int start  = 1, end = n;
        int result  = 0;
        
        while(start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            
            if(guess(mid) == -1)
            {
                start = mid;
            }
            else if(guess(mid) == 1)
            {
                end = mid;
            }
            else if (guess(mid) == 0)
            {
                result = mid;
                break;
            }
        }
        
        if(guess(start) == 0)
        {
            return start;
        }

        if(guess(end) == 0)
        {
            return end;
        }
           
        return result;
    }

    private static int guess(int number)
    {
        if(number == 11)
        {
            return 0;
        }
        else if(number > 11)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(guessNumber(10));
    }
}