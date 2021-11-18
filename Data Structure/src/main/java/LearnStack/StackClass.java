package LearnStack;

import java.util.Stack;

public class StackClass
{
    public static void main(String[] args)
    {
        try
        {
            Stack<Integer> stack = new Stack<Integer>();

            stack.push(10);

            stack.push(20);

            stack.push(30);

            stack.push(40);

            System.out.println(stack);

            System.out.println(stack.peek());

            stack.pop();

            System.out.println(stack);

        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

