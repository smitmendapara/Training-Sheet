package LearnSearching;

import java.util.Scanner;

public class BinarySearch
{
    public static void main(String []args)
    {
        int array[] = { 10, 22, 26, 49, 55, 80 };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");

        int input = scanner.nextInt();

        int index = searchElement(array, array.length, input);

        System.out.println(index);
    }

    private static int searchElement(int array[], int size, int input)
    {
        int front = 0;

        int end = size - 1;

        int mid;

        while (front <= end)
        {
            mid = (front + end) / 2;

            if (input < array[mid])
            {
                end = mid - 1;
            }

            else if (input > array[mid])
            {
                front = mid + 1;
            }

            else
            {
                return mid;
            }
        }

        throw new IllegalArgumentException("No Match Found!!");
    }
}
