package LearnSorting;

public class InsertionSort
{
    public static void main(String []args)
    {
        int arr[] = { 10, 40, 30, 35, 50, 12 };

        insertionSort(arr, arr.length);

        print(arr, arr.length);
    }

    private static void insertionSort(int []arr, int size)
    {
        int key;

        for (int i = 1; i < size; i++)
        {
            int j = i - 1;

            key = arr[i];

            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];

                j--;
            }
            arr[j + 1] = key;
        }
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
