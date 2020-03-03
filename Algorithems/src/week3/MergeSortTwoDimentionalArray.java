package week3;
import utils.ArrayUtils;

public class MergeSortTwoDimentionalArray
{

    public static int[][] mergeSort(int[][] array)
    {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[][] array, int start, int end)
    {
        if (start < end)
        {
            int mid = start + (end - start) / 2;
            sort(array, 0, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[][] array, int start, int mid, int end)
    {
        int[][] left = new int[mid - start + 1][2];
        int[][] right = new int[end - mid][2];

        for (int i = 0; i < left.length; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                left[i][j] = array[start + i][j];
            }
        }

        for (int i = 0; i < right.length; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                right[i][j] = array[mid + 1 + i][j];
            }
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = start;
        while (leftIndex < left.length && rightIndex < right.length)
        {
            if (left[leftIndex][0] < right[rightIndex][0])
            {
                array[resultIndex][0] = left[leftIndex][0];
                array[resultIndex][1] = left[leftIndex][1];
                leftIndex++;
            }
            else if (left[leftIndex][0] == right[rightIndex][0])
            {
                if (left[leftIndex][1] <= right[rightIndex][1])
                {
                    array[resultIndex][0] = left[leftIndex][0];
                    array[resultIndex][1] = left[leftIndex][1];
                    leftIndex++;
                }
                else
                {
                    array[resultIndex][0] = right[rightIndex][0];
                    array[resultIndex][1] = right[rightIndex][1];
                    rightIndex++;
                }
            }
            else
            {
                array[resultIndex][0] = right[rightIndex][0];
                array[resultIndex][1] = right[rightIndex][1];
                rightIndex++;
            }

            resultIndex++;
        }

        while (leftIndex < left.length)
        {
            array[resultIndex][0] = left[leftIndex][0];
            array[resultIndex][1] = left[leftIndex][1];
            resultIndex++;
            leftIndex++;
        }

        while (rightIndex < right.length)
        {
            array[resultIndex][0] = right[rightIndex][0];
            array[resultIndex][1] = right[rightIndex][1];
            resultIndex++;
            rightIndex++;
        }
    }

    public static void main(String[] args)
    {
        int[][] array = { { 8, 9 }, { 2, 3 }, { 7, 10 }, { 2, 5 }, { 7, 8 } };

        ArrayUtils.printDoubleDimentionArray(array);
        mergeSort(array);

        ArrayUtils.printDoubleDimentionArray(array);

    }
}
