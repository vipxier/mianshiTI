package Chapter3;

import java.util.Stack;

import utils.StackUtils;

public class OrderStack
{
    public static Stack<Integer> orderStack(Stack<Integer> input)
    {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> result = new Stack<Integer>();

        int size = input.size();

        while (result.size() < size)
        {

            if (input.isEmpty() && !stack.isEmpty())
            {
                int minimumNumber = Integer.MAX_VALUE;
                while (!stack.isEmpty())
                {
                    int temp = stack.pop();
                    input.push(temp);
                    if (minimumNumber >= temp)
                    {
                        minimumNumber = temp;
                    }
                }
                result.push(minimumNumber);
                remove(input, minimumNumber);
            }
            else if (!input.isEmpty() && stack.isEmpty())
            {
                int minimumNumber = Integer.MAX_VALUE;
                while (!input.isEmpty())
                {
                    int temp = input.pop();
                    stack.push(temp);
                    if (minimumNumber >= temp)
                    {
                        minimumNumber = temp;
                    }
                }
                result.push(minimumNumber);
                remove(stack, minimumNumber);
            }
        }

        return result;
    }
    
    private static void remove(Stack<Integer> stack, int valueToRemove)
    {
        Stack<Integer> temp = new Stack<Integer>();
        boolean canRemove = true;
        while(!stack.isEmpty())
        {
            int value = stack.pop();
            if(value == valueToRemove && canRemove)
            {
                canRemove = false;
            }
            else if((value == valueToRemove && !canRemove) || value != valueToRemove)
            {
                temp.push(value);
            }
        }
        
        while(!temp.isEmpty())
        {
            stack.push(temp.pop());
        }
    }

    public static void main(String[] args)
    {
        Stack<Integer> input = new Stack<Integer>();

        input.push(1);
        input.push(2);
        input.push(4);
        input.push(3);
        input.push(5);
        input.push(7);
        input.push(8);
        input.push(1);

        StackUtils.printStackInteger(orderStack(input));
    }
}
