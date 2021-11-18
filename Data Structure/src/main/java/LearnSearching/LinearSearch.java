package LearnSearching;

import java.util.Scanner;

public class LinearSearch
{
    public static void main(String []args)
    {
        int array[] = { 10, 40, 30, 35, 50, 12 };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");

        int input = scanner.nextInt();

        int index = searchElement(array, array.length, input);

        System.out.println(index);
    }

    private static int searchElement(int []array, int size, int input)
    {
        for (int i = 0; i < size; i++)
        {
            if (array[i] == input)
            {
                return i;
            }
        }

        throw new IllegalArgumentException("No Match Found!!");
    }
}
