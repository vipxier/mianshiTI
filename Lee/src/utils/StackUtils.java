package utils;

import java.util.Stack;

public class StackUtils
{
    public static void printStack(Stack<TreeNode> stack)
    {
        StringBuilder strb = new StringBuilder();
        while(!stack.isEmpty())
        {
            strb.append(" ").append(stack.pop().val);
        }
        System.out.println(strb.toString());
    }
    
    public static void printStackE(Stack<?> stack)
    {
        StringBuilder strb = new StringBuilder();
        while(!stack.isEmpty())
        {
            strb.append(" ").append(stack.pop().toString());
        }
        System.out.println(strb.toString());
    }
}
