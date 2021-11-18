package LearnStack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression
{
    Stack<Character> stack = new Stack<Character>();

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public boolean checkExpression(String string)
    {
        for (char ch : string.toCharArray())
        {
            if (isLeftBracket(ch))
            {
                stack.push(ch);
            }

            else if (isRightBracket(ch))
            {
                if (stack.empty())
                {
                    return false;
                }

                char top = stack.pop();

                if (!bracketsMatch(top, ch))
                {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch)
    {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch)
    {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right)
    {
        return  (left == '(' && right == ')') ||
                (left == '<' && right == '>') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}') ;
    }
}

class BalancedMain
{
    public static void main(String []args)
    {
        try
        {
            String string = "(<1 + 2>)";

            BalancedExpression balancedExpression = new BalancedExpression();

            boolean expression = balancedExpression.checkExpression(string);

            System.out.println(expression);
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

