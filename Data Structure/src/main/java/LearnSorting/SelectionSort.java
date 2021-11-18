package LearnSorting;

public class SelectionSort
{
    public static void main(String []args)
    {
        int arr[] = { 20, 1, 3, 17, 5, 4 };

        int size = arr.length;

        selectionSort(arr, size);

        print(arr, size);
    }

    private static void selectionSort(int arr[], int size)
    {
        for (int i = 0; i < size; i++)
        {
            int minIndex = i;

            for (int j = i; j < size; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
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
