package datastructure;

public class Queue {
	private int start;
	private int end;
	private int size;
	private int[] array;
	
	public Queue(int size)
	{
		this.start = -1;
		this.end = -1;
		this.size = size;
		this.array = new int[size];
	}
	
	public boolean isEmpty()
	{
		return start == -1;
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			return -1;
		}
		
		return this.array[0];
	}
	
	
	private boolean isFull()
	{
		return start == 0 && end == size - 1;
	}
	
	public void offer(int number)
	{
		if(isFull())
		{
			System.out.println("Queue is full");
			return;
		}
		
		if(start == -1)
		{
			start = 0;
		}
		
		this.array[++ end] = number;
		size ++;
	}
	
	public int poll()
	{
		if(isEmpty())
		{
			System.out.println("It is empty!");
			return -1;
		}
		
		int item = this.array[0];
		if(start >= end)
		{
			start = -1;
			end = -1;
		}
		start ++;
		return item;
	}
}
