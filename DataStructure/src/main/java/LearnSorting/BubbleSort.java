package LearnSorting;

public class BubbleSort
{
    public static void main(String []args)
    {
        int arr[] = { 10, 60, 30, 35, 50, 12 };

        bubbleSort(arr, arr.length);

        print(arr, arr.length);
    }

    private static void bubbleSort(int arr[], int size)
    {
        for (int i = 0; i < size - 1; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                if (arr[i] > arr[j])
                {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int []arr, int size)
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i]);

            if (size - 1 != i)
            {
                System.out.print(", ");
            }
        }

    }
}
