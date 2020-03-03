package EasyQuestions;

public class MaxProfit {
	public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i ++)
        {
            maxProfit = maxValueAfterIndex(prices, i) > maxProfit ? maxValueAfterIndex(prices, i): maxProfit;
        }
        return maxProfit;
    }
    
    private static int maxValueAfterIndex(int[] prices, int index)
    {
        int maxValue = 0;
        int indexValue = prices[index];
        for(int i = index+1; i < prices.length; i ++)
        {
            if(prices[i] - indexValue > maxValue)
            {
                maxValue = prices[i] - indexValue;
            }
        }
        return maxValue;
    }
    
    public static int maxProfit_DP(int[] prices)
    {
    	int len = prices.length;
    	int[][] profits = new int[len][len];
    	int maxProfit = 0;
    	
    	for(int buyDay = 0; buyDay < len; buyDay ++)
    	{
    		for(int sellDay = buyDay+1; sellDay < len; sellDay ++)
    		{
    			profits[buyDay][sellDay] = Math.max(prices[sellDay]-prices[buyDay], 0);
    			if(profits[buyDay][sellDay] > maxProfit)
    			{
    				maxProfit = profits[buyDay][sellDay];
    			}
    		}
    	}
    	return maxProfit;

    }
    
    public static void main(String[] args)
    {
    	int[] prices = {7,2,5,3,6,4};
    	int maxProfit = maxProfit_DP(prices);
    	System.out.println(maxProfit);
    }
    
}
