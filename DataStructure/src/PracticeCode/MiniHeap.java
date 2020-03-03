package PracticeCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MiniHeap
{
    int[] items;
    int size = 0;
    int capacity;
    
    public MiniHeap(int cap)
    {
        this.capacity = cap;
        items = new int[cap];
    }
    
    private int getLeftChildIndex(int index)
    {
        return index * 2 + 1;
    }
    
    private int getRightChildIndex(int index)
    {
        return index * 2 + 2;
    }
    
    private int getParentIndex(int index)
    {
        return (index - 1) / 2;
    }
    
    private int getLeftChild(int index)
    {
        return items[getLeftChildIndex(index)];
    }
    
    private int getRightChild(int index)
    {
        return items[getRightChildIndex(index)];
    }
    
    private int getParent(int index)
    {
        return items[getParentIndex(index)];
    }
    
    private void EnsureCapacity()
    {
        if(size == capacity)
        {
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }
    
    private boolean hasParent(int index)
    {
        return (index - 1) / 2 < size;
    }
    
    private boolean hasLeftChild(int index)
    {
        return getLeftChildIndex(index) < size;
    }
    
    private boolean hasRightChild(int index)
    {
        return getRightChildIndex(index) < size;
    }
    
    private void swap(int index1, int index2)
    {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
    
    private void heapifyUp()
    {
        int index = size - 1;
        while(hasParent(index) && getParent(index) > items[index])
        {
            swap(getParentIndex(index), index);
        }
    }
    
    private void heapifyDown()
    {
        int index = 0;
        int smallerChildIndex = getLeftChildIndex(index);
        while(hasRightChild(index) && getRightChild(index) < items[smallerChildIndex])
        {
            smallerChildIndex = getRightChildIndex(index);
            if(items[index] < items[smallerChildIndex])
            {
                break;
            }
            else
            {
                swap(index, smallerChildIndex);
            }
        }
    }
    
    public int peek() {
        if(size == 0)
        {
            throw new IllegalStateException();
        }
        return items[0];
    }
    
    public void insert(int value) {
        EnsureCapacity();
        items[size] = value;
        size++;
        heapifyUp();
    }
    
    public int poll()
    {
        if(size == 0)
        {
            throw new IllegalStateException();
        }
        int result = items[0];
        items[0] = items[size-1];
        size --;
        heapifyDown(); 
        return result;
    }
}
