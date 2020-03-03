package Chapter3;

import java.util.Arrays;

public class StackArray_Impl
{
    Object[] elements;
    int topElementLocation;
    int capacity;

    public StackArray_Impl(int capacity)
    {
        this.capacity = capacity;
        elements = new Object[capacity];
        topElementLocation = -1;
    }

    public void push(Object data)
    {
        ensureCapacity();
        elements[++topElementLocation] = data;
    }
    
    public Object pop()
    {
        if(topElementLocation >= 0)
        {
            Object data = elements[topElementLocation];
            topElementLocation --;
            return data;
        }
        return null;
    }
    
    public Object peek()
    {
        if(topElementLocation >= 0)
        {
            return elements[topElementLocation];
        }
        return null;
    }

    public int size()
    {
        return topElementLocation + 1;
    }
    
    public int getCapacity()
    {
        return capacity;
    }
    private void ensureCapacity()
    {
        capacity *= 2;
        if (topElementLocation + 1 == capacity)
        {
            elements = Arrays.copyOf(elements, capacity * 2);
        }
        
    }
    
    public static void main(String[] args)
    {
        StackArray_Impl stack = new StackArray_Impl(5);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
