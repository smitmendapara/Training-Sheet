package Thread;

public class LearnThread extends Thread
{
    public static int value = 10;

    public static void main(String []args)
    {
        try
        {
            LearnThread thread = new LearnThread();

            thread.start();

            // handle thread part

            while (thread.isAlive())
                System.out.println("Waiting...");

            System.out.println("Value : " + value);

            value++;

            System.out.println("Value : " + value);

            System.out.println("Outside the Thread Part!!");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void run()
    {
        value++;
    }
}
