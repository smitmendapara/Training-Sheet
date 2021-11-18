package termination;

public class StopWithInterrupts implements Runnable
{
    @Override
    public void run()
    {
        while (!Thread.interrupted())
        {
            System.out.println("Thread is Running...");
        }
        System.out.println("Thread is Stopped!!");
    }
}
