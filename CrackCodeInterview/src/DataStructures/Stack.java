package DataStructures;

public class Stack
{
    StackNode top;
    
    public Object pop() {
        if(top != null)
        {
            Object data = top.data;
            top = top.next;
            return data;
        }
        return null;
    }
    
    public void push(Object data)
    {
        StackNode newTop = new StackNode(data);
        newTop.next = top;
        top = newTop;
    }
    
    public Object peek() {
        return top.data;
    }
}
