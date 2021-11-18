package LearnSorting;

public class QuickSort
{
    public static void main(String []args)
    {
        int arr[] = { 10, 60, 30, 35, 50, 12 };

        int size = arr.length;

        quickSort(arr, 0, size - 1);

        print(arr, size);
    }

    private static void quickSort(int arr[], int start, int end)
    {
        if (start < end)
        {
            int part = partition(arr, start, end);

            quickSort(arr, start, part - 1);

            quickSort(arr, part + 1, end);
        }
    }

    private static int partition(int arr[], int start, int end)
    {
        int pivot = arr[end];

        int boundry = start - 1;

        for (int i = start; i < end; i++)
        {
            if (arr[i] < pivot)
            {
                boundry++;

                swap(arr, boundry, i);
            }
        }

        swap(arr, boundry + 1, end);

        return (boundry + 1);
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
