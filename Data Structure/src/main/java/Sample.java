import java.util.LinkedList;

class Solution
{
    public static void main(String[] args)
    {
        String str = "pwwkew";

        System.out.println(lengthOfLongestSubstring(str));

    }

    public static int lengthOfLongestSubstring(String s)
    {

        int max = 1;

        int size = s.length();

        int index = 0;

        int repeat = 0;

        int check;

        if (size == 0)
        {
            return 0;
        }

        char array[] = s.toCharArray();

        LinkedList<Character> list = new LinkedList<Character>();

        while (index < size)
        {
            while (list.contains(array[index]))
            {
                list.remove(list.getFirst());

                repeat++;
            }

            list.add(array[index]);

            index++;

            check = index - repeat;

            if (check > max)
            {
                max = check;
            }
        }

        return max;

    }
}