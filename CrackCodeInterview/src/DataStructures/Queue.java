package DataStructures;

public class Queue
{
    StackNode first, last;
    
    public void enqueue(Object data)
    {
        if(first == null)
        {
            first = new StackNode(data);
            last = first;
        }
        else
        {
            last.next = new StackNode(data);
            last = last.next;
        }
    }
    
    public Object dequeue()
    {
        if(first != null)
        {
            Object data = first.data;
            first = first.next;
            return data;
        }
        return null;
    }
}
