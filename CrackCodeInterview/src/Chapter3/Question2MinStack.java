package Chapter3;

import java.util.Stack;

public class Question2MinStack {
	
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public Question2MinStack()
	{
		this.minStack = new Stack<Integer>();
		this.stack = new Stack<Integer>();
	}
	
	public void push(int value)
	{
		stack.push(value);
		
		if(minStack.isEmpty())
		{
			minStack.push(value);
		}
		else
		{
			if(minStack.peek() < value)
			{
				minStack.push(minStack.peek());
			}
			else
			{
				minStack.push(value);
			}
		}
	}
	
	public int pop()
	{
		if(stack.isEmpty())
		{
			return -1;
		}
		else
		{
			minStack.pop();
			return stack.pop();
		}
	}
	
	
	public int getMini()
	{
		if(minStack.isEmpty())
		{
			return -1;
		}
		else
		{
			stack.pop();
			return minStack.pop();
		}
	} 
	
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	
}
