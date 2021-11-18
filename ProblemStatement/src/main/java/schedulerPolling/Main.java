package schedulerPolling;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Scheduler scheduler = new Scheduler();

            Thread thread1 = new Thread(scheduler);

            thread1.start();

            Thread[] threads = new Thread[5];

            for (int index = 0; index <= 4; index++)
            {
                threads[index] = new Thread(new Polling());

                threads[index].start();
            }

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
