package balls;

/**
 * Created by smit on 8/3/22.
 */
public class MinimumTry
{
    public static void main(String[] args)
    {
        try
        {
            int array[] = { 1, 1, 2, 1, 1, 1, 1, 1 };

            int count = countTry(array, array.length);

            System.out.println(count);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private static int countTry(int array[], int size)
    {
        int first = 0;

        int last = size - 1;

        int mid;

        int current, response;

        try
        {
            while (first < last)
            {
                current = last * 2 / 3;

                mid = ( first + last ) / 2;

                response = checkPortion(array, first, mid, last);

                if (response == 1)
                {
                    first = mid + 1;

                    last = current;
                }

                if (response == -1)
                {
                    last = mid;
                }

                if (response == 0)
                {
                    first = current + 1;
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return first;
    }

    private static int checkPortion(int[] array, int first, int mid, int last)
    {
        int result = 0;

        try
        {
            int leftPortion = 0;

            int rightPortion = 0;

            int midElement = mid + 1;

            for (int i = first; i <= mid; i++)
            {
                leftPortion += array[first++];
            }

            for (int i = midElement; i <= last; i++)
            {
                rightPortion += array[midElement++];
            }

            if (leftPortion < rightPortion)
            {
                result = 1;
            }

            else if (leftPortion > rightPortion)
            {
                result = -1;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return result;
    }
}
