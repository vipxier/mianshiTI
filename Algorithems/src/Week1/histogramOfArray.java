package Week1;

public class histogramOfArray
{
    public static void print(int[] array)
    {
        if(array == null || array.length == 0)
        {
            return;
        }
        int max = findMax(array);
        String[][] result = new String[max+1][array.length];
        
        for(int i = 0; i < result.length; i ++)
        {
            for(int j = 0;  j < result[i].length; j ++)
            {
                result[i][j] = " ";
            }
        }
        
        for(int i = 0; i < array.length; i ++)
        {
            for(int j = array[i]; j >= 0; j --)
            {
                result[j][i] = "*";
            }
        }
        
        StringBuilder currentLineBuilder = new StringBuilder();
        for(int i = result.length-1; i >= 0; i --)
        {
            currentLineBuilder.append(i).append(" | ");
            for(int j = 0; j < array.length; j ++)
            {
                if(j == 0)
                {
                    currentLineBuilder.append(result[i][j] + " ");
                }
                else {
                currentLineBuilder.append(" "+ result[i][j] + " ");
                }
            }
            
            System.out.println(currentLineBuilder.toString());
            currentLineBuilder.setLength(0);
        }
       
        currentLineBuilder.append("   ");
        for (int i = 0; i < array.length * 3; i ++)
        {
            currentLineBuilder.append("-");
        }
        System.out.println(currentLineBuilder.toString());
        currentLineBuilder.setLength(0);
        
        currentLineBuilder.append("   ");
        for (int i = 0; i < array.length; i ++)
        {
            currentLineBuilder.append(" " + array[i] + " ");
        }
        System.out.println(currentLineBuilder.toString());
    }

    private static int findMax(int[] array)
    {
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i ++)
        {
            maxValue = maxValue < array[i] ? array[i]: maxValue;
        }
        return maxValue;
    }
    
    public static void main(String[] args)
    {
        int[] array = {1,3,4,0,7,9,1};
        print(array);
    }
}
