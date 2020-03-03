package Chapter3;

import java.util.Stack;

public class Queue_Imp_TwoStacks
{
    Stack<Integer> addStack;
    Stack<Integer> pollStack;
    
    public Queue_Imp_TwoStacks()
    {
        this.addStack = new Stack<Integer>();
        this.pollStack = new Stack<Integer>();
    }
    
    public void add(int value)
    {
        toAddStack();
        addStack.push(value);
        toPollStack();
    }
    
    public int poll()
    {
        toPollStack();
        int value = pollStack.pop();
        toAddStack();
        return value;
    }
    
    private void toPollStack() {
        while(!addStack.isEmpty())
        {
            pollStack.push(addStack.pop());
        }
    }
    
    private void toAddStack() {
        while(!pollStack.isEmpty())
        {
            addStack.push(pollStack.pop());
        }
    }
}
