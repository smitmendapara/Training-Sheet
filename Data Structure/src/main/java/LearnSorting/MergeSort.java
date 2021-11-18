package LearnSorting;

public class MergeSort
{
    public static void main(String []args) {
        int arr[] = {2, 1, 10, 4, 22, 5};

        mergeSort(arr);

        print(arr, arr.length);
    }

    private static void mergeSort(int arr[])
    {
        // partition

        int size = arr.length;

        if (size < 2)
        {
            return;
        }

        int middle = size / 2;

        int leftArray[] = new int[middle];

        for (int i = 0; i < middle; i++)
        {
            leftArray[i] = arr[i];
        }

        int rightArray[] = new int[size - middle];

        for (int i = middle; i < size; i++)
        {
            rightArray[i - middle] = arr[i];
        }

        // short each half

        mergeSort(leftArray);

        mergeSort(rightArray);

        // merge element

        merge(leftArray, rightArray, arr);
    }

    private static void merge(int leftArray[], int rightArray[], int resultArray[])
    {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length)
        {
            if (leftArray[i] <= rightArray[j])
            {
                resultArray[k++] = leftArray[i++];
            }
            else
            {
                resultArray[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length)
        {
            resultArray[k++] = leftArray[i++];
        }

        while (j < rightArray.length)
        {
            resultArray[k++] = rightArray[j++];
        }
    }

    private static void print(int arr[], int size)
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

