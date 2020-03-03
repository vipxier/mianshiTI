package Chapter3;

import java.util.Arrays;

public class Stack_Array_Imp
{
    int size;
    Object[] objects;
    int lastElementLocation;
    
    public Stack_Array_Imp(int size)
    {
        this.size  = size;
        objects = new Object[size];
        lastElementLocation = -1;
    }
    
    private void ensureSize()
    {
        if(lastElementLocation + 1 == size )
        {
            objects = Arrays.copyOf(objects, size * 2);
        }
    }
    
    private void moveForward()
    {
        for(int i = 0; i < lastElementLocation; i ++)
        {
            objects[i] = objects[i+1];
        }
    }
    
    public void enqueue(Object data)
    {
        ensureSize();
        objects[++lastElementLocation] = data;
    }
    
    
    public Object dequeue()
    {
        if(lastElementLocation >= 0)
        {
            Object data = objects[0];
            moveForward();
            lastElementLocation --;
            return data;
        }
        else
        {
            return null;
        }
    }
}
