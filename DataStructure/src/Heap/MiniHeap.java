package Heap;

public class MiniHeap {
	int size = 0;
	int capacity = 10;

	int[] items = new int[capacity];

	private int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}

	private int getRightChildIndex(int index) {
		return 2 * index + 2;
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void EnsureCapacity() {
		if (size == capacity) {
			items = new int[capacity * 2];
			capacity *= 2;
		}
	}

	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}

			if (items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index)) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		return items[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	public void add(int value) {
		EnsureCapacity();
		items[size] = value;
		size++;
		heapifyUp();
	}
}
