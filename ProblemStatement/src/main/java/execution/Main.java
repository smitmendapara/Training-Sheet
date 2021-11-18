package execution;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            ExecuteThread executeThread1 = new ExecuteThread("Thread-1");

            executeThread1.start();

            ExecuteThread executeThread2 = new ExecuteThread("Thread-2");

            executeThread2.start();

            Runnable hello = new DisplayMessage("Hello");

            Thread thread1 = new Thread(hello);

            thread1.setDaemon(true);

            thread1.setName("hello");

            System.out.println("Starting hello thread...");

            thread1.start();

            Runnable goodbye = new DisplayMessage("Goodbye");

            Thread thread2 = new Thread(goodbye);

            thread2.setPriority(Thread.MIN_PRIORITY);

            thread2.setDaemon(true);

            System.out.println("Starting goodbye thread...");

            thread2.start();

            System.out.println("Starting thread3...");

            Thread thread3 = new GuessANumber(2);

            thread3.start();

            try
            {
                thread3.join();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

            System.out.println("Starting thread4...");

            Thread thread4 = new GuessANumber(5);

            thread4.start();

            System.out.println("main() is ending...");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
