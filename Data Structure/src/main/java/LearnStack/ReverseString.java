package LearnStack;

import java.util.Stack;

public class ReverseString
{
    Stack<Character> stack = new Stack<Character>();

    public String reverse(String string) {

        for (char ch : string.toCharArray())
        {
            stack.push(ch);
        }

        System.out.println(stack.toString());

//        String reversed = "";
//
//        while (!stack.empty())
//        {
//            reversed += stack.pop();
//        }

        StringBuffer reversed = new StringBuffer();

        while (!stack.empty())
        {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}

class ReverseMain
{
    public static void main(String []args)
    {
        try
        {
            String string = "ABCD";

            ReverseString reverseString = new ReverseString();

            System.out.println(reverseString.reverse(string));
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
