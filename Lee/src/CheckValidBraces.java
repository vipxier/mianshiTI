import java.util.Stack;

public class CheckValidBraces
{
 public static boolean isValid(String s) {
        
        if(s == null || s.length() == 0)
        {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i ++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
            {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && stack.pop() !='(')
            {
                return false;
            }
            else if(s.charAt(i) == '}' && stack.pop() != '{')
            {
                return false;
            }
            else if(s.charAt(i) == ']' && stack.pop() != '[')
            {
                return false;
            }
        }
        
        return stack.isEmpty();
 }
 
 public static void main(String[] args)
 {
     String str = "{{{[()[](([]))]}}}";
     System.out.println(isValid(str));
 }
}
