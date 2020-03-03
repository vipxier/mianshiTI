import java.util.Arrays;

import utils.ArrayUtils;

public class plusOneArray
{
    // 66

    public static int[] plusOne(int[] digits) {
        
        if(digits == null || digits.length == 0)
        {
            return new int[1];
        }
        int passingValue = 0;
        
        int[] result = new int[digits.length + 1];
        
        int sum  = digits[digits.length - 1] + 1;
        if(sum >= 10)
        {
            passingValue = 1;
            digits[digits.length - 1] = sum % 10;
        }
        else
        {
            digits[digits.length - 1] = sum;
        }
            
        for(int i = digits.length - 2; i >= 0; i --)
        {
            sum = passingValue + digits[i];
            
            if(sum >= 10)
            {
                passingValue = 1;
                digits[i] = sum % 10;
            }
            else
            {
                digits[i] = sum;
                passingValue = 0;
            }
        }
        
        if(passingValue == 1)
        {
            for(int i = 1; i < result.length; i ++)
            {
                result[i] = digits[i-1];
            }
            result[0] = 1;
            return result;
        }
        
        return digits;
        
    }
    
    public static void main(String[] args)
    {
        int[] array = {0};
        
        ArrayUtils.printSingleDimentionArray(plusOne(array));
        
        int[] array1 = {9};
        
        ArrayUtils.printSingleDimentionArray(plusOne(array1));
        
        int[] array2 = {2,2,2,2};
        
       ArrayUtils.printSingleDimentionArray(plusOne(array2));
       
       int[] array3 = {9,9,9,9};
       
       ArrayUtils.printSingleDimentionArray(plusOne(array3));
    }
    
}
