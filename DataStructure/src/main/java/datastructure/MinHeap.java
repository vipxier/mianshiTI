package datastructure;

import java.util.Arrays;

public class MinHeap {
	private int size;
	private int capacity;
	private int[] array;

	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.array = new int[size];
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;
	}

	private boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}

	private boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}

	private boolean hasParent(int childIndex) {
		return getParentIndex(childIndex) >= 0;
	}

	private int getParent(int childIndex) {
		if (hasParent(childIndex)) {
			return array[getParentIndex(childIndex)];
		}

		throw new IllegalStateException();
	}

	private int getLeftChild(int parentIndex) {
		if (hasLeftChild(parentIndex)) {
			return array[getLeftChildIndex(parentIndex)];
		}

		throw new IllegalStateException();
	}

	private void swap(int index1, int index2) {
		int temp = this.array[index1];
		this.array[index1] = array[index2];
		array[index2] = temp;
	}

	private void ensureCapacity() {
		if (size == capacity) {
			this.array = Arrays.copyOf(this.array, 2 * capacity);
			capacity *= 2;
		}
	}

	private int getRightChild(int parentIndex) {
		if (hasRightChild(parentIndex)) {
			return array[getRightChildIndex(parentIndex)];
		}

		throw new IllegalStateException();
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}

		return this.array[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}

		int item = this.array[0];
		this.array[0] = this.array[size - 1];
		heapifyDown();
		size--;
		return item;
	}

	public void insert(int item) {
		ensureCapacity();
		this.array[size] = item;
		this.size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && getParent(index) > array[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index) && getLeftChild(index) < this.array[index]) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && array[getLeftChildIndex(index)] > array[getRightChildIndex(index)]) {
				smallerChildIndex = getRightChildIndex(index);
				if (array[index] < array[smallerChildIndex]) {
					break;
				} else {
					swap(index, smallerChildIndex);
				}
				index = smallerChildIndex;
			}
		}
	}
}
