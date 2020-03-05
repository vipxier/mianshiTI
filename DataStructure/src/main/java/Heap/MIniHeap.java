package Heap;

import java.util.Arrays;

public class MiniHeap {
	public int size;
	public int[] array;
	public int capacity;

	public MiniHeap(int capcacity) {
		this.size = 0;
		this.array = new int[size];
		this.capacity = capacity;
	}

	private void ensureCapacity() {
		if (size == capacity) {
			this.array = Arrays.copyOf(this.array, this.capacity * 2);
		}
	}

	private int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2;
	}

	private int getRightChildIndex(int parentIndex)
	{
		return parentIndex * 2 + 1;
	}_

	private int getParentIndex(int childIndex) {
		return (childIndex + 1) / 2;
	}

	private boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}

	private boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}
	
	private boolean hasParent(int childIndex)
	{
		return getParentIndex(childIndex) >= 0;
	}

	private int getLeftChild(int parentIndex) {
		return this.array[getLeftChildIndex(parentIndex)];
	}

	private int getRightChild(int parentIndex) {
		return this.array[getRightChildIndex(parentIndex)];
	}

	private int getParent(int childIndex) {
		return this.array[getParentIndex(childIndex)];
	}

	private void swap(int index1, int index2) {
		int temp = this.array[index1];
		this.array[index1] = this.array[index2];
		this.array[index2] = temp;
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}

		return array[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}

		int item = array[0];
		array[0] = array[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	private void heapifyDown() {
		int parentIndex = 0;
		while (hasLeftChild(parentIndex)) {
			int smallerChildIndex = getLeftChildIndex(parentIndex);
			if (hasRightChild(parentIndex) && getRightChild(parentIndex) < getLeftChild(parentIndex)) {
				smallerChildIndex = getRightChildIndex(parentIndex);
			}
			
			if (array[parentIndex] == array[smallerChildIndex]) {
				break;
			} else {
				swap(parentIndex, smallerChildIndex);
				parentIndex = smallerChildIndex;
			}
		}
	}
	
	private void heapifyUp()
	{
		int index = size - 1;
		
		while(hasParent(index))
		{
			
		}
	}
}
