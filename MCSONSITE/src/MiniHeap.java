import java.util.Arrays;

public class MiniHeap {
	private int capacity;
	private int size;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex)
	{
		return parentIndex * 2 + 1;
	}
	
	private int getRightChildIndex(int parentIndex)
	{
		return parentIndex * 2 + 2;
	}
	
	private int getParentIndex(int childIndex)
	{
		return (childIndex - 1) / 2;
	}
	
	private boolean hasLeftChild(int index)
	{
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index)
	{
		return getRightChildIndex(index) < size;
	}
	
	private boolean hasParent(int index)
	{
		return getParentIndex(index) >= 0;
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
	
	private void swap(int index1, int index2)
	{
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
	
	private void ensureCapacity()
	{
		if(capacity == size)
		{
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	private int peek()
	{
		if(size == 0)
		{
			throw new IllegalStateException();
		}
		return items[0];
	}
	
	private int poll()
	{
		if(size == 0)
		{
			throw new IllegalStateException();
		}
		int item = items[0];
		size --;
		items[0] = items[items.length - 1];
		heapifyDown();
		return item;
	}
	
	private void offer(int value)
	{
		ensureCapacity();
		items[size] = value;
		size ++;
		heapifyUp();
		
	}
	
	private void heapifyUp()
	{
		int item = items[size - 1];
		int currentIndex = size - 1;
		while(hasParent(currentIndex) && item < getParent(currentIndex))
		{
			swap(currentIndex, getParentIndex(currentIndex));
			currentIndex = getParentIndex(currentIndex);
		}
	}
	
	private void heapifyDown()
	{
		int item = items[0];
		int currentIndex = 0;
		while(hasLeftChild(currentIndex))
		{
			int smallerChildIndex = getLeftChildIndex(currentIndex);
			if(hasRightChild(currentIndex) && getLeftChild(currentIndex) > getRightChild(currentIndex))
			{
				smallerChildIndex = getRightChildIndex(currentIndex);
			}
			
			if(item < items[smallerChildIndex])
			{
				break;
			}
			else
			{
				swap(currentIndex, smallerChildIndex);
			}
			currentIndex = smallerChildIndex;
		}
	}
}
