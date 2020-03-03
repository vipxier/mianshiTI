package Chapter3;

import java.util.Stack;

public class SetOfStacks
{
    Stack<Stack<Integer>> stacks;
    int stackCapacity;
    int currenStackSize;
    
    public SetOfStacks(int capacity)
    {
        this.stackCapacity = capacity;
        currenStackSize = 0;
    }
    
    public void push(int value)
    {
        if(stacks.isEmpty())
        {
            Stack<Integer> tempStack = new Stack<Integer>();
            tempStack.push(value);
            stacks.push(tempStack);
        }
        else
        {
            if(stacks.peek().size() == stackCapacity)
            {
                Stack<Integer> newStack = new Stack<Integer>();
                newStack.push(value);
                stacks.push(newStack);
            } 
            else
            {
                stacks.peek().push(value);
            }
        }
    }
    
    public int pop()
    {
        if(stacks.isEmpty())
        {
             throw new IllegalArgumentException();
        }
        
        if(stacks.peek().isEmpty())
        {
            stacks.pop();
           return stacks.peek().pop();
        }
        else
        {
            return stacks.peek().pop();
        }
    }
    
    public int peek()
    {
        if(stacks.isEmpty())
        {
             throw new IllegalArgumentException();
        }
        
        if(stacks.peek().isEmpty())
        {
            stacks.pop();
           return stacks.peek().peek();
        }
        else
        {
            return stacks.peek().peek();
        }
    }
    
    public int popAt(int index)
    {
        if(index >= stacks.size())
        {
            throw new IllegalArgumentException();
        }
        
        Stack<Stack<Integer>> tempStack = new Stack<Stack<Integer>>();
        
        for(int i = 0; i < index; i ++)
        {
            tempStack.push(stacks.pop());
            
        }
        
        int value = stacks.peek().pop();
        while(!tempStack.isEmpty())
        {
            stacks.push(tempStack.pop());
        }
        return value;
    }
}
