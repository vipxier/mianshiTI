package Queue;

public class GuessingGame{
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        
        while(start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            if(guess(mid) == 0)
            {
                return mid;
            }
            else if(guess(mid) == 1)
            {
                end = mid;
            }
            else if(guess(mid) == -1)
            {
                start = mid;
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
        
        return -1;
    }
    
    private int guess(int num)
    {
    	if(num < 6)
    	{
    		return -1;
    	}
    	else if(num > 6)
    	{
    		return 1;
    	}
    	else
    	{
    		return 0;
    	}
    }
    
    public static void main(String[] args)
    {
    	GuessingGame game = new GuessingGame();
    	System.out.println(game.guessNumber(10));
    }
}
