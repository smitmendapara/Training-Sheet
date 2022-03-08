package atmMachine;

/**
 * Created by smit on 8/3/22.
 */
public class MoneyTransfer
{
    public static void main(String[] args)
    {
        try
        {
            int []array = { 2000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };

            int []result = new int[array.length];

            int money = 68532;

            int i = 0, dividend = 0;

            calculateNotes(i, money, dividend, array, result);

            printNotes(array, result);
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private static void printNotes(int[] array, int[] result)
    {
        for (int i = 0; i < result.length; i++)
        {
            System.out.println(array[i] + " : " + result[i]);
        }
    }

    private static void calculateNotes(int i, int money, int dividend, int[] array, int[] result)
    {
        try
        {
            while (i < array.length)
            {
                if (money / array[i] > 0)
                {
                    dividend = (int) Math.ceil(money / array[i]);

                    money -= dividend * array[i];

                    result[i] = dividend;
                }

                i++;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
