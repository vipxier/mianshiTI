package Week1;

import utils.ArrayUtils;

public class Reorder_an_array_according_to_given_indexes
{
    public static int[] reorder(int[] dataArray, int[] indexArray)
    {
        if (dataArray == null || indexArray == null || dataArray.length != indexArray.length)
        {
            return null;
        }

        if (dataArray.length == 0)
        {
            return new int[0];
        }

        mergeSort(dataArray, indexArray, 0, dataArray.length - 1);

        return dataArray;
    }

    private static void mergeSort(int[] dataArray, int[] indexArray, int start, int end)
    {
        if (start < end)
        {
            int mid = start + (end - start) / 2;

            mergeSort(dataArray, indexArray, start, mid);
            mergeSort(dataArray, indexArray, mid + 1, end);
            //merge(dataArray, indexArray, start, mid, end);
            merge_twoArrays(dataArray, indexArray, start, mid, end);
        }
    }

    private static void merge(int[] dataArray, int[] indexArray, int start, int mid, int end)
    {
        int pointer1 = start, pointer2 = mid + 1, dataArrayPointer = start,
                indexArrayPointer = start;
        int[] tempDataArray = new int[end+1];
        int[] tempIndexArray = new int[end+1];

        while (pointer1 <= mid && pointer2 <= end)
        {
            if (indexArray[pointer1] <= indexArray[pointer2])
            {
                tempDataArray[dataArrayPointer++] = dataArray[pointer1];
                tempIndexArray[indexArrayPointer++] = indexArray[pointer1];
                pointer1++;
            }
            else
            {
                tempDataArray[dataArrayPointer++] = dataArray[pointer2];
                tempIndexArray[indexArrayPointer++] = indexArray[pointer2];
                pointer2++;
            }
        }

        while (pointer1 <= mid)
        {
            tempDataArray[dataArrayPointer++] = dataArray[pointer1];
            tempIndexArray[indexArrayPointer++] = indexArray[pointer1];
            pointer1++;
        }

        while (pointer2 <= end)
        {
            tempDataArray[dataArrayPointer++] = dataArray[pointer2];
            tempIndexArray[indexArrayPointer++] = indexArray[pointer2];
            pointer2++;
        }

        for (int i = start; i <= end; i++)
        {
            dataArray[i] = tempDataArray[i];
            indexArray[i] = tempIndexArray[i];
        }
    }
    
    
    private static void merge_twoArrays(int[] dataArray, int[] indexArray, int start, int mid, int end)
    {
        int pointer1 = 0, pointer2 = 0, resultPointer = start;
        
        int[] leftDataArray = utils.ArrayUtils.initializeArrayFromParent(dataArray, start, mid);
        int[] rightDataArray = utils.ArrayUtils.initializeArrayFromParent(dataArray, mid+1, end);
        
        int[] leftIndexArray = utils.ArrayUtils.initializeArrayFromParent(indexArray, start, mid);
        int[] rightIndexArray = utils.ArrayUtils.initializeArrayFromParent(indexArray, mid+1, end);
        
        while(pointer1 < leftIndexArray.length && pointer2 < rightIndexArray.length)
        {
            if(leftIndexArray[pointer1] <= rightIndexArray[pointer2])
            {
                indexArray[resultPointer] = leftIndexArray[pointer1];
                dataArray[resultPointer] = leftDataArray[pointer1];
                pointer1++;
            }
            else
            {
                indexArray[resultPointer] = rightIndexArray[pointer2];
                dataArray[resultPointer] = rightDataArray[pointer2];
                pointer2++;
            }
            resultPointer++;
        }
        
        while(pointer1 < leftIndexArray.length)
        {
            indexArray[resultPointer] = leftIndexArray[pointer1];
            dataArray[resultPointer] = leftDataArray[pointer1];
            pointer1++;
            resultPointer++;
        }
        
        while(pointer2 < rightIndexArray.length)
        {
            indexArray[resultPointer] = rightIndexArray[pointer2];
            dataArray[resultPointer] = rightDataArray[pointer2];
            pointer2++;
            resultPointer++;
        }
    }

    public static void main(String[] args)
    {
        int[] dataArray = { 1, 2, 3, 4, 5 };
        int[] indexArray = { 2, 4, 3, 0, 1 };

        ArrayUtils.printSingleDimentionArray(reorder(dataArray, indexArray));
    }
}
