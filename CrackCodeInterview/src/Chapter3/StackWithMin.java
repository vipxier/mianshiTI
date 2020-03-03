package Chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class StackWithMin
{
    Stack<Integer> storage;
    List<Integer> orderedList;
    
    public StackWithMin()
    {
        storage = new Stack<Integer>();
        orderedList = new ArrayList<Integer>();
    }
    
    public void push(int data)
    {
        storage.push(data);
        orderedList.add(data);
        
        orderTheList();
    }
    
    public int pop()
    {
        int data  = storage.pop();
        orderedList.remove(orderedList.indexOf(data));
        orderTheList();
        return data;
    }
    
    public int min() {
        return orderedList.get(0);
    }
    
    private void orderTheList()
    {
        Collections.sort(orderedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1 - o2;
            }
        });
    }
    
    public static void main(String[] args)
    {
        StackWithMin stack = new StackWithMin();
        stack.push(4);
        stack.push(3);
        stack.push(20);
        stack.push(11);
        stack.push(2);
        stack.push(3);
        stack.push(10);
        
        System.out.println(stack.min());
        
        System.out.println(stack.pop());
        
        System.out.println(stack.min());
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        System.out.println(stack.min());
        
    }
}
