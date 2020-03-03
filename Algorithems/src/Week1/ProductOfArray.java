package Week1;

public class ProductOfArray
{
    public static int[] ArrayProduct(int[] arr)
    {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] result = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++)
        {
            left[i] = left[i - 1] * arr[i - 1];
        }

        for (int j = len - 2; j >= 0; j--)
        {
            right[j] = right[j + 1] * arr[j + 1];
        }

        for (int w = 0; w < len; w++)
        {
            result[w] = left[w] * right[w];
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        int[] array = {1,2,3,4};
      for(int i : ArrayProduct(array)) 
      {
          System.out.print(" " + i);
      }
    }
}
